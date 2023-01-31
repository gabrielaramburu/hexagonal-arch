package account.application.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import account.application.port.in.GetAccountBalanceQuery;
import account.application.port.out.LoadAccountPort;
import account.model.Account.AccountId;
import account.model.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery{

	private final LoadAccountPort loadAccountPort;
	
	@Override
	public Money getAccountBalance(AccountId accountId) {
		
		return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
				.calculateBalance();
	}

}
