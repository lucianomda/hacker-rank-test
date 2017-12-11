package com.luciano.smallexec.work;

import org.apache.commons.lang3.RandomUtils;

public class Worker {
	public int work() {
		return RandomUtils.nextInt(0, 10);
	}
}
