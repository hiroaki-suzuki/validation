package net.jp.rirazou.validation;

/**
 * バリデーションを行う抽象クラス。
 *
 * @author Hiroaki Suzuki
 *
 * @param <T> 検証値の型
 */
public abstract class Validation<T> {

	/** 検証値 */
	private T value;

	/** 不正だった場合のメッセージ */
	private String invalidMessage;

	/**
	 * バリデーションを行うための抽象クラスのインスタンスを生成する。
	 *
	 * @param value 検証値
	 * @param invalidMessage 不正だった場合のメッセージ
	 */
	protected Validation(T value, String invalidMessage) {
		this.value = value;
		this.invalidMessage = invalidMessage;
	}

	/**
	 * バリデーションを実施し、その結果を返す。
	 *
	 * @return true = 正、false = 不正
	 */
	protected abstract boolean validate();

	/**
	 * @return 検証値
	 */
	protected T getValue() {
		return value;
	}

	/**
	 * @return 不正値だった場合のメッセージ
	 */
	protected String getInvalidMessage() {
		return invalidMessage;
	}
}
