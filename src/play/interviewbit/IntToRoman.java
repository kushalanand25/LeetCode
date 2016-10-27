package play.interviewbit;

public class IntToRoman {
	static public String intToRoman(int num) {
		int[] integer = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		if (num < 1)
			return null;

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < integer.length; i++) {
			int q = num / integer[i];
			while (q > 0) {
				str.append(roman[i]);
				q--;
			}
			num = num % integer[i];
		}

		return str.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1903));
		System.out.println(intToRoman(1997));
		System.out.println(intToRoman(27));
	}
}
