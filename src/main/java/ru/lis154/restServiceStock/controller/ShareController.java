package ru.lis154.restServiceStock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lis154.restServiceStock.entity.CompanyEntity;
import ru.lis154.restServiceStock.entity.ShareEntity;
import ru.lis154.restServiceStock.repository.CompanyRepository;
import ru.lis154.restServiceStock.repository.ShareRepository;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ShareController {

    @Autowired
    ShareRepository shareRepository;

    @GetMapping("/shares")
    public List<ShareEntity> getAllCompanyList(){
        return (List<ShareEntity>) shareRepository.findAll();
    }


    @GetMapping("/share")
    public ShareEntity getCompanyBySymbol(@RequestParam(name = "symbol") String symbol) {
        return shareRepository.findShareEntityBySymbol(symbol);
    }


}
