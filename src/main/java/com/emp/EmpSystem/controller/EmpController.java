package com.emp.EmpSystem.controller;

import org.springframework.ui.Model;
import com.emp.EmpSystem.entity.Employee;
import com.emp.EmpSystem.service.Empservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private Empservice service;

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emp = service.getAllEmp();
        m.addAttribute("emp", emp);
        return "index";
    }

    @GetMapping("/add_emp")
    public String addEmpForm() {
        return "add_emp";
    }

    // Add emp data in home and show alert message on home page
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
        System.out.println(e);
        service.addEmp(e);
        session.setAttribute("msg", "Employee added successfully..");
        return "redirect:/";
    }

    // Edit method
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = service.getEmpById(id); // data show krna hai
        m.addAttribute("emp", e);
        return "edit";
    }

    // Update method
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
        service.addEmp(e);
        session.setAttribute("emp", "Data updated successfully.");
        return "redirect:/";
    }

    // Delete method
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        service.deleteEmp(id);
        session.setAttribute("emp", "Data deleted successfully.");
        return "redirect:/";
    }
}
