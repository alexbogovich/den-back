package io.github.alexbogovich.denback.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

enum class Role {
    USER,
    ADMIN,
    PUSHER,
}

data class User(val login: String, val password: String)
data class AuthResult(val success: Boolean,
                      val userId: Int? = null,
                      val error: String? = null)

data class Alert(val title: String, val type: Short, val content: String)


@RestController
@RequestMapping("/api/auth")
class AuthController {
    private val log = LoggerFactory.getLogger(this.javaClass)

    private var alerts: List<Alert> = listOf()

    @PostMapping("/login")
    fun login(@RequestBody user: User): AuthResult {
        log.info("call login with $user")
        if (user.login == "den" || user.login == "alex") {
            //.
            log.info("auth success")
            return AuthResult(true, userId = getUserIdByLogin(user.login))
        }
        log.info("auth fail")
        return AuthResult(false, userId = null, error = "fuck off")
    }

    @GetMapping("/pong")
    fun login(): String {
        return "Ping pong"
    }

    // /api/auth/roles?userId=1

    @GetMapping("/roles")
    fun roles(@RequestParam userId: Int): List<Role> =
            getRolesByUserId(userId)

    @PostMapping("/alerts")
    fun postAlerts(@RequestBody alerts: List<Alert>) {
        println(alerts)
        this.alerts = alerts.map { v -> v }
    }

    @GetMapping("/alerts")
    fun getAlerts() = this.alerts
}

fun getUserIdByLogin(userName: String): Int? =
        when (userName) {
            "den" -> 1
            "alex" -> 2
            else -> null
        }

fun getRolesByUserId(userId: Int): List<Role> =
        when (userId) {
            1 -> listOf(Role.USER, Role.PUSHER)
            2 -> listOf(Role.ADMIN)
            else -> throw RuntimeException()
        }