package com.example.second.model;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter

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