package com.bcp.business.demo.api;

import com.bcp.business.demo.core.dto.StudentDto;
import com.bcp.business.demo.core.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business/demo")
public class BusinessController {

    @Autowired
    CrudService crudService;

    @PostMapping
    public ResponseEntity callCrud(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok().body(crudService.callCrud(studentDto));
    }
}
