package account.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;

@Getter

public class Activity {

	private ActivityId id;
	@NonNull
	private final Account.AccountId ownerAccount;
	@NonNull
	private final Account.AccountId sourceAccount;
	@NonNull
	private final Account.AccountId targetAccount;
	@NonNull
	private final Money money;
	@NonNull
	private final LocalDateTime timestamp;
	

	public Activity (
			@NonNull Account.AccountId ownerAccount,
			@NonNull Account.AccountId sourceAccount,
			@NonNull Account.AccountId targetAccount,
			@NonNull Money money,
			@NonNull LocalDateTime timestamp) {
		this.id =null;// the Id is unknown until the entity is saved in the database 
		this.ownerAccount = ownerAccount;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
		this.money = money;
		this.timestamp = timestamp;
		
	}
	public static class ActivityId {
		@Getter
		private final Long id;
		
		public ActivityId(Long id) {
			this.id = id;
		}
	}
}
