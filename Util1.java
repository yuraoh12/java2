
public class Util1 {


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util1 {

	
	public static String getCurrentDate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);
		
		return formatedNow;
	
	}
}
