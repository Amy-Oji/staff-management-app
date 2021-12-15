package com.week8.staffmanagementapp.Controller;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.dto.PasswordDTO;
import com.week8.staffmanagementapp.staffService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class StaffController {
    private StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/home")
    public String ViewHomePage(Model model) {
        model.addAttribute("listStaff", staffService.getAllStaff());
        return "staff";
    };

    @GetMapping("/showNewStaffForm")
    public String showNewStaffForm(Model model) {
        //create model attribute to bind form data

        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        return "new_staff";
    }

    @PostMapping("/saveStaff")
    public String saveStaff(@ModelAttribute("staff") Staff staff){
        //save staff to database
        staffService.addStaff(staff);
        return "redirect:/home";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        //get staff from the service
        Staff staff = staffService.getStaffById(id);
        //set staff as a model attribute to pre-populate the form
        model.addAttribute("staff", staff);
        return "update_staff";
    }

    @GetMapping("/changePasswordForm/{id}")
    public String changePasswordForm(@PathVariable (value = "id") String id, HttpSession httpSession, Model model){
        //get staff from the service
        Staff staff = staffService.getStaffByStaffId(id);
        httpSession.setAttribute("newUser", staff);
        //set staff as a model attribute to pre-populate the form
        model.addAttribute("staff", new PasswordDTO());
        return "change-password";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("employee") PasswordDTO passwordDTO, HttpServletRequest request) {
        //save staff to database
        Staff loggerUser = (Staff) request.getSession().getAttribute("newUser");
        System.out.println("loggedUser: " + loggerUser);
        staffService.changePassword(loggerUser, passwordDTO);
        return "redirect:/index";

    }

    @GetMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable (value = "id") long id){
        // call delete employee method
        this.staffService.deleteStaffById(id);
        return "redirect:/home";
    }
}








