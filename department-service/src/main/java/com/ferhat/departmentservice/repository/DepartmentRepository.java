package com.ferhat.departmentservice.repository;

import com.ferhat.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, String> {
   boolean existsByName(String name);
}
