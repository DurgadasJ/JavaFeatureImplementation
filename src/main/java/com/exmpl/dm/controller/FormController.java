package com.exmpl.dm.controller;


import com.exmpl.dm.exception.FormProcessException;
import com.exmpl.dm.model.FormDetails;
import com.exmpl.dm.service.FormProcessService;
import org.aspectj.util.GenericSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    FormProcessService formProcessService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody FormDetails formDetails){
        try{
            formProcessService.processFormData(formDetails);

            return ResponseEntity.ok("Form submitted successfully.");
        }catch (FormProcessException e){
            return ResponseEntity.status(500).body("Error processing form: " + e.getMessage());
        }
    }
}
