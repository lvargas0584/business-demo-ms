package com.bcp.business.demo.core.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private AdrressDto address;
}
