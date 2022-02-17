package my.blog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.blog.dto.CommentRequestDto;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    public void changeArticle(Article article) {
        this.article = article;
        article.getComments().add(this);
    }

    public Comment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
    }

    public void update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}
