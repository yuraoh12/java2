
package example2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class javapractice2 {
	public static String main() {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date now = new Date();

		return sdf1.format(now);

		
	}

}