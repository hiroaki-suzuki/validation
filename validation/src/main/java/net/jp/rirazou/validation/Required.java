package net.jp.rirazou.validation;

/**
 * 必須チェックをおこなうクラス。<br>
 * nullチェックを行い、その後オブジェクトをtoStringで文字列に変換し、その値が空かどうかを判定する。
 *
 * @version $Revision: 740 $ $Date: 2014-08-21 15:37:01 +0900 (木, 21 8 2014) $
 * @author $Author: h-suzuki $
 *
 * @param <T> 検証値の型
 */
public class Required<T> extends Validation<T> {

	/** 空白関連の文字列を許可するかどうか */
	private boolean allowWhiteSpace;

	/**
	 * 必須チェックを行うインスタンスを生成する。
	 *
	 * @param value 検証値
	 * @param invalidMessage 不正だった場合のメッセージ
	 */
	protected Required(T value, String invalidMessage) {
		this(value, invalidMessage, false);
	}

	/**
	 * 必須チェックを行い、その際に空白関連の文字列を許可するかどうかを指定できるインスタンスを生成する。
	 *
	 * @param value 検証値
	 * @param invalidMessage 不正だった場合のメッセージ
	 * @param allowWhiteSpace 空白関連の文字列を許可するかどうか
	 */
	protected Required(T value, String invalidMessage, boolean allowWhiteSpace) {
		super(value, invalidMessage);
		this.allowWhiteSpace = allowWhiteSpace;
	}

	/**
	 * 必須チェックを行うインスタンスを生成する。
	 *
	 * @param value 検証値
	 * @param invalidMessage 不正だった場合のメッセージ
	 * @return 必須チェックインスタンス
	 */
	public static <T> Required<T> required(T value, String invalidMessage) {
		return new Required<T>(value, invalidMessage);
	}

	/**
	 * 必須チェックを行い、その際に空白関連の文字列を許可するかどうかを指定できるインスタンスを生成する。
	 *
	 * @param value 検証値
	 * @param invalidMessage 不正だった場合のメッセージ
	 * @param allowWhiteSpace 空白関連の文字列を許可するかどうか
	 * @return 必須チェックインスタンス
	 */
	public static <T> Required<T> required(T value, String invalidMessage, boolean allowWhiteSpace) {
		return new Required<T>(value, invalidMessage, allowWhiteSpace);
	}

	@Override
	protected boolean validate() {
		if (getValue() == null) {
			return false;
		}
		String val = getValue().toString();

		int strLen;
		if ((strLen = val.length()) == 0) {
			return false;
		}

		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(val.charAt(i)) == false) {
				return true;
			}
			if (allowWhiteSpace) {
				return true;
			}
		}
		return false;
	}
}
