package my.blog.controller;

import lombok.RequiredArgsConstructor;
import my.blog.dto.CommentRequestDto;
import my.blog.dto.CommentResponseDto;
import my.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comments/{postId}")
    public CommentResponseDto postComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto) {
        return commentService.postComment(postId, requestDto);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
