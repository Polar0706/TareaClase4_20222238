package com.tele.tareaclase4.controller;

import com.tele.tareaclase4.DTO.EmployeeDTO;
import com.tele.tareaclase4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<EmployeeDTO> employees = employeeRepository.obtenerEmpleados();
        model.addAttribute("employees", employees);
        return "list";
    }
}
