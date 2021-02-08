package com.bcp.business.demo.core.service.impl;

import com.bcp.business.demo.core.dto.StudentDto;
import com.bcp.business.demo.core.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Profile("dev")
@Service
public class CrudRestTemplateImpl implements CrudService {

    Logger logger = LoggerFactory.getLogger(CrudRestTemplateImpl.class);

    public static final String HTTP_LOCALHOST_8080_V_1_STUDENT = "http://localhost:8082/v1/student";

    @Override
    public String callCrud(StudentDto dto) {
        RestTemplate restTemplate = new RestTemplate();

        //SAVE
        StudentDto studentDtoResponseEntity = restTemplate.postForEntity(HTTP_LOCALHOST_8080_V_1_STUDENT, dto, StudentDto.class).getBody();
        logger.info("SAVE "+studentDtoResponseEntity.getId());

        //UPDATE
        studentDtoResponseEntity.setFirstName("LUIS");
        restTemplate.put(HTTP_LOCALHOST_8080_V_1_STUDENT,studentDtoResponseEntity);
        logger.info("UPDATE");

        /*if(studentDtoResponseEntity.getBody() instanceof  StudentDto){

        }*/
        //GET ALL
        ResponseEntity<StudentDto[]>  dtos = restTemplate.getForEntity(HTTP_LOCALHOST_8080_V_1_STUDENT,StudentDto[].class);
        logger.info("GET ALL: "+ dtos.getBody().length);

        //GET ONE
        StudentDto studentDto = restTemplate.getForEntity(HTTP_LOCALHOST_8080_V_1_STUDENT+"/"+studentDtoResponseEntity.getId(),StudentDto.class).getBody();
        logger.info("GET ONE: "+ studentDto);

        //GET ONE
        //restTemplate.delete(HTTP_LOCALHOST_8080_V_1_STUDENT,studentDtoResponseEntity);
        //HttpEntity httpEntity = new HttpEntity(studentDtoResponseEntity);
        //restTemplate.exchange(HTTP_LOCALHOST_8080_V_1_STUDENT,httpEntity,StudentDto.class);

        return studentDtoResponseEntity.getId();
    }
}
