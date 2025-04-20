package com.tele.tareaclase4.repository;

import com.tele.tareaclase4.DTO.MaxSalaryDTO;
import com.tele.tareaclase4.entity.JobHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MaxSalaryRepository extends JpaRepository<JobHistory, Integer> {

    @Query(value = """
   SELECT 
       e.first_name AS firstName,
       e.last_name AS lastName,
       h.start_date AS startDate,
       h.end_date AS endDate,
       j.job_title AS jobTitle
   FROM 
       job_history h
   JOIN 
       employees e ON h.employee_id = e.employee_id
   JOIN 
       jobs j ON h.job_id = j.job_id
   WHERE 
       e.salary > 15000
   ORDER BY 
       e.employee_id, h.start_date
   """, nativeQuery = true)
    List<MaxSalaryDTO> obtenerMaxSalary();


}

