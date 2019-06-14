package PlusZero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sentimentmain {
	public static void main(String[] args) {
		String negfile = "sentimentneg.txt";
		String posfile = "sentimentpos.txt";
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		String line = null;
		try {
			FileReader fileReader = new FileReader(negfile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			bufferedReader.close();
			sentimentalgorithm.init();
			for (String line1 : list) {
				System.out.println(line1 + " : " + sentimentalgorithm.findSentiment(line1));
			}

			FileReader fileReader1 = new FileReader(posfile);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			while ((line = bufferedReader1.readLine()) != null) {
				list1.add(line);
			}
			bufferedReader1.close();
			sentimentalgorithm.init();
			for (String line1 : list1) {
				System.out.println(line1 + " : " + sentimentalgorithm.findSentiment(line1));

			}
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}
}
