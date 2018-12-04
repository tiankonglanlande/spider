package com.jsonp.example.demo.service

import com.jsonp.example.demo.entity.Article
import com.jsonp.example.demo.repository.ArticleRepository
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class WorkService{
    var url="https://blog.csdn.net/ityouknow/"

    @Resource
    lateinit var articleRepository:ArticleRepository;


    fun doWork():HashMap<String,Any>{
        var msg=boot(this.url);
        return msg;
    }

    private fun boot(url: String):HashMap<String,Any> {
        val map=HashMap<String,Any>();

        val html=this.soup(url)
        val content = html.select(".content")
        val title = html.select("h4")
        val tag = html.getElementsByTag("h4")


        val index=title.size-1
        val articleList=ArrayList<Article>(index)


        for (i in 1..index){//跳过第一条
            var titleText=title[i].text()
            var contentText=content[i].text()
            var linkText=tag[i].toString()
            var index=linkText.indexOf("\"")

            var start=linkText.indexOf("\"",index+2)+1
            var end=linkText.indexOf("\"",start+1)

            var realLinkText=linkText.substring(start,end)
            var article_content = getArticleContent(realLinkText);

            var article=Article(null,titleText,contentText,realLinkText,article_content)
            articleList.add(article)
            articleRepository.save(article)
        }

        map.put("list",articleList)
        //articleRepository.saveAll(articleList)

        return map;
    }

    private fun getArticleContent(url: String): String? {
        val html=this.soup(url)
        val article_content = html.getElementById("article_content")
        return article_content.toString()
    }

    private fun soup(url: String): Document {

        return Jsoup.connect(url)
                .headers(mapOf("User-Agent" to "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.3 Safari/537.36",
                        "Host" to "www.csdn.com")).get();
    }
}

