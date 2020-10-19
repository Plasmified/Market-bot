/**
 * @author Pedro Filipe
 *
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Date date = new Date(System.currentTimeMillis());
		
		System.out.println("[SYSTEM] Drop delay (Seconds) : ");
		int delay = in.nextInt();
		
		System.out.println("[SYSTEM] How long ago was the previous drop (Seconds) : ");
		int prevdrop = in.nextInt();
		
		int i = 0;
		while (i != 1) {
			try {
				date = Calculate(delay, prevdrop, date);
				System.out.println("[SYSTEM] Next drop -> "+date);
				TimeUnit.SECONDS.sleep(delay-prevdrop);
			} catch (InterruptedException IE) {
				System.out.println("[SYSTEM] Something went wrong.");
			}
		}
	}
	
	public static Date Calculate(int delay, int previous_drop, Date date) {
		int nextdrop = delay-previous_drop;
		return new Date (System.currentTimeMillis() + nextdrop*1000);
	}
}
