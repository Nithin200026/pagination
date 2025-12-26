package com.pagination.first.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Document(collection = "Employee")
public class Employee {

    public static String ID="id";
    public static String NAME="name";
    public static String EMAIL="email";
    public static String DEPARTMENT="department";
    public static String SALARY="salary";

    private String id;
    private String name;
    private String email;
    private String department;
    private String salary;

}