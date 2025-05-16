package com.gulfStreamTech.msar_al_quran.business.service;

import com.gulfStreamTech.msar_al_quran.business.util.RSAUtil;
import com.gulfStreamTech.msar_al_quran.data.dto.request.AccountRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.entity.Account;
import com.gulfStreamTech.msar_al_quran.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account register(AccountRequestDTO dto) {
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is mandatory.");
        }

        boolean hasAdditionalInfo =
                (dto.getFullName() != null && !dto.getFullName().isBlank()) ||
                        (dto.getPassword() != null && !dto.getPassword().isBlank()) ||
                        dto.getBirthdate() != null ||
                        (dto.getGender() != null && !dto.getGender().isBlank()) ||
                        (dto.getMobileNumber() != null && !dto.getMobileNumber().isBlank());

        if (!hasAdditionalInfo) {
            throw new IllegalArgumentException("At least one additional field (besides email) must be provided.");
        }

        Account account = new Account();
        account.setEmail(dto.getEmail());
        account.setMobileNumber(dto.getMobileNumber());
        account.setFullName(dto.getFullName() != null ? RSAUtil.encrypt(dto.getFullName()) : null);
        account.setPassword(dto.getPassword() != null ? RSAUtil.encrypt(dto.getPassword()) : null);
        account.setBirthdate(dto.getBirthdate() != null ? RSAUtil.encrypt(dto.getBirthdate().toString()) : null);
        account.setGender(dto.getGender() != null ? RSAUtil.encrypt(dto.getGender()) : null);

        return repository.save(account);
    }
}
