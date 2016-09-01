/**
 * Write a function to calculate the angle between hour and minute hand on a clock.
 */
package Numbers;

public class AngleBetweenTime {
	
	public static void main(String[] args) {

		int hour = 1;
		int minute = 35;
		
		if(hour > 12 || hour < 1){
			System.out.println("Enter hour again");
		}
		
		if(minute < 1 || minute > 60){
			System.out.println("Enter minute again");
		}
		int h_angle = hour * 30;	
		
		int m_angle =  (minute/5) * 30;
		
		int diff = Math.abs(h_angle - m_angle);
		
		System.out.println(h_angle+" "+m_angle);
		System.out.println(diff);
		
	}
}
