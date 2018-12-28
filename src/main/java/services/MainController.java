package services;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")
public class MainController {
    private UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping(value = "")
    public String getIndex(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "users")
    public String getUsers(ModelMap model) {
        return "users";
    }

    @RequestMapping(value = "users/new")
    public String getNewUser(ModelMap model) {
        return "add_user";
    }

    @RequestMapping(value = "posts/new")
    public String getNewPsto(ModelMap model) {
        return "add_post";
    }
}
