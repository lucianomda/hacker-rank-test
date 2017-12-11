package com.luciano.smallexec.work;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkerTest {

	@Test
	public void testWork() {
		Worker worker = new Worker();
		assertThat(worker.work()).isBetween(0, 10);
	}
}