package account.model;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {
	private final AccountId id;
	private final Money baseLineBalance;
	@Getter
	private final ActivityWindows activityWindows;
	
	public static Account withoutId(
			Money baseLineBalance,
			ActivityWindows activitiWindos) {
		return new Account(null, baseLineBalance, activitiWindos);
		
	}
	
	public static Account withId(
					AccountId id,
					Money baseLineBalance,
					ActivityWindows activitiWindos) {
		return new Account(id, baseLineBalance, activitiWindos);	
	}
	
	public Money calculateBalance() {
		return Money.add(this.baseLineBalance, this.activityWindows.calculateBalance(this.id));
	}
	
	public boolean withdraw(Money drawAmount, Account.AccountId targetAccount) {
		if (!mayWithdraw(drawAmount)) return false;
		
		Activity withdraw = new Activity(
				this.id,
				this.id,
				targetAccount, 
				drawAmount, LocalDateTime.now());
		this.activityWindows.addActivity(withdraw);
		return true;
	}
	
	private boolean mayWithdraw(Money drawAmount) {
		return this.calculateBalance().isGreaterOrEqualTo(drawAmount) ? true: false;
	}

	public boolean deposit(Money deposit, Account.AccountId sourceAccount ) {
		Activity depositActivity = new Activity(
				this.id,
				sourceAccount,
				this.id,
				deposit,
				LocalDateTime.now());
		
		this.activityWindows.addActivity(depositActivity);
		return true;
	}
	@Value
	public static class AccountId {
		//I like the way this field is encapsulated. 
		//This allows us to change the id's type without to change the dependencies class.
		Long value;
	}
}
