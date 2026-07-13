package com.angelmtzdev.accounts.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Account(UUID id, String accountNumber, String ownerName, BigDecimal balance) {

}
