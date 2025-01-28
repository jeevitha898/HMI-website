package com.example.projectmanagement.repository;

import com.example.projectmanagement.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCaseOrProjectContainingIgnoreCase(String name, String project);
}

