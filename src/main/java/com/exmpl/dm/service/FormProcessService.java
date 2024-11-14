package com.exmpl.dm.service;

import com.exmpl.dm.exception.FormProcessException;
import com.exmpl.dm.model.FormDetails;
import com.exmpl.dm.repository.FormDetailsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class FormProcessService {

    private FormDetailsRepository formDetailsRepository;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public FormProcessService(FormDetailsRepository formDetailsRepository) {
        this.formDetailsRepository = formDetailsRepository;
    }

    public void processFormData(FormDetails formDetails) throws FormProcessException{
        try{
            executorService.submit(()->saveData(formDetails));
        }catch(Exception e){
            throw new FormProcessException("Error Processing form data" ,e);
        }
    }

    @Transactional
    public void saveData(FormDetails formDetails) throws FormProcessException{
        try {
            formDetailsRepository.save(formDetails);
            System.out.println("Data saved " + formDetails.getEmail());
        } catch(Exception e){
            throw new FormProcessException("Error Savind Details");
        }
    }
}
