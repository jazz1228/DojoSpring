package co.edu.udea.dojospring.controller;

import java.util.Map;

import co.edu.udea.dojospring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MainController {

	@Autowired
    PostRepository post;

	@GetMapping("/allPosts")
	public String allPostsView(Map<String, Object> model) {
		 model.put("posts", post.findAll());
         return "posts";
	}
}