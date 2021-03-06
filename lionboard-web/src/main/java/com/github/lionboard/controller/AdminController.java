package com.github.lionboard.controller;

import com.github.lionboard.model.*;
import com.github.lionboard.service.LionBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Lion.k on 16. 2. 13..
 */


@Controller
@RequestMapping("/admin")
public class AdminController {


    private static final Logger logger =
            LoggerFactory.getLogger(UserController.class);

    @Autowired
    LionBoardService lionBoardService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAdmin(ModelAndView modelAndView) {

        return "redirect:/admin/users";
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/users")
    public ModelAndView showUsersOnAdmin(ModelAndView modelAndView, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        List<User> users = lionBoardService.getAllUsers(offset, limit, sort);
        List<Pagination> paginations = lionBoardService.getPagination(offset, sort, "adminUsers");
        modelAndView.addObject("paginations", paginations);
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/posts")
    public ModelAndView showPostsOnAdmin(ModelAndView modelAndView, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, @RequestParam(value = "sort", required = false, defaultValue = "posts.postId") String sort) {

        List<Post> posts = lionBoardService.getAllPosts(offset, limit, sort);
        List<Pagination> paginations = lionBoardService.getPagination(offset, sort, "adminPosts");
        modelAndView.addObject("paginations", paginations);
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/comments")
    public ModelAndView showCommentsOnAdmin(ModelAndView modelAndView, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, @RequestParam(value = "sort", required = false, defaultValue = "cmts.cmtId") String sort) {

        List<Comment> comments = lionBoardService.getAllComments(offset, limit, sort);
        List<Pagination> paginations = lionBoardService.getPagination(offset, sort, "adminComments");
        modelAndView.addObject("paginations", paginations);
        modelAndView.addObject("comments", comments);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/postReport")
    public ModelAndView showPostReportsOnAdmin(ModelAndView modelAndView, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {

        List<PostReport> postReports = lionBoardService.getAllPostReports(offset, limit, sort);
        List<Pagination> paginations = lionBoardService.getPagination(offset, sort, "adminPostReports");
        modelAndView.addObject("paginations", paginations);
        modelAndView.addObject("postReports", postReports);

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/cmtReport")
    public ModelAndView showCmtReportsOnAdmin(ModelAndView modelAndView, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {

        List<CommentReport> cmtReports = lionBoardService.getAllCmtReports(offset, limit, sort);
        List<Pagination> paginations = lionBoardService.getPagination(offset, sort, "adminPostReports");
        modelAndView.addObject("paginations", paginations);
        modelAndView.addObject("cmtReports", cmtReports);

        return modelAndView;
    }

}
