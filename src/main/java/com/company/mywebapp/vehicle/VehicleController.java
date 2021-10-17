package com.company.mywebapp.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VehicleController {
    @Autowired private VehicleService service;

    @GetMapping("/vehicle")
    public String showVehicleList(Model model){
        List<Vehicle> listVehicles = service.listAll();
        model.addAttribute("ListVehicles", listVehicles);
                return "vehicle";
    }

    @GetMapping("/vehicle/new")
    public String showNewFrom(Model model){
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("pageTitle", "Add New Vehicle");
        return "vehicle_form";
    }

    @PostMapping("/vehicle/save")
    public String saveUser(Vehicle vehicle, RedirectAttributes ra){
        service.save(vehicle);
        ra.addFlashAttribute("message","The vehicle has been saved successfully.");
        return "redirect:/vehicle";
    }

    @GetMapping("/vehicle/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Vehicle vehicle = service.get(id);
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("pageTitle","Edit Vehicle (ID:" + id + ")");
            return "vehicle_form";
        } catch (VehicleNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/vehicle";
        }
    }

    @GetMapping("/vehicle/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
           service.delete(id);
           ra.addFlashAttribute("message", "The vehicle ID " + id +" has been deleted.");
        } catch (VehicleNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());

        }
        return "redirect:/vehicle";
    }

}
