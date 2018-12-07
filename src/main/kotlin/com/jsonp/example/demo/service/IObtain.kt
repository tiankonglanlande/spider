package com.jsonp.example.demo.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

interface IObtain {

    fun boot():HashMap<String,Any>


    fun soup(url: String,host: String): Document {

        return Jsoup.connect(url)
                .headers(mapOf("User-Agent" to "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.3 Safari/537.36",
                        "Host" to "$host")).get()
    }
}