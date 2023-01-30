package account.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import account.model.Account.AccountId;
import lombok.Getter;
import lombok.NonNull;

public class ActivityWindows {
	@Getter
	private List<Activity> activities;

	public ActivityWindows(@NonNull List<Activity> activities) {
		this.activities = activities;
	}
	
	public ActivityWindows(@NonNull Activity... activities)  {
		this.activities = new ArrayList<Activity>(Arrays.asList(activities));
	}
	
	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public Money calculateBalance(AccountId accountId) {
		Money in = activities.stream()
			.filter(a -> a.getTargetAccount().equals(accountId))
			.map(Activity::getMoney)
			.reduce(Money.ZERO, Money::add); //reduce use a BiFucntion
			
		Money out = activities.stream()
				.filter(a -> a.getSourceAccount().equals(accountId))
				.map(Activity::getMoney)
				.reduce(Money.ZERO, Money::add);
		
		return Money.substract(in, out);
	}
	
}
