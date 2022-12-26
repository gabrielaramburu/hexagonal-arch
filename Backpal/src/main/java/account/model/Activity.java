package account.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Activity {

	private ActivityId id;
	private final Account.AccountId sourceAccount;
	private final Account.AccountId targetAccount;
	private final Money money;
	private final LocalDateTime timestamp;
	
	public Activity (
			@NonNull Account.AccountId sourceAccount,
			@NonNull Account.AccountId targetAccount,
			@NonNull Money money,
			@NonNull LocalDateTime timestamp) {
		this.id =null;// the Id is unknown until the entity is saved in the database 
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
