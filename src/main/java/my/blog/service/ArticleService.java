package my.blog.service;

import lombok.RequiredArgsConstructor;
import my.blog.dto.ArticleRequestDto;
import my.blog.dto.ArticleResponseDto;
import my.blog.model.Article;
import my.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticleResponseDto> getListOfArticles() {
        List<Article> articles = articleRepository.findAllByOrderByCreatedAtDesc();
        List<ArticleResponseDto> responseDtoList = new ArrayList<>();
        for (Article a : articles) {
            responseDtoList.add(new ArticleResponseDto(a));
        }
        return responseDtoList;
    }

    public ArticleResponseDto getArticle(Long id) {
        Article article = getArticleById(id);
        return new ArticleResponseDto(article);
    }

    public ArticleResponseDto postArticle(Article article) {
        return new ArticleResponseDto(articleRepository.save(article));
    }

    @Transactional
    public Long update(Long id, ArticleRequestDto articleRequestDto) {
        Article article = getArticleById(id);
        article.update(articleRequestDto);
        return id;
    }

    public Long deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return id;
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 id 입니다"));
    }
}
