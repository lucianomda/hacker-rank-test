package com.luciano.smallexec.work;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BossTest {
	@Mock
	private Worker worker;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@DataProvider(name = "badResultsDataProvider")
	public Object[][] badResultsDataProvider() {
		return new Object[][] {{0}, {1}, {2}, {3}};
	}

	@Test(dataProvider = "badResultsDataProvider")
	public void testEvaluate_fired(int workResult) {
		Boss boss = new Boss();
		when(worker.work()).thenReturn(workResult);
		assertThat(boss.evaluate(worker)).isEqualTo("fired");
	}

	@DataProvider(name = "goodResultsDataProvider")
	public Object[][] goodResultsDataProvider() {
		return new Object[][] {{4}, {5}, {6}, {7}, {8}, {9}, {10}};
	}

	@Test(dataProvider = "goodResultsDataProvider")
	public void testEvaluate_mustImprove(int workResult) {
		Boss boss = new Boss();
		when(worker.work()).thenReturn(workResult);
		assertThat(boss.evaluate(worker)).isEqualTo("must improve");
	}
}