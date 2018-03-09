package co.edu.udea.dojospring.controller;


import co.edu.udea.dojospring.exception.ResourceNotFoundException;
import co.edu.udea.dojospring.model.Poster;
import co.edu.udea.dojospring.repository.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PosterDAO{

    @Autowired
    PosterRepository post;


    @GetMapping("/post")
    public List<Poster> getAllPoster(){
        return post.findAll();
    }

    @PostMapping("/post")
    public Poster createPost(@Valid @RequestBody Poster post) {
        return this.post.save(post);
    }

    @GetMapping("/post/{id}")
    public Poster getPostById(@PathVariable(value = "id") Long postId) {
        return post.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
    }

    @PutMapping("/post/{id}")
    public Poster updatePost(@PathVariable(value = "id") Long postId,
                           @Valid @RequestBody Poster postDetails) {

        Poster postNote = post.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        postNote.setTitle(postDetails.getTitle());
        postNote.setContent(postDetails.getContent());

        Poster updatedPost = post.save(postNote);
        return updatedPost;
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
        Poster post = this.post.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        this.post.delete(post);

        return ResponseEntity.ok().build();
    }
}
