package com.cloud.jpa.service;

import com.cloud.jpa.model.Employee;
import com.cloud.jpa.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAll(Integer page, Integer pageSize) {
        return employeeRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public Employee get(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee update(Integer employeeId, Employee employeeUpdate) {
        employeeUpdate.setId(employeeId);
        return employeeRepository.save(employeeUpdate);
    }

    public List<Employee> getByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }
}
