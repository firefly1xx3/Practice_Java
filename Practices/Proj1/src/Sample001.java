import java.util.Arrays;
import java.text.*;

public class Sample001 {
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		int num = (int)(Math.random() * 20);
		System.out.println(num + "...");
		question_1(num);
		q2(num);
		int nums[] = new int[3];
		for (int i = 0; i < 3; i++) {
			num = (int)(Math.random() * 20);
			nums[i] = num;
			System.out.println(num);
		}
		// To write whole array's elements simply
		System.out.println(Arrays.toString(nums));
		System.out.println(nums.length);
		q3(nums);
		
		var a = Math.random() * 20;
		var b = Math.random() * 20;
		var c = Math.random() * 20;
		System.out.printf("%fx^2 + %fx + %f", a, b, c);
		q4(a, b, c);
	}
	
	public static void question_1(int num) {
		System.out.println("Q1");
		if (num % 2 == 0) {
			System.out.println(num + " is an Even number");
		} else {
			System.out.println(num + " is an Odd number");
		}
	}
	public static void q2(int num) {
		System.out.println("Q2");
		if (num < 10 && num >= 0) {
			System.out.println(num + " is 1 digit natural number");
		} else {
			System.out.println(num + " is NOT 1 digit natural number");
		}
	}
	public static void q3(int[] nums) {
		System.out.println("Q3");
		var check = true;
		for(int i = 0; i < nums.length - 1; i++) {
			if(check) {
				if (nums[i] > nums[i+1]) {
					check = false;
				}
			}
		}
		if (check) {
			System.out.println("OK");
		} else {
			System.out.println("NG");
		}
	}
	public static void q4(double a, double b, double c) {
		System.out.println("Q4");
		var discriminant = Math.pow(b, 2) - (4 * a * c);
		System.out.println("discriminant is " + discriminant);
		if (discriminant > 0) {
			System.out.println("This equation has 2 real number solutions");
		} else if (discriminant == 0) {
			System.out.println("This equation has just 1 real number solution");
		} else {
			System.out.println("This equation has 2 imaginary number solutions");
		}
	}
}