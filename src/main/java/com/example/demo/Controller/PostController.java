package com.example.demo.Controller;

import com.example.demo.Data.PostRepo;
import com.example.demo.Model.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class PostController {
    private PostRepo postRepo;
    @Autowired
    public PostController(PostRepo postRepo)
    {
        this.postRepo=postRepo;
    }
    @GetMapping
    public String print(Model model)
    {   model.addAttribute("create",new Create());
        return "message";
    }
    @PostMapping
    public String display(Create create)
    {
        postRepo.save(create);
        return "message";
    }
}
