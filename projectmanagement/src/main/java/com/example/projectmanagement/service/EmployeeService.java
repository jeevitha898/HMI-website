package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Employee;
import com.example.projectmanagement.util.ExcelUtil;
import com.example.projectmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.IOException;



@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> searchEmployees(String query) {
        return employeeRepository.findByNameContainingIgnoreCaseOrProjectContainingIgnoreCase(query, query);
    }
   
    
    public void exportToExcel() throws IOException {
        List<Employee> employees = getAllEmployees();
        ExcelUtil.writeToExcel(employees);
    }
}
