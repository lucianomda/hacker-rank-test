package com.luciano.hackerranktest.java.advanced;

import java.io.File;
import java.io.FileWriter;

/**
 * Support class for Java Visitor Pattern problem: {@link JavaVisitorPattern}.
 *
 * @author lucianomda
 */
public class CreateTestFile {

	public static void createFile(String path) {
		try {

			File file = new File(System.getProperty("user.home") + "/test.txt");
			System.out.println(file.getAbsolutePath());
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();

			int n = 30;
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.append(String.valueOf(n)).append("\n");
			for (int i = 1; i <= n; i++) {
//				fileWriter.append(String.valueOf(i % 1001)).append(" ");
				fileWriter.append("1000 ");
			}

			fileWriter.append("\n");
			for (int i = 0; i < n; i++) {
//				fileWriter.append(String.valueOf(i%2)).append(" ");
				if (i == n-1 || i == 0) {
					fileWriter.append("1 ");
				} else {
					fileWriter.append("0 ");
				}
			}
			fileWriter.append("\n");

			for (int i = 0; i < n - 1; i++) {
				fileWriter.append(String.valueOf(i + 1)).append(" ").append(String.valueOf(i + 2)).append("\n");
			}
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
