package com.tele.tareaclase4.controller;

import com.tele.tareaclase4.DTO.DepartmentDTO;
import com.tele.tareaclase4.DTO.GerenteDTO;
import com.tele.tareaclase4.DTO.MaxSalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tele.tareaclase4.repository.*;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    MaxSalaryRepository maxSalaryRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    GerenteRepository gerenteRepository;

    @GetMapping("/empleados_mayor_salario")
    public String getEmpleadosConSalarioMayor15000(Model model) {
        List<MaxSalaryDTO> empleados = maxSalaryRepository.obtenerMaxSalary();
        model.addAttribute("employee", empleados);
        return "max_salary";
    }

    @GetMapping("/departamentos_mas_de_3_empleados")
    public String getDepartamentosConMasDeTresEmpleados(Model model) {
        List<DepartmentDTO> departamentos = departmentRepository.obtenerDepartamentos();
        model.addAttribute("department", departamentos);
        return "Department_3_emp";
    }

    @GetMapping("/gerentes_mayor_5_anios")
    public String getGerentesConExperienciaMayor5Anios(Model model) {
        List<GerenteDTO> gerentes = gerenteRepository.obtenerGerentesConExperiencia();
        model.addAttribute("gerente", gerentes);
        return "gerente";
    }
}

