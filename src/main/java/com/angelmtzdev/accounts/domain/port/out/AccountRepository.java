package com.angelmtzdev.accounts.domain.port.out;

import com.angelmtzdev.accounts.domain.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountRepository {

    Mono<Account> save(Account account);

    Mono<Account> findById(UUID id);

    Flux<Account> findAll();
}
