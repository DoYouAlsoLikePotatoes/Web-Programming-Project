package sen3004.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import sen3004.project.model.UserData;
import sen3004.project.service.ProjectService;
import sen3004.project.validator.ProjectValidator;

@Controller
public class ProjectController {

    @Autowired
    ProjectValidator validatation;

    @Autowired
    private ProjectService service;
    
    @GetMapping("/home")
    public ModelAndView displayHome(){
        ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("userData", new UserData());

        return mv;
    }

    @PostMapping("/add-user")
    public ModelAndView processForm(@Valid @ModelAttribute UserData userData, BindingResult result){
        ModelAndView mv = new ModelAndView();
        mv.addObject("userData", userData);

        validatation.validate(userData, result);

        if(result.hasErrors()){
            mv.setViewName("homepage");
        }

        else{
            mv.setViewName("user-list");
            service.saveUserData(userData);
            mv.addObject("userData", service.findAllData());
        }

        return mv;
    }

    @GetMapping("/user-list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("user-list");
        mv.addObject("userData", service.findAllData());

        return mv;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView deleteUser(UserData userData){
        ModelAndView mv = new ModelAndView("user-list");
        service.deleteUserData(userData);
        mv.addObject("userData", service.findAllData());

        return mv;
    }

}
