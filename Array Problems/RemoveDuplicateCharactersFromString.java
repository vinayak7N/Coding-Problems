import java.util.HashSet;

/*
 * @author Vinayak Nair$
 *
 */
public class RemoveDuplicateCharactersFromString {

	public static String removeDuplicateFromString(String string) {
		
		if (string == null || string == "")
			return string;
		string = string.toLowerCase();
		HashSet<Character> uniqueCharSet = new HashSet<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			if (!uniqueCharSet.contains(string.charAt(i))) {
				uniqueCharSet.add(string.charAt(i));
				sb.append(string.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String inputString = "MalayalamLanguage";
		System.out.println("After removing duplicates: " + removeDuplicateFromString(inputString));
	}

}
