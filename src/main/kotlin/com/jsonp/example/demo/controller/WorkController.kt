package com.jsonp.example.demo.controller

import com.jsonp.example.demo.service.WorkService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class WorkController(private val workService: WorkService){
    @GetMapping("/work")
    fun dowork():Map<String,Any>{
        var msg =workService.doWork()
        return msg
    }
}

