package interviews;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * This class contains a string operation function and JUnit test cases 
 *
 * 
 * @author Zvi Fried
 *
 */
public class StringOperarions {
	
	/**
	 * Return the index number of the starting character in case that String x contains string y
	 * If String x does not contains String y, -1 is returned
	 * @param x
	 * @param y
	 * @return int
	 */
	static int getIndex(String x, String y) {

		if (y.length() > x.length()) {
			return -1;
		}

		char[] xArr = x.toCharArray();
		char[] yArr = y.toCharArray();

		for (int i = 0; i < xArr.length; i++) {
			if (yArr.length > xArr.length - i) {
				return -1;
			}

			if (xArr[i] == yArr[0]) {
				int index = i;
				for (int j = 0; j < yArr.length && i < xArr.length; j++, i++) {
					if (yArr[j] != xArr[i]) {
						i = index + yArr.length - 2;
						break;
					} else if (j + 1 == yArr.length) {
						return index;
					}
				}
			}
		}
		return -1;
	}

	// Test Cases
	@Test
	void equalStrTest() {
		assertEquals(getIndex("abc", "abc"), 0);
	}

	@Test
	void lastCharTest() {
		assertEquals(getIndex("abc", "c"), 2);
	}

	@Test
	void partialMatchAtStartTest() {
		assertEquals(getIndex("abc", "abd"), -1);
	}
	
	@Test
	void partialMatchAtEndTest() {
		assertEquals(getIndex("abc", "bcd"), -1);
	}

	@Test
	void multiIterationsWithMatchTest() {
		assertEquals(getIndex("abcabcd", "abcd"), 3);
	}

	@Test
	void multiIterationsPartialMatchTest() {
		assertEquals(getIndex("abcabcd", "abcde"), -1);
	}

	@Test
	void longerStingOnLeftTest() {
		assertEquals(getIndex("a", "ab"), -1);
	}

	@Test
	void longStingNoMatchTest() {
		assertEquals(getIndex("abcdefghijklmnopqrstuvwxy", "z"), -1);
	}

}
