package account.adapter.out.persistence.activity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="activity")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJpaEntity {
	@Id
	@GeneratedValue
	private Long id;

	private Long ownerAccount;

	private Long sourceAccount;

	private Long targetAccount;

	private Integer money;

	private LocalDateTime timestamp;
}
