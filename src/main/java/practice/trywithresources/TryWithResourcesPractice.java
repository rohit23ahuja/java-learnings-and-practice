package practice.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryWithResourcesPractice {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input-file.txt"));
				PrintWriter pw = new PrintWriter(new FileWriter("src/main/resources/output-file.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				pw.println(line);
			}
		} catch (IOException e) {
			log.error("IO Exception", e);
		}
	}
}
