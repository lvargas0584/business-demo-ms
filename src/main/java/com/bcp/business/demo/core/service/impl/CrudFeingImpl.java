package com.bcp.business.demo.core.service.impl;

import com.bcp.business.demo.core.client.DataCosmosClient;
import com.bcp.business.demo.core.dto.StudentDto;
import com.bcp.business.demo.core.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Profile("prod")
@Service
public class CrudFeingImpl implements CrudService {
    Logger logger = LoggerFactory.getLogger(CrudFeingImpl.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    DataCosmosClient dataCosmosClient;

    @Override
    public String callCrud(StudentDto dto) {

        StudentDto studentDto = dataCosmosClient.saveStudent(dto);
        logger.info("SAVE FEING " + studentDto.getId());
        logger.error("SAVE FEING " + studentDto.getId());
        logger.debug("SAVE FEING " + studentDto.getId());

        studentDto.setFirstName("Ruth");
        dataCosmosClient.updateStudents(studentDto);
        logger.info("UPDATE FEING ");

        List<StudentDto> students = dataCosmosClient.getStudents();
        logger.info("GET ALL FEING " + students.size());

        StudentDto student = dataCosmosClient.getStudent(studentDto.getId());
        logger.info("GET ONE FEING " + student);

        dataCosmosClient.deleteStudent(studentDto);
        logger.info("DELETE FEING " + student);

        return studentDto.getId();
    }
}
