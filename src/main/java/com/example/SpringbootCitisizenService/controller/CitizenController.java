package com.example.SpringbootCitisizenService.controller;

import com.example.SpringbootCitisizenService.Entity.Citizen;
import com.example.SpringbootCitisizenService.repository.CitizenRepository;
import jakarta.persistence.criteria.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    private CitizenRepository citizenRepository;
    @RequestMapping(path =  "/test")
    public ResponseEntity<String>test(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }
    @RequestMapping(path = "/id{id}")
    public ResponseEntity<List<Citizen>>getById(@PathVariable Integer id){
        List<Citizen>list=citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Citizen>addCitizen(@RequestBody Citizen citizen){
        Citizen citizen1=citizenRepository.save(citizen);
        return new ResponseEntity<>(citizen,HttpStatus.OK);
    }
}
