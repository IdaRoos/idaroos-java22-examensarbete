package com.idaroos.theglobalnewsarchive.controller;

import com.idaroos.theglobalnewsarchive.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Controller
public class WebController {

    private final ArticleService articleService;

    public WebController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/theglobalnewsarchive/home")
    public String home() {
        return "home";
    }

    @GetMapping("/theglobalnewsarchive/search")
    public Mono<String> search(Model model,
                               @RequestParam String query,
                               @RequestParam(required = false) String language,
                               @RequestParam(required = false) String startDateTime,
                               @RequestParam(required = false) String endDateTime,
                               @RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "relevancy") String sortBy) {
        return articleService.getArticles(query, language, startDateTime, endDateTime, page, sortBy)
                .flatMap(articlesDTO -> {
                    model.addAttribute("articles", articlesDTO.getArticles());
                    model.addAttribute("currentPage", articlesDTO.getCurrentPage());
                    model.addAttribute("totalPages", articlesDTO.getTotalPages());
                    model.addAttribute("query", query);
                    model.addAttribute("language", language);
                    model.addAttribute("startDateTime", startDateTime);
                    model.addAttribute("endDateTime", endDateTime);
                    model.addAttribute("sortBy", sortBy);
                    return Mono.just("searchResult");
                });
    }


}
