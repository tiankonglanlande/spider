package com.jsonp.example.demo.entity

import javax.persistence.*

@Entity
@Table(name = "tbl_article")
class Article(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
              var title: String?,
              var content: String?,
              var link: String?,
              @Column(length = 1000000) var articleContent: String?
              ) {
    constructor() : this(null, null, null, null,null) {

    }
}



