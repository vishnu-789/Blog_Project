package com.example.demo.Controller;

import com.example.demo.Data.PostRepo;
import com.example.demo.Model.Create;
import com.example.demo.Model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("register")
@RequestMapping("/showcase")
public class DeleteController {

    private PostRepo postRepo;
    @Autowired
    public DeleteController(PostRepo postRepo)
    {
        this.postRepo=postRepo;
    }


    @GetMapping
    public String deletePost(@SessionAttribute("register")Register register){
        postRepo.deleteByName(register.getName());
        return "redirect:/message";
    }


}
