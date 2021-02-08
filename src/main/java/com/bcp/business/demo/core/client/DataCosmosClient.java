package com.bcp.business.demo.core.client;

import com.bcp.business.demo.core.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "data-cosmos" , url = "${feign.data-cosmos.url}", path = "/v1/student")
public interface DataCosmosClient {

    @PostMapping//[POST]/v1/student
    public StudentDto saveStudent(@RequestBody StudentDto dto);

    @GetMapping
    public List<StudentDto> getStudents();

    @PutMapping
    public ResponseEntity updateStudents(@RequestBody StudentDto dto);

    @DeleteMapping
    public ResponseEntity deleteStudent(@RequestBody StudentDto dto);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentDto getStudent(@PathVariable("id") String id);

}
