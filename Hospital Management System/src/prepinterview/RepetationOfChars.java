package prepinterview;

import java.util.HashSet;

public class RepetationOfChars {

	public static void countCharRepeatation() {
		String str = "asdfghasdfgh";
		
		HashSet<Character> seenChars = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (!seenChars.contains(c)) {
				seenChars.add(c);
				int count = 0;
				for (int j = 0; j < str.length(); j++) {
					if (c == str.charAt(j)) {
						count++;
					}
				}
				System.out.println(c + " repeated in string " + count + " times");
				count = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countCharRepeatation();
	}

}
