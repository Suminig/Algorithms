import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[10];

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int sum = a * b * c;
		String sumString = Integer.toString(sum);

		for (int i = 0; i < sumString.length(); i++) {
			nums[sumString.charAt(i) - '0']++;
		}

		for (int num : nums) {
			System.out.println(num);
		}

	}

}
