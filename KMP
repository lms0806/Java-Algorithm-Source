public static int[] getpi(String s1) {
		int[] pi = new int[s1.length()];
		int j = 0;
		for (int i = 1; i < s1.length(); i++) {
			while (j > 0 && s1.charAt(i) != s1.charAt(j)) {
				j = pi[j - 1];
			}
			if (s1.charAt(i) == s1.charAt(j)) {
				pi[i] = j += 1;
			}
		}
		return pi;
	}

	public static boolean KMP(String s, String s1) {
		int[] pi = getpi(s1);
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j > 0 && s.charAt(i) != s1.charAt(j)) {
				j = pi[j - 1];
			}
			if (s.charAt(i) == s1.charAt(j)) {
				if (j == s1.length() - 1) {
					return true;
				} else {
					j++;
				}
			}
		}
		return false;
	}
