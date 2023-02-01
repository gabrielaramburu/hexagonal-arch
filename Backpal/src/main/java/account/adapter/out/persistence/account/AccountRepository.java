package account.adapter.out.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Repository pattern definition 
 * differs from this kind of Repository implementation that I know, 
 * specially because this is coupled with a particular persistence mechanism (JpaRepository).
 * 
 * For me, the AccountPersistenceAdapter class looks closer to the repository idea that I have.
 */
public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long>{
	//Spirng injects implementations that offers crud and paging functionality.
}
