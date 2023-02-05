package account.adapter.out.persistence.account;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import account.adapter.out.persistence.account.AccountPersistenteAdapter;

@DataJpaTest
@Import({AccountPersistenteAdapter.class, AccountMapper.class})
public class AccountPersistenceAdapterTest {

}
