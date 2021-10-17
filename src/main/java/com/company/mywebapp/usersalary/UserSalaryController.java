package com.company.mywebapp.usersalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserSalaryController {
    @Autowired private UserSalaryService service;

    @GetMapping("/usersalary")
    public String showUserSalaryList(Model model){
        List<UserSalary> listUsersSalary = service.listAll();
        model.addAttribute("ListUsersalary",listUsersSalary);
        return "usersalary";
    }

    @GetMapping("/usersalary/new")
    public String showNewFrom(Model model){
        model.addAttribute("usersalary", new UserSalary());
        model.addAttribute("pageTitle", "Add New Employee Salay");
        return "usersalary_form";
    }

    @PostMapping("/usersalary/save")
    public String saveUser(UserSalary usersalary, RedirectAttributes ra){
        service.save(usersalary);
        ra.addFlashAttribute("message","The user salary has been saved successfully.");
        return "redirect:/usersalary";
    }

    @GetMapping("/usersalary/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            UserSalary usersalary = service.get(id);
            model.addAttribute("usersalary",usersalary);
            model.addAttribute("pageTitle","Edit User Salary (ID:" + id + ")");
            return "usersalary_form";
        } catch (UserSalaryNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/usersalary";
        }
    }

    @GetMapping("/usersalary/delete/{id}")
    public String deleteUserSalary(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The user salary ID " + id +" has been deleted.");
        } catch (UserSalaryNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/usersalary";
    }

}
