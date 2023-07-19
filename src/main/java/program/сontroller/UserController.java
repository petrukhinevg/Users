package program.сontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import program.model.User;
import program.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    private ModelAndView allUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", users);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    private ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", userService.getUserById(id));
        return modelAndView;
    }

    @PatchMapping("/edit")
    private ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.editUser(user);
        return modelAndView;
    }

    @GetMapping("/add")
    private ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @PostMapping("/add")
    private ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        userService.addUser(user);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @DeleteMapping("/delete/{id}")
    private ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return modelAndView;
    }
}

