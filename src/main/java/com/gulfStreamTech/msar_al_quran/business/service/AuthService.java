package com.gulfStreamTech.msar_al_quran.business.service;

import com.gulfStreamTech.msar_al_quran.business.util.RSAUtil;
import com.gulfStreamTech.msar_al_quran.data.dto.request.LoginRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.dto.response.LoginResponseDTO;
import com.gulfStreamTech.msar_al_quran.data.entity.Account;
import com.gulfStreamTech.msar_al_quran.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        if ((dto.getEmail() == null || dto.getEmail().isBlank()) &&
                (dto.getMobileNumber() == null || dto.getMobileNumber().isBlank())) {
            return new LoginResponseDTO(false, "Email or Mobile Number must be provided.");
        }

        Optional<Account> optionalAccount = (dto.getEmail() != null && !dto.getEmail().isBlank())
                ? accountRepository.findByEmail(dto.getEmail())
                : accountRepository.findByMobileNumber(dto.getMobileNumber());

        if (optionalAccount.isEmpty()) {
            return new LoginResponseDTO(false, "User not found.");
        }

        Account account = optionalAccount.get();
        String encryptedPassword = RSAUtil.encrypt(dto.getPassword());

        if (encryptedPassword.equals(account.getPassword())) {
            return new LoginResponseDTO(true, "Login successful.");
        } else {
            return new LoginResponseDTO(false, "Invalid credentials.");
        }
    }
}
