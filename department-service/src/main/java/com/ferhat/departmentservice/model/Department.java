package com.ferhat.departmentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ferhat on 6/2/2023
 * @project employee-management-microservices
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    @ElementCollection
    private List<String> employees_id ;
}
