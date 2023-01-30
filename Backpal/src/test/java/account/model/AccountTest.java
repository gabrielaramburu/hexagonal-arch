package account.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import common.ActivityTestData;

import static common.AccountTestData.defaultAccount;
import static common.ActivityTestData.ActivityBuilder.*;

public class AccountTest {
	@Test
	void calculatedBalance() {
		Account.AccountId accountId = new Account.AccountId(1L);
		Account account = defaultAccount()
			.withAccountId(accountId)
			.withBaseLine(Money.of(555))
			.withActivityWindow(new ActivityWindows(
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(999)).build(),
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(1)).build()))
			.build();
		
		Money balance = account.calculateBalance();
		assertThat(balance.equals(Money.of(1555)));
	}
	
	@Test
	void withdrawalSucceed() {
		Account.AccountId accountId = new Account.AccountId(1L);
		Account account = defaultAccount()
			.withAccountId(accountId)
			.withBaseLine(Money.of(555))
			.withActivityWindow(new ActivityWindows(
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(999)).build(),
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(1)).build()))
			.build();
		
		boolean success = account.withdraw(Money.of(555), new Account.AccountId(99L));
		assertThat(success).isTrue();
		assertThat(account.calculateBalance()).isEqualTo(Money.of(1000));
		assertThat(account.getActivityWindows().getActivities()).hasSize(3);
		
	}
	
	@Test
	void withdrawalFailure() {
		Account.AccountId accountId = new Account.AccountId(1L);
		Account account = defaultAccount()
			.withAccountId(accountId)
			.withBaseLine(Money.of(555))
			.withActivityWindow(new ActivityWindows(
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(999)).build(),
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(1)).build()))
			.build();
		
		boolean success = account.withdraw(Money.of(1556), new Account.AccountId(99L));
		assertThat(success).isFalse();
		assertThat(account.calculateBalance()).isEqualTo(Money.of(1555));
		assertThat(account.getActivityWindows().getActivities()).hasSize(2);
		
	}
	
	@Test
	void deposit() {
		Account.AccountId accountId = new Account.AccountId(1L);
		Account account = defaultAccount()
			.withAccountId(accountId)
			.withBaseLine(Money.of(555))
			.withActivityWindow(new ActivityWindows(
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(999)).build(),
					defaultActivity()
						.withTargetAccount(accountId)
						.withMoney(Money.of(1)).build()))
			.build();
		
		boolean success =account.deposit(Money.of(100), new Account.AccountId(99L));
		assertThat(success).isTrue();
		assertThat(account.calculateBalance()).isEqualTo(Money.of(1655));
		assertThat(account.getActivityWindows().getActivities()).hasSize(3);
	}
}
