package org.hp.springboot.kotlin.seed.web

import org.hp.springboot.kotlin.seed.model.User
import org.hp.springboot.kotlin.seed.service.UserServiceInterface
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserApi {
    private val LOG = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    lateinit var userServiceInterface: UserServiceInterface<User>


    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id: String): User {
        return userServiceInterface.findById(id)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "hello world"
    }
}