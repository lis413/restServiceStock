package ru.lis154.restServiceStock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lis154.restServiceStock.entity.CompanyEntity;
import ru.lis154.restServiceStock.repository.CompanyRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<CompanyEntity> getAllCompanyList(){
        return (List<CompanyEntity>) companyRepository.findAll();
    }


    @GetMapping("/company")
    public CompanyEntity getCompanyByName(@RequestParam(name = "symbol") String symbol){
        return companyRepository.findCompanyEntityBySymbol(symbol);
    }



}
