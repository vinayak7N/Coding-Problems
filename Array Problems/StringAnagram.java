import java.util.Arrays;

/*
 * @author Vinayak Nair$
 *
 */
public class StringAnagram {

	/*
	 * Complexity: O(m+n) ,where m and n are length of two strings
	 */

	public static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] letters = new int[256];

		for (char c : s1.toCharArray()) {

			letters[c]++;
		}
		for (char c : s2.toCharArray()) {
			letters[c]--;
		}
		for (int i : letters) {
			if (i != 0)
				return false;
		}
		return true;

	}

	/*
	 * Checking Anagram using sorting. 
	 * Complexity: O(nlogn)
	 */
	public static boolean isAnagramUsingSorting(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Is anagram: " + isAnagram("abbased", "aedsbab"));
		System.out.println("Is anagram: " + isAnagramUsingSorting("abbased", "aedsbab"));
	}

}
