package com.example.reddit_project.controller;

import com.example.reddit_project.model.Post;
import com.example.reddit_project.repository.PostRepository;
import com.example.reddit_project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedditController {

    PostService postService;


    @Autowired
    public RedditController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = {"", "/"})
    public String redirectToIndex(){
        return "redirect:/0";
    }

    @RequestMapping(value = {"/{id}", "{id}"}, method = RequestMethod.GET)
    public String showMainPage (Model model, @PathVariable(value = "id") Integer id) {

        model.addAttribute("posts", postService.createPagesOfTenPosts(id));
        model.addAttribute("pages", postService.pages());
        return "index";

    }
    @RequestMapping(value = {"/submit"}, method = RequestMethod.GET)
    public String showAdderPage(Model model) {

        model.addAttribute("newpost", new Post());
        return "addpost";

    }

    @RequestMapping(value = {"/submit"}, method = RequestMethod.POST)
    public String addPost(Post post) {
        postService.savePost(post);
        return "redirect:/0";
    }

    @RequestMapping(value = "/{id}/upvote", method = RequestMethod.GET)
    public String upVotePost(@PathVariable("id") Long id){
        Post postToUpvote = postService.findPostById(id);
        postToUpvote.upVote();
        postService.savePost(postToUpvote);
        return "redirect:/0";
    }

    @RequestMapping(value = "/{id}/downvote", method = RequestMethod.GET)
    public String downVote(@PathVariable("id") Long id){
        Post postToDownvote = postService.findPostById(id);
        postToDownvote.downVote();
        postService.savePost(postToDownvote);
        return "redirect:/0";
    }
}
