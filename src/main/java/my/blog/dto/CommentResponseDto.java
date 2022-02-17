package my.blog.dto;

import lombok.Getter;
import my.blog.model.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String content;
    private final LocalDateTime createAt;

    public CommentResponseDto(Comment c) {
        this.id = c.getId();
        this.content = c.getContent();
        this.createAt = c.getCreatedAt();
    }
}
