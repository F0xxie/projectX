package utils;

import dao.ContentDAO;
import dao.HibernateContentDAO;
import entity.Content;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class PostController {

    @RequestMapping(value = "/", method = RequestMethod.GET)public String printPosts(ModelMap model) {
        DBService dbService = new DBService();
        ArrayList<Content> posts = dbService.getContent();
        model.addAttribute("message", posts);
        return "index";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)public ModelAndView content() {
        return new ModelAndView("add_post", "command", new Content());
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public void addContent(Content content) {
        ContentDAO contentDAO= new HibernateContentDAO();

        String final_pbody = content.getContent();

        final_pbody = final_pbody.replace("'", "`");
        if(final_pbody != null) {
            contentDAO.create(new Content(0, final_pbody));
        }

    }
}