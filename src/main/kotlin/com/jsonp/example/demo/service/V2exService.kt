package com.jsonp.example.demo.service

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

@Service
class V2exService : IObtain{
    val url="";
    val host="";
    override fun boot(): HashMap<String, Any> {
        val result=HashMap<String,Any>();
        val html=soup(url,host);


        return result;
    }


}