package my.blog.service;

import lombok.RequiredArgsConstructor;
import my.blog.dto.CommentRequestDto;
import my.blog.dto.CommentResponseDto;
import my.blog.model.Article;
import my.blog.model.Comment;
import my.blog.repository.ArticleRepository;
import my.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentResponseDto postComment(Long postId, CommentRequestDto requestDto) {
        Article article = articleRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 id 입니다"));
        Comment comment = new Comment(requestDto);
        comment.changeArticle(article);
        return new CommentResponseDto(commentRepository.save(comment));
    }

    @Transactional
    public Long updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 id 입니다")
        );
        comment.update(requestDto);
        return id;
    }

    public Long deleteComment(Long id) {
        commentRepository.deleteById(id);
        return id;
    }

}
