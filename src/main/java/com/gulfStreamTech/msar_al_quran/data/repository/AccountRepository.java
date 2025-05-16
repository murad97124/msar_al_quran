package com.gulfStreamTech.msar_al_quran.data.repository;

import com.gulfStreamTech.msar_al_quran.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);

    Optional<Account> findByMobileNumber(String mobileNumber);
}
