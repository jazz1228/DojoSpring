package co.edu.udea.dojospring.controller;


import co.edu.udea.dojospring.model.Poster;
import co.edu.udea.dojospring.repository.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class PosterDAO{

    @Autowired
    PosterRepository post;


    @GetMapping("/post")
    public List<Poster> getAllPoster(){
        return post.findAll();
    }

    @PostMapping("/post")
    public Poster createNote(@Valid @RequestBody Poster post) {
        return this.post.save(post);
    }

    @GetMapping("/notes/{id}")
    public Poster getPostById(@PathVariable(value = "id") Long postId) {
        return post.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
}
