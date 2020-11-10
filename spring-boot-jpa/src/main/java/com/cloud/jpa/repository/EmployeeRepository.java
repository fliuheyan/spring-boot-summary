package com.cloud.jpa.repository;

import com.cloud.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByGender(String gender);

    @Modifying
    @Transactional
    @Query("update Employee employee set employee=?1")
    Employee updateIfExist(Employee employeeUpdate);
}
