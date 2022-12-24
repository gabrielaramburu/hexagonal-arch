package account.model;

import lombok.Getter;

public class Money {
	
	@Getter
	private final Integer amount;

	private Money(Integer amount) {
		this.amount = amount;
	}
	
	public static Money of(Integer amount) {
		return new Money(amount);
	}

}
