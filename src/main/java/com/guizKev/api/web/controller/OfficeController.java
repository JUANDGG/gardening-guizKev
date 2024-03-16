package com.guizKev.api.web.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.guizKev.api.domain.service.office.OfficeService;
import com.guizKev.api.persistence.entity.Office;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/office")
public class OfficeController {
    
    @Autowired
    private OfficeService  officeService ;

    @GetMapping("/all")
    public List<Office> getAllEmployee() {
        return officeService.getAllOffice();
    }
    
}
