package net.jp.rirazou.validation;

/**
 * バリデーションパッケージのユーティリティクラス。
 *
 * @author Hiroaki Suzuki
 */
public class ValidationUtils {

	/**
	 * 文字列がnullか空文字かを判定して、その結果を返す。<br>
	 *
	 * @param cs 判定対象の文字列
	 * @return 文字列がnull、または空文字ならtrue
	 */
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * 文字列がnullか空文字かを判定して、その結果を返す。<br>
	 *
	 * @param cs 判定対象の文字列
	 * @return 文字列がnull、または空文字でなければtrue
	 */
	public static boolean isNotEmpty(final CharSequence cs) {
		return !ValidationUtils.isEmpty(cs);
	}

	/**
	 * 文字列がnullか空文字かを判定して、その結果を返す。<br>
	 * Character.isWhitespaceでの空白判定も行う。
	 *
	 * @param cs 判定対象の文字列
	 * @return 文字列がnull、または空文字ならtrue
	 */
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}

		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 文字列がnullか空文字かを判定して、その結果を返す。<br>
	 * Character.isWhitespaceでの空白判定も行う。
	 *
	 * @param cs 判定対象の文字列
	 * @return 文字列がnull、または空文字でなければtrue
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return !ValidationUtils.isBlank(cs);
	}
}
