package account.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {
	private final AccountId id;
	private final Money baseLineBalance;
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
		return new Money.add(this.baseLineBalance, this.activityWindows.calculateBalance());
	}
	
	@Value
	public static class AccountId {
		//I like the way this field is encapsulated. This allows us to change the id's type without to change the dependencies class.
		Long value;
	}
}
