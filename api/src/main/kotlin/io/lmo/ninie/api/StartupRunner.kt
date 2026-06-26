package io.lmo.ninie.api

import io.lmo.ninie.business.CreateUserModel
import io.lmo.ninie.business.UserService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class StartupRunner(private val userService: UserService, private val passwordEncoder: PasswordEncoder) :
    ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        if (userService.get("dofreche@gmail.com") == null)
            userService.create(CreateUserModel("dofreche@gmail.com", passwordEncoder.encode("P@ssw0rd")!!, "Mélanie", "Konéfal"))
    }
}
