package com.jsonp.example.demo

import com.jsonp.example.demo.repository.ArticleRepository
import com.samskivert.mustache.Mustache
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication
    fun main(args: Array<String>) {
        runApplication<DemoApplication>(*args)

    }

    @Bean
    fun databaseInitializer(articleRepository: ArticleRepository)=CommandLineRunner{

    }

    @Bean
    fun mustacheCompiler(loader: Mustache.TemplateLoader?) =
            Mustache.compiler().escapeHTML(false).withLoader(loader)


