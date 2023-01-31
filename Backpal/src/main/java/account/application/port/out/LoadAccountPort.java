package account.application.port.out;

import java.time.LocalDateTime;

import account.model.Account;
import account.model.Account.AccountId;

public interface LoadAccountPort {
	Account loadAccount(AccountId accountId, LocalDateTime baseLineDate);
}
