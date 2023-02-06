package account.adapter.out.persistence.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import account.model.Account;
import account.model.Account.AccountId;
import account.model.Money;

@DataJpaTest
@Import({AccountPersistenceAdapter.class, AccountMapper.class})
public class AccountPersistenceAdapterTest {
	
	@Autowired
	AccountPersistenceAdapter adapter;
	
	@Autowired
	AccountMapper mapper;
	
	
	@Test
	@Sql("AccountPersistenceAdapterTest.sql")
	void loadAccount() {
		Account account = adapter.loadAccount(new AccountId(1L), LocalDateTime.of(2018,8,10,0,0));
		
		assertThat(account.getActivityWindows().getActivities()).hasSize(2);
		assertThat(account.calculateBalance()).isEqualTo(Money.of(500));
		
	}

}
