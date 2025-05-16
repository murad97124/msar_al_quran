package com.gulfStreamTech.msar_al_quran.data.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequestDTO {
    private String email;
    private String mobileNumber;
    private String password;
}
