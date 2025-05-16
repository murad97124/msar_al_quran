package com.gulfStreamTech.msar_al_quran.controller;

import com.gulfStreamTech.msar_al_quran.data.dto.request.LoginRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.dto.response.LoginResponseDTO;
import com.gulfStreamTech.msar_al_quran.facade.AuthFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Login APIs")
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    @Operation(summary = "Login to account", description = "Authenticates using email or mobile and encrypted password")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(authFacade.login(dto));
    }
}