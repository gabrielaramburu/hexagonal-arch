package account.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.NonNull;

public class ActivityWindows {
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
	
	public Money calculateBalance() {
		return activities.stream()
			.map(Activity::getMoney)
			.reduce(Money.ZERO, Money::add);
			
		
	}
	
}
