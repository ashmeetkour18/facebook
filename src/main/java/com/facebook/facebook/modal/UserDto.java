package com.facebook.facebook.modal;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String surname;
    private String email;
    private String password;
    private Integer birth_date;
    private String birthday_month;
    private Integer birthday_year;
    private String gender;
}
