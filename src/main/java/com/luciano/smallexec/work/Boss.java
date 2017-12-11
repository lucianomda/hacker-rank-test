package com.luciano.smallexec.work;


public class Boss {
	public String evaluate(Worker worker) {
		String result = "fired";
		if (worker.work() >= 4) {
			result = "must improve";
		}
		return result;
	}
}
