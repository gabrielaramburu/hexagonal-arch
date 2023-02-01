package account.adapter.out.persistence.account;

import java.time.LocalDateTime;
import java.util.List;

import account.adapter.out.persistence.activity.ActivityJpaEntity;
import account.adapter.out.persistence.activity.ActivityRepository;
import account.application.port.out.LoadAccountPort;
import account.model.Account;
import account.model.Account.AccountId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountPersistenteAdapter implements LoadAccountPort{

	private final AccountRepository accountRepository;
	private final ActivityRepository activityRepository;
	
	@Override
	public Account loadAccount(AccountId accountId, LocalDateTime baseLineDate) {
		AccountJpaEntity account = 
				accountRepository.findById(accountId.getValue())
				.orElseThrow(EntityNotFoundException::new);
		
		List<ActivityJpaEntity> activities =
		activityRepository.findByOwnerSince(accountId.getValue(), baseLineDate);
		
		return null;
	}

}
