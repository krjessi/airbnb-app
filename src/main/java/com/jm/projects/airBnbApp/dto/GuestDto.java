package com.jm.projects.airBnbApp.dto;

import com.jm.projects.airBnbApp.entity.User;
import com.jm.projects.airBnbApp.entity.enums.Gender;
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
