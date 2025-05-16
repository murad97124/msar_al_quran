package com.gulfStreamTech.msar_al_quran.controller;

import com.gulfStreamTech.msar_al_quran.data.dto.request.AccountRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.entity.Account;
import com.gulfStreamTech.msar_al_quran.facade.AccountFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Tag(name = "Account Registration", description = "APIs for registering new accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping("/register")
    @Operation(summary = "Register new account", description = "Registers an account with encrypted sensitive fields")
    public ResponseEntity<Account> register(@RequestBody AccountRequestDTO dto) {
        Account saved = accountFacade.registerNewAccount(dto);
        return ResponseEntity.ok(saved);
    }
}
