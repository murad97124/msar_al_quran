package com.gulfStreamTech.msar_al_quran.facade;

import com.gulfStreamTech.msar_al_quran.business.service.AuthService;
import com.gulfStreamTech.msar_al_quran.data.dto.request.LoginRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.dto.response.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {
    private final AuthService authService;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        return authService.login(dto);
    }
}
