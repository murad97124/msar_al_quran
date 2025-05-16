package com.gulfStreamTech.msar_al_quran.facade;

import com.gulfStreamTech.msar_al_quran.business.service.AccountService;
import com.gulfStreamTech.msar_al_quran.data.dto.request.AccountRequestDTO;
import com.gulfStreamTech.msar_al_quran.data.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountFacade {
    private final AccountService accountService;

    public Account registerNewAccount(AccountRequestDTO dto) {
        return accountService.register(dto);
    }
}