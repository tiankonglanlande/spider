package com.jsonp.example.demo.repository

import com.jsonp.example.demo.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository :CrudRepository<Article,Long>{
    /**
     * 是否存在link
     * @return true/fase
     */
    fun existsByLink(link: String): Boolean

}