package account.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
@ToString
@EqualsAndHashCode
public class Money {
	
	public static final Money ZERO = Money.of(0);
	
	@Getter
	@NonNull
	private final Integer amount;

	private Money(Integer amount) {
		this.amount = amount;
	}
	
	public static Money of(Integer amount) {
		return new Money(amount);
	}

	public static Money add(Money a, Money b) {
		return new Money (a.getAmount() + (b.getAmount()));
	}
	
	public static Money substract(Money a, Money b) {
		return new Money (a.getAmount() - b.getAmount());
	}
	
	public boolean isGreaterThan(Money money) {
		return this.amount > money.getAmount() ? true : false;
	}
	
	public boolean isGreaterOrEqualTo(Money money) {
		return this.amount >= money.getAmount() ? true: false;
	}
}
