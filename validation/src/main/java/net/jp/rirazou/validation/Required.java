package net.jp.rirazou.validation;

/**
 * 文字列の必須チェックをおこなうクラス。<br>
 * 検証値として渡された文字列に対して、nullチェックと空文字の判定を行う。 空白系の文字列を許可するかどうかを指定することが出来る、デフォルトは空白系の文字列は許可しない設定になっている。
 *
 * @author Hiroaki Suzuki
 *
 * @param <T> 検証値の型
 */
public class Required extends Validation<String> {

    /** 空白関連の文字列を許可するかどうか */
    private boolean allowWhiteSpace;

    /**
     * 必須チェックを行うインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     */
    protected Required(String value, String invalidMessage) {
        this(value, invalidMessage, false);
    }

    /**
     * 必須チェックを行うインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     * @return 必須チェックインスタンス
     */
    public static Required required(String value, String invalidMessage) {
        return new Required(value, invalidMessage);
    }

    /**
     * 必須チェックを行い、その際に空白関連の文字列を許可するかどうかを指定できるインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     * @param allowWhiteSpace 空白関連の文字列を許可するかどうか
     * @return 必須チェックインスタンス
     */
    public static Required required(String value, String invalidMessage, boolean allowWhiteSpace) {
        return new Required(value, invalidMessage, allowWhiteSpace);
    }

    /**
     * 必須チェックを行い、その際に空白関連の文字列を許可するかどうかを指定できるインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     * @param allowWhiteSpace 空白関連の文字列を許可するかどうか
     */
    protected Required(String value, String invalidMessage, boolean allowWhiteSpace) {
        super(value, invalidMessage);
        this.allowWhiteSpace = allowWhiteSpace;
    }

    @Override
    protected boolean validate() {
        if (allowWhiteSpace) {
            return ValidationUtils.isNotEmpty(getValue());
        } else {
            return ValidationUtils.isNotBlank(getValue());
        }
    }
}
