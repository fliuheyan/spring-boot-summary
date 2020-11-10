package com.cloud.jpa.service;

import com.cloud.jpa.model.Company;
import com.cloud.jpa.model.Employee;
import com.cloud.jpa.repository.CompanyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public List<Company> getAll(Integer page, Integer pageSize) {
        return companyRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public Company get(Integer companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Integer companyId) {
        companyRepository.deleteById(companyId);
    }

    public Company update(Integer companyId, Company companyUpdate) {
        companyUpdate.setId(companyId);
        return companyRepository.save(companyUpdate);
    }

    public List<Employee> getEmployees(Integer companyId) {
        return companyRepository.findById(companyId).map(Company::getEmployees).orElse(null);
    }
}
