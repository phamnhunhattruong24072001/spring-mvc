package java_training.com.crud.controller;

import java_training.com.crud.dto.UserDTO;
import java_training.com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list-user")
    public List<UserDTO> listUser() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("layout");
        modelAndView.addObject("title", "Create");
        modelAndView.addObject("content", "user/create.jsp");
        return modelAndView;
    }
}
