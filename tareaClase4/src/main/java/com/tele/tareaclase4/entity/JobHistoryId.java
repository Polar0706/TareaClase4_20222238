package com.tele.tareaclase4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class JobHistoryId implements Serializable {

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

}
