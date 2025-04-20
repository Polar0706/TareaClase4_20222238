package com.tele.tareaclase4.repository;

import com.tele.tareaclase4.DTO.HistoryDTO;
import com.tele.tareaclase4.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {
    @Query(value = """
    SELECT 
        e.first_name AS firstName,
        e.last_name AS lastName,
        j.job_title AS jobTitle,
        d.department_name AS departmentName,
        h.start_date AS startDate
    FROM 
        job_history h
    JOIN 
        employees e ON h.employee_id = e.employee_id
    JOIN 
        jobs j ON h.job_id = j.job_id
    JOIN 
        departments d ON h.department_id = d.department_id
    ORDER BY 
        e.employee_id, h.start_date
""", nativeQuery = true)
    List<HistoryDTO> obtenerHistorias();


}
