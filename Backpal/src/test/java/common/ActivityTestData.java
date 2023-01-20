package common;

import java.time.LocalDateTime;

import account.model.Account;
import account.model.Account.AccountId;
import account.model.Activity;
import account.model.Activity.ActivityId;
import account.model.Money;

public class ActivityTestData {
	
	public static class ActivityBuilder {
		private ActivityId id;
		private Account.AccountId ownerAccount;
		private Account.AccountId sourceAccount;
		private Account.AccountId targetAccount;
		private Money money;
		private LocalDateTime timestamp;
		
		public static ActivityBuilder defaultActivity() {
			return new ActivityBuilder()
					.withOwnerAccount(new AccountId(42L))
					.withSourceAccount(new AccountId(42L))
					.withTargetAccount(new AccountId(41L))
					.withTimeStamp(LocalDateTime.now())
					.withMoney(Money.of(999));
		}
		
		public ActivityBuilder withActivityId(ActivityId id) {
			this.id = id;
			return this;
		}
		
		public ActivityBuilder withOwnerAccount(Account.AccountId ownerId) {
			this.ownerAccount = ownerId;
			return this;
		}
		
		public ActivityBuilder withSourceAccount(Account.AccountId id) {
			this.sourceAccount = id;
			return this;
		}
		
		public ActivityBuilder withTargetAccount(Account.AccountId id) {
			this.targetAccount = id;
			return this;
		}
		
		public ActivityBuilder withMoney(Money money) {
			this.money = money;
			return this;
		}
		
		public ActivityBuilder withTimeStamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		public Activity build() {
			return new Activity(
					this.id,
					this.ownerAccount, 
					this.sourceAccount, 
					this.targetAccount, 
					this.money, 
					this.timestamp
					);
		}
	}
}
