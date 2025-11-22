package io.lmo.ninie.data.configurations

import org.springframework.boot.persistence.autoconfigure.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = ["io.lmo.ninie.data.entities"])
@EnableJpaRepositories(basePackages = ["io.lmo.ninie.data.repositories"])
class JpaConfiguration