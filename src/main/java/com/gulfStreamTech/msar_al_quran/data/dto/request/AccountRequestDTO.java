package com.gulfStreamTech.msar_al_quran.data.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AccountRequestDTO {
    private String fullName;
    private String email;
    private String mobileNumber;
    private LocalDate birthdate;
    private String gender;
    private String password;
}
