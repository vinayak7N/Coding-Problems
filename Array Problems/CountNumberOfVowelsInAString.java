/*
 * @author Vinayak Nair$
 *
 */
public class CountNumberOfVowelsInAString {

	public static int countNumberOfVowels(String string) {
		if (string == null || string == "")
			return 0;
		string = string.toLowerCase();
		char[] charArray = string.toCharArray();
		int count = 0;
		for (char c : charArray) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("No. of voewls in \"asdfgyhujipoiuytrewasdfghjkmnbd\" is "
				+ countNumberOfVowels("asdfgyhujipoiuytrewasdfghjkmnbd"));
	}

}
