package my.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import my.blog.dto.ArticleRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @Column
    private String name;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private final List<Comment> comments = new ArrayList<>();

    public Article(ArticleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(ArticleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
