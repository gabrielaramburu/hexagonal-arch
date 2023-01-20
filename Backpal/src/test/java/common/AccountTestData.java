package common;

import account.model.Account;
import account.model.Account.AccountId;
import account.model.ActivityWindows;
import account.model.Money;

public class AccountTestData {
	public static Account buildDefaultAccount() {
		return new AccountBuilder()
				.withAccountId(new AccountId(42L))
				.withBaseLine(Money.of(999))
				.withActivityWindow(null)
				.build();
				
	}
	
	public static class AccountBuilder {
		private AccountId accountId;
		private Money baseLine;
		private ActivityWindows activityWindows;
		
		public  AccountBuilder withAccountId(AccountId accountId) {
			this.accountId = accountId;
			return this;
		}
		
		public AccountBuilder withBaseLine(Money baseLine) {
			this.baseLine = baseLine;
			return this;
		}
		
		public AccountBuilder withActivityWindow(ActivityWindows activity) {
			this.activityWindows = activity;
			return this;
		}
		
		public Account build() {
			return Account.withId(
					this.accountId, this.baseLine, this.activityWindows);
					
		}
	}
	
	public static class ActivityBuilder {
		
	}
	
}
