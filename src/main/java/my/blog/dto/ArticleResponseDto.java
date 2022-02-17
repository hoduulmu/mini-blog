package my.blog.dto;

import lombok.Getter;
import lombok.Setter;
import my.blog.model.Article;
import my.blog.model.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ArticleResponseDto {
    private Long id;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> comments = new ArrayList<>();


    public ArticleResponseDto(Article article) {
        this.id = article.getId();
        this.name = article.getName();
        this.title = article.getTitle();
        this.createdAt = article.getCreatedAt();
        this.content = article.getContent();
        for (Comment c : article.getComments())
            comments.add(new CommentResponseDto(c));
    }
}
