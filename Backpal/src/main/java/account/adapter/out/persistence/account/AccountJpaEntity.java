package account.adapter.out.persistence.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a Row data gateway (Enterprise pattern) : 
 * a class that represents a row in a table
 *
 */
@Entity
@Table(name = "account")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountJpaEntity {
	@Id
	@GeneratedValue
	private Long id;
}
