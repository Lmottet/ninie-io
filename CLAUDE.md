# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

`ninie-io` is a mono-repo containing:
- **Backend** — Kotlin/Spring Boot Discord bot + REST API, hosted on [Render](https://render.com)
- **Frontend** — React SPA (Vite, TanStack Router, Mantine UI) in `frontend/`, hosted on [Netlify](https://netlify.com)

The backend responds to `!commands`, reacts to messages, sings songs, and exposes a session-cookie-authenticated REST API for library/review management.

## Frontend

```bash
cd frontend
npm install
npm run dev      # dev server on :4000
npm run build    # production build → dist/
```

Netlify is configured via `netlify.toml` at the repo root (base dir `frontend/`, publish `dist/`).  
For local dev against a local backend, set `VITE_API_URL` in `frontend/.env.local`.

## Backend Build & Run

Uses Maven wrapper with Java 24 and Kotlin 2.2.21 on Spring Boot 4.0.0.

```bash
# Build all modules
./mvnw clean package -DskipTests

# Build only the runnable api module (what Docker does)
./mvnw clean package -pl api -am -DskipTests

# Run tests
./mvnw test

# Run a single test class
./mvnw test -pl api -Dtest=NinieIoTests

# Run the app locally (requires env vars below)
./mvnw spring-boot:run -pl api
```

Required environment variables at runtime:
- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` — PostgreSQL connection
- `BOT_TOKEN` — Discord bot token
- `PORT` — HTTP port (defaults to `10000`)
- `JWT_SECRET` — for API authentication

## Module Architecture

The project is a 4-module Maven multi-module build with a strict dependency chain:

```
data  ←  business  ←  api (Spring Boot main)
  ↑                      ↑
  └──────  discord  ──────┘
```

- **`data`**: JPA entities, Spring Data repositories, static song data (`data/songs/`), and shared constants (`CommandNames`, `Emojis`, `MagicStrings`). H2 available at runtime; PostgreSQL used in production.
- **`business`**: Service layer operating on `data`. Handles users, library (authors/books/series), and reviews. No Discord or web dependencies.
- **`discord`**: Discord4J integration. Contains event listeners (`MessageCreateListener`, `MessageUpdateListener`), command implementations in `interactions/commands/impl/`, scheduled jobs (`interactions/scheduled/`), and passive reaction services (greeting, triggered, repeater, random).
- **`api`**: Spring Boot entry point (`NinieIo.kt`). REST controllers under `controllers/admin/` (authenticated) and `controllers/anonymous/`. Spring Security with stateless JWT auth. CORS locked to the Render origin.

## Discord Command Pipeline

1. `MessageCreateListener` receives every message
2. If the message starts with the bot prefix (`!`), it extracts the alias and delegates to `AliasService` → mapped `CommandBase`
3. Otherwise, `RespondableMapperServiceImpl` tries in order: greeting → triggered response → repeater → random response
4. Commands are in `discord/interactions/commands/impl/` and implement `CommandBase` (→ `NinieRespondable`)

## REST API Security

- `/ping`, `/auth/login`, `/auth/logout` are public; all other endpoints require an authenticated session
- Auth uses HTTP-only session cookies (`SameSite=None; Secure` for cross-origin Netlify↔Render)
- `POST /auth/login` authenticates and creates the session; `POST /auth/logout` invalidates it
- CORS is restricted to the Netlify frontend origin (`appsecurity.allowedOrigin` in config)
- For local dev (`http://localhost`), override `server.servlet.session.cookie.secure=false` and `same-site=lax` in `application-local.yml`

## Key Conventions

- All source directories are `src/main/kotlin` (not the Maven default `src/main/java`)
- JPA entities use `@Entity` / `@Embeddable` / `@MappedSuperclass` — the Kotlin `no-arg` compiler plugin generates the required no-arg constructors automatically
- `spring` compiler plugin is active for all-open proxying of Spring beans
- `ddl-auto: create` in `application.yml` — schema is recreated on every start; intentional during the current POC phase
- `StartupRunner.kt` seeds a default admin user on every startup; also intentional for POC
