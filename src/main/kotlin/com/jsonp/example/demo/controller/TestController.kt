package com.jsonp.example.demo.controller

import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.set

@Controller
class TestController {

    @GetMapping("/hello")
    fun blog(name:String
             ,model: Model): String {
        model["name"]=name
        return "blog"
    }
}