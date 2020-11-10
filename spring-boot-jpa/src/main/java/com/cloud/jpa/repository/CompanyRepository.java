package com.cloud.jpa.repository;

import com.cloud.jpa.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Modifying
    @Transactional
    @Query("update Company company set company=?1")
    Company updateIfExist(Company companyUpdate);
}
