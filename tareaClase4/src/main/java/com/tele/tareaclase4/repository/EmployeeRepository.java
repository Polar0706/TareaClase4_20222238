package com.tele.tareaclase4.repository;

import com.tele.tareaclase4.entity.Employee;
import com.tele.tareaclase4.entity.Job;
import com.tele.tareaclase4.DTO.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("""
        SELECT e.id AS employeeId,
               e.firstName AS firstName,
               e.lastName AS lastName,
               j.title AS jobTitle,
               d.name AS departmentName,
               l.city AS city
        FROM Employee e
        JOIN e.job j
        JOIN e.department d
        JOIN d.location l
        ORDER BY e.employeeId
    """)
    List<EmployeeDTO> obtenerEmpleados();

}
