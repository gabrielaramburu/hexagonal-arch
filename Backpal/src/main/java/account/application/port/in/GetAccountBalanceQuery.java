package account.application.port.in;

import account.model.Account;
import account.model.Money;

public interface GetAccountBalanceQuery {
	
	Money getAccountBalance(Account.AccountId accountId);
}
