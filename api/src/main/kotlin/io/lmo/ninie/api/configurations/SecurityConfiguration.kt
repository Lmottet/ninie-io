package io.lmo.ninie.api.configurations

import io.lmo.ninie.api.interfaces.IJwtTokenProvider
import io.lmo.ninie.api.security.ApiKeyFilter
import io.lmo.ninie.api.security.JwtAuthenticationFilter
import io.lmo.ninie.api.security.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
class SecurityConfiguration(val securityConfigurationProperties: SecurityConfigurationProperties) {

    @Bean
    fun jwtTokenProvider(): IJwtTokenProvider {
        return JwtTokenProvider(securityConfigurationProperties.jwtSecret)
    }

    fun apiKeySet(): Set<String> = "apiKeysRaw"
        .split(",")
        .mapNotNull { it.trim().takeIf { s -> s.isNotBlank() } }
        .toSet()

    @Bean
    fun authenticationManager(authConfig: AuthenticationConfiguration): AuthenticationManager =
        authConfig.authenticationManager

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun securityFilterChain(http: HttpSecurity, jwtTokenProvider: IJwtTokenProvider): SecurityFilterChain {
        val apiKeyFilter = ApiKeyFilter(apiKeySet())
        val jwtFilter = JwtAuthenticationFilter(jwtTokenProvider)

        http
            .cors { it.configurationSource(corsConfigurationSource()) }
            .csrf { it.disable() }
            .headers { it.frameOptions { it.sameOrigin() } }
            .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .authorizeHttpRequests { auth ->
                auth.requestMatchers("/", "/h2-console/**", "/ping/**", "/auth/**", "/public/**").permitAll()
                auth.anyRequest().authenticated()
            }

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration()
        config.allowedOrigins = listOf(securityConfigurationProperties.allowedOrigin)
        config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        config.allowedHeaders = listOf("*")
        config.allowCredentials = true
        config.maxAge = 3600L

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)
        return source
    }
}