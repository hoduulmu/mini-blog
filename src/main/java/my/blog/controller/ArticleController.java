package my.blog.controller;

import lombok.RequiredArgsConstructor;
import my.blog.dto.ArticleResponseDto;
import my.blog.model.Article;
import my.blog.dto.ArticleRequestDto;
import my.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/api/articles")
    public List<ArticleResponseDto> getListOfArticles() {
        return articleService.getListOfArticles();
    }

    @GetMapping("/api/articles/{id}")
    public ArticleResponseDto getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/api/articles")
    public ArticleResponseDto postArticle(@RequestBody ArticleRequestDto articleRequestDto) {
        Article article = new Article(articleRequestDto);
        return articleService.postArticle(article);
    }

    @PutMapping("/api/articles/{id}")
    public Long putArticle(@RequestBody ArticleRequestDto articleRequestDto, @PathVariable Long id) {
        return articleService.update(id, articleRequestDto);
    }

    @DeleteMapping("/api/articles/{id}")
    public Long deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id);
    }
}
