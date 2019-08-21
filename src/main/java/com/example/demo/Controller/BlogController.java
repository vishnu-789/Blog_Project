package com.example.demo.Controller;

import com.example.demo.Data.PostRepo;
import com.example.demo.Model.Create;
import com.example.demo.Model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("register")
@RequestMapping("/bolg")
public class BlogController {
    private PostRepo postRepo;
    @Autowired
    public BlogController(PostRepo postRepo)
    {
        this.postRepo=postRepo;
    }

   /* @RequestMapping(value="/{title}",method = RequestMethod.GET)
    public String deletePost(@PathVariable String title,@SessionAttribute("register")Register register){
        System.out.println(title);
        postRepo.deleteByNameAndTitle(register.getName(),title);
        return "delete";
    }
    @ModelAttribute
    @GetMapping
    public String Display(@ModelAttribute Register register, Model model)
    {
        List<Create> plans = new ArrayList<>();
        plans=postRepo.findByName(register.getName());
        model.addAttribute("plans",plans);
        return "bolg";
    }*/
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public String deletePost(@PathVariable String id,@SessionAttribute("register")Register register){
       System.out.println(id);
       postRepo.deleteByNameAndId(register.getName(),id);
       return "delete";
   }


    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
    public String editPost(@PathVariable String id, @SessionAttribute("register")Register register, @Valid Create create, Model model){
        Create user= (Create) postRepo.findAllByNameAndId(register.getName(),id);
        model.addAttribute("user",user);
        return "edit";
    }

    @ModelAttribute
    @GetMapping
    public String Display(@ModelAttribute Register register, Model model)
    {
        List<Create> plans = new ArrayList<>();
        plans=postRepo.findByName(register.getName());
        model.addAttribute("plans",plans);
        return "bolg";
    }
}
