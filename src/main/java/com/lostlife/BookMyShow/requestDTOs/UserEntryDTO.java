package com.lostlife.BookMyShow.requestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDTO {

    private String name;

    private int age;

    private String email;

    private String mobNo;

    private String address;
}
