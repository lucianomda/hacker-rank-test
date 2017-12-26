package com.luciano.hackerranktest.java.introduction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution for
 * https://www.hackerrank.com/challenges/java-end-of-file/problem
 * Java End Of File
 *
 * @author lucianomda
 *
 */
public class JavaEndOfFile {

	private static final int MAX_LINES_BEFORE_WRITE = 100;

	public static void main(String[] args) {
		File tmpFile = null;
		try {
			tmpFile = createTmpFile();
			readLines(tmpFile);
			printFileLines(tmpFile);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (tmpFile != null && tmpFile.exists()) {
				tmpFile.delete();
			}
		}
	}

	private static File createTmpFile() throws IOException {
		return File.createTempFile(String.valueOf(System.nanoTime()), "temp");
	}

	private static void readLines(File file) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<String> lines = new ArrayList<>(MAX_LINES_BEFORE_WRITE);
		while (sc.hasNext()) {
			lines.add(sc.nextLine());
			if (lines.size() == MAX_LINES_BEFORE_WRITE) {
				Files.write(Paths.get(file.getPath()), lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				lines.clear();
			}
		}

		if (lines.size() > 0) {
			Files.write(Paths.get(file.getPath()), lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		}

		sc.close();
	}

	private static void printFileLines(File file) {
		Scanner fileSc = null;
		try {
			fileSc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int count = 1;
		while (fileSc.hasNext()) {
			System.out.printf("%d %s\n", count++, fileSc.nextLine());
		}

		fileSc.close();
	}
}
