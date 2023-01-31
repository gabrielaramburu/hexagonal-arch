package account.adapter.out.persistence;

import java.time.LocalDateTime;

import account.application.port.out.LoadAccountPort;
import account.model.Account;
import account.model.Account.AccountId;

public class AccountPersistenteAdapter implements LoadAccountPort{

	@Override
	public Account loadAccount(AccountId accountId, LocalDateTime baseLineDate) {
		return null;
	}

}
