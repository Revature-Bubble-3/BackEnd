package com.revature.controllers;

import com.revature.models.Post;
import com.revature.models.Profile;
import com.revature.services.PostService;
import com.revature.utilites.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/posts")
public class PostController {

    @Autowired
    public PostService postService;

    /**
     * addPost receives a request body that contains the Post to be added and a http servlet request that contains
     * a token. The AuthAspect takes the token and checks if it is valid. When it is, it will return a profile that
     * will be added into the post as the creator variable. Also, the id will be generated by Security.Util and set
     * within the post. When the service tries to add the post, it will return a null or the original post that was
     * added. When null, it will return the HTTP bad request status and null within the body. Otherwise, it will return
     * an HTTP created status and the post returned by the service.
     *
     * @param post Post to be added to the database
     * @param req Authorized token of the profile
     * @return HTTP created status and the original post when it is added,
     *          HTTP bad request status and null otherwise
     */
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post, HttpServletRequest req) {
        Post temp = post;
        temp.setCreator((Profile) req.getAttribute("profile"));
        temp.setPsid(SecurityUtil.getId());
        Post check = postService.addPost(temp);
        if (check == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(check, HttpStatus.CREATED);
        }
    }

    /**
     * getAllPosts will return a list of Posts when called upon.
     *
     * More will be added when this gets implemented more.
     *
     * @return list of all the Posts
     */
    @GetMapping
    @ResponseBody
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}

