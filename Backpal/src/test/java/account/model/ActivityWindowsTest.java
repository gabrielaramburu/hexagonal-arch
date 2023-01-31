package account.model;

import static common.ActivityTestData.ActivityBuilder.defaultActivity;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ActivityWindowsTest {
	
	@Test
	void calculatesStarTimestamp() {
		ActivityWindows activityWindows = new ActivityWindows(
				defaultActivity().withTimeStamp(startDate()).build(),
				defaultActivity().withTimeStamp(inBetweenDate()).build(),
				defaultActivity().withTimeStamp(endDate()).build());
		
		assertThat(activityWindows.getStartTimestamp()).isEqualTo(startDate());
		
	}
	
	@Test
	void calculatesEndTimestamp() {
		ActivityWindows activityWindows = new ActivityWindows(
				defaultActivity().withTimeStamp(startDate()).build(),
				defaultActivity().withTimeStamp(inBetweenDate()).build(),
				defaultActivity().withTimeStamp(endDate()).build());
		
		assertThat(activityWindows.getEndTimestamp()).isEqualTo(endDate());
		
	}
	
	private LocalDateTime startDate() {
		return LocalDateTime.of(2019, 8, 3 ,0 ,0);
	}
	
	private LocalDateTime inBetweenDate() {
		return LocalDateTime.of(2019, 8, 4, 0, 0);
	}

	private LocalDateTime endDate() {
		return LocalDateTime.of(2019, 8, 5, 0, 0);
	}
}
