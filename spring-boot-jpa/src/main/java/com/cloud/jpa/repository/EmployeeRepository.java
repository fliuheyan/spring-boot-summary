package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Modifying
    @Query("update Employee set name=:name where id=:id")
    void updateNameById(@Param(value = "id") String id, @Param(value = "name") String nameWrittenInAnotherWay);

    //  @Query("select new Employee(id,name,age,gender) from Employee where gender=:gender")
    List<Employee> findByGender(String gender);

    @Query("select new Employee(id,name,age,gender) from Employee")
    List<Employee> retrieveAllPageable(Pageable pageable);
}
