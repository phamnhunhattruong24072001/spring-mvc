package java_training.com.crud.controller;

import java_training.com.crud.dto.UserDTO;
import java_training.com.crud.model.User;
import java_training.com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView listUser() {
        ModelAndView modelAndView = new ModelAndView("layout");
        modelAndView.addObject("title", "List of users");
        modelAndView.addObject("content", "user/list.jsp");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("layout");
        modelAndView.addObject("title", "Create");
        modelAndView.addObject("content", "user/create.jsp");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id) {
        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setUsername(user.getUsername());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setPassword(user.getPassword());

            ModelAndView modelAndView = new ModelAndView("layout");
            modelAndView.addObject("title", "Update");
            modelAndView.addObject("content", "user/update.jsp");
            modelAndView.addObject("user", userDTO);
            return modelAndView;
        }

        return new ModelAndView("redirect:/list");
    }

    @PostMapping("/store")
    public String handleCreateUser(@ModelAttribute("user") UserDTO userDTO) {
        userService.createUser(userDTO);
        return "redirect:/create";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") UserDTO userDTO, @PathVariable("id") Long id) {
        return userService.updateUser(userDTO, id);
    }
}
