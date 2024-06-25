public static boolean BoyerMooreMatch(String str, String pattern) {
		int strCursor = 0, patternCursor = 0;
		int strLen = str.length(), patternLen = pattern.length();
		int[] skip = new int[Character.MAX_VALUE + 1];

		// 패턴에 존재하지 않는 경우 = 패턴의 길이
		// 패턴에 존재하는 경우 = skip해야 하는 칸수
		// 에 해당하도록 skip 배열 설정
		for (strCursor = 0; strCursor < Character.MAX_VALUE; strCursor++) {
			skip[strCursor] = patternLen;
		}

		for (strCursor = 0; strCursor < patternLen - 1; strCursor++) {
			char c = pattern.charAt(strCursor);
			skip[c] = patternLen - strCursor - 1;
		}

		while (strCursor < strLen) {
			patternCursor = patternLen - 1;

			// 비교하는 문자열과 패턴이 뒤에서부터 계속 일치하여
			// cursor의 값을 줄이면서 계속 비교하는 과정
			while (str.charAt(strCursor) == pattern.charAt(patternCursor)) {
				if (patternCursor == 0) {
					// 패턴과 일치하는 문자열을 찾은 경우 시작 인덱스를 반환
					// strCursor = 위치
					return true;
				}
				patternCursor--;
				strCursor--;
			}

			char c = str.charAt(strCursor);
			strCursor += Math.max(skip[c], patternLen - patternCursor);
		}

		return false;
	}
