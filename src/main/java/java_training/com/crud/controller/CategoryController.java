package java_training.com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @RequestMapping(value = "/danh-muc", method = RequestMethod.GET)
    public ModelAndView categoryPage() {
        return new ModelAndView("category");
    }
}
