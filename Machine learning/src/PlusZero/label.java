package PlusZero;
import java.io.*;
import java.util.*;

public class label {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		String negfile = "rt-polarity.neg";
		String posfile = "rt-polarity.pos";
		List<String> list = new ArrayList<String>();
		PrintWriter writer = new PrintWriter("sentiment.txt", "UTF-8");
		
		
		int pos = 0,neg=0;
		String line = null;
		try {
			FileReader fileReader = new FileReader(negfile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				list.add("-1 " + line);
			}
			bufferedReader.close();

			FileReader fileReader1 = new FileReader(posfile);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			while ((line = bufferedReader1.readLine()) != null) {
				list.add("+1 " + line);
			}
			bufferedReader1.close();

			Collections.shuffle(list, new Random());

			for (int i = 0; i < list.size(); i++) {

				writer.println(list.get(i));
				if(list.get(i).startsWith("+1"))
				pos++;
				else
					neg++;
				
			}
			System.out.println("正例の数: "+pos);
			System.out.println("負例の数: "+neg);
			writer.close();
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}
}