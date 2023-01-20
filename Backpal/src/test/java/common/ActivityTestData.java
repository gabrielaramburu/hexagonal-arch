package common;

import java.time.LocalDateTime;

import account.model.Account;
import account.model.Money;
import account.model.Activity.ActivityId;
import lombok.NonNull;

public class ActivityTestData {
	public static class ActivityBuilder {
		private ActivityId id;
		private Account.AccountId ownerAccount;
		private Account.AccountId sourceAccount;
		private Account.AccountId targetAccount;
		private LocalDateTime timestamp;
		
		public ActivityBuilder withActivityId(ActivityId id) {
			this.id = id;
			return this;
		}
		
		public ActivityBuilder withOwnerAccount(Account.AccountId ownerId) {
			this.ownerAccount =ownerId;
			return this;
		}
	}
}
