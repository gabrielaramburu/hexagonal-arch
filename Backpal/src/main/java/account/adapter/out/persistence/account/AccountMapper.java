package account.adapter.out.persistence.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import account.adapter.out.persistence.activity.ActivityJpaEntity;
import account.model.Account;
import account.model.Activity;
import account.model.ActivityWindows;
import account.model.Money;

/**
 * Two way strategy
 *  "The mapping responsibilities are clear: the outer layers / adapters
map into the model of the inner layers and back. 
The inner layers only know their own model and
can concentrate on the domain logic instead of mapping."
 *
 */
@Component
class AccountMapper {
	Account mapToDamainEntity(
			AccountJpaEntity account,
			List<ActivityJpaEntity> activities,
			Integer withdrawalBalance,
			Integer depositBalance) {
		
		Money baseLine = Money.substract(
				Money.of(depositBalance), Money.of(withdrawalBalance));
		
		return Account.withId(
				new Account.AccountId(account.getId()), 
				baseLine, 
				mapToActivityWindos(activities));
	}

	private ActivityWindows mapToActivityWindos(List<ActivityJpaEntity> activities) {
		List<Activity> mappedActivities = new ArrayList<>();
		for (ActivityJpaEntity activity: activities) {
			mappedActivities.add(new Activity(
					new Activity.ActivityId(activity.getId()),
					new Account.AccountId(activity.getOwnerAccount()),
					new Account.AccountId(activity.getSourceAccount()),
					new Account.AccountId(activity.getTargetAccount()),
					Money.of(activity.getMoney()),
					activity.getTimestamp()));
		}
		
		return new ActivityWindows(mappedActivities);
	}
}
