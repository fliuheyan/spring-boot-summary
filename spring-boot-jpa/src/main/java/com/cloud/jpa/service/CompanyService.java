package com.cloud.jpa.service;

import com.cloud.jpa.model.Company;
import com.cloud.jpa.model.Employee;
import com.cloud.repository.CompanyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        Pageable pageable = PageRequest.of(page, pageSize);
        return companyRepository.retrieveAllPageable(pageable);
//        return companyRepository.findAll(page, pageSize);
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
        return null;
//        return companyRepository.find(companyId).orElse(null);
    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        IntStream.of(123).boxed().forEach((x) -> System.out.println());
    }
}
