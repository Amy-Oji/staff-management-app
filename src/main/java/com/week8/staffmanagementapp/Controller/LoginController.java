package com.week8.staffmanagementapp.Controller;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.staffService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final StaffService staffService;

    @Autowired
    public LoginController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/")  //I have removed login
    public String getLoginPage(Model model) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("invalid", null);
        model.addAttribute("newRegistration", null);
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession httpSession, Staff staff, Model model) {
        Staff staff1 = staffService.getStaffByEmailAndPassword(staff.getEmail(), staff.getPassword());
        if (staff1 == null) {
            model.addAttribute("invalid", "Incorrect password");
            return "redirect:/login";
        }
        httpSession.setAttribute("user", staff1);
        model.addAttribute("loggerUser", staff1);
        boolean isRoleStaff = staff1.getRole().equalsIgnoreCase("admin") ? true : false;
        model.addAttribute("role", isRoleStaff);
        return "index"; //redirect was here...
    }

}

