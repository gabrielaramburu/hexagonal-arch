package common;

import static common.ActivityTestData.ActivityBuilder.defaultActivity;

import account.model.Account;
import account.model.Account.AccountId;
import account.model.ActivityWindows;
import account.model.Money;

public class AccountTestData {
	
	public static AccountBuilder defaultAccount() {
		return new AccountBuilder()
				.withAccountId(new AccountId(42L))
				.withBaseLine(Money.of(999))
				.withActivityWindow(new ActivityWindows(
						defaultActivity().build(),
						defaultActivity().build()));
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
	
	
}
