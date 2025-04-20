package com.tele.tareaclase4.repository;

import com.tele.tareaclase4.DTO.DepartmentDTO;
import com.tele.tareaclase4.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Employee, Integer> {

    @Query(value = """
        SELECT 
            pais,
            ciudad,
            COUNT(*) AS cantidad_departamentos
        FROM (
            SELECT 
                c.country_name AS pais,
                l.city AS ciudad,
                d.department_id,
                COUNT(e.employee_id) AS num_empleados
            FROM 
                employees e
            JOIN 
                departments d ON e.department_id = d.department_id
            JOIN 
                locations l ON d.location_id = l.location_id
            JOIN 
                countries c ON l.country_id = c.country_id
            GROUP BY 
                c.country_name, l.city, d.department_id
            HAVING 
                COUNT(e.employee_id) > 3
        ) AS sub
        GROUP BY 
            pais, ciudad
        """, nativeQuery = true)
    List<DepartmentDTO> obtenerDepartamentos();
}

