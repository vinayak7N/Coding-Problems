/*
 * @author Vinayak Nair$
 *
 */
public class CircleArea {
	final static double PI = Math.PI;

	public static double areaOfCircle(int radius) {
		if (radius == 0) {
			return 0;
		}
		return PI * radius * radius;
	}

	public static double circumferenceOfCircle(int radius) {
		if (radius == 0) {
			return 0;
		}
		return PI * radius * 2;
	}

	public static void main(String[] args) {
		System.out.println("Area of Circle with radius 7 is " + areaOfCircle(7));
		System.out.println("Circumference of Circle with radius 7 is " + circumferenceOfCircle(7));
	}

}
