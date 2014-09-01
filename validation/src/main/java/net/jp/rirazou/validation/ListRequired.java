package net.jp.rirazou.validation;

import java.util.List;

/**
 * リストの必須チェックをおこなうクラス。<br>
 * 検証値として渡されたリストに対して、nullチェックとサイズの判定を行う。
 *
 * @author Hiroaki Suzuki
 *
 * @param <T> 検証値の型
 */
public class ListRequired<E> extends Validation<List<E>> {

    /**
     * リストの必須チェックを行うインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     */
    protected ListRequired(List<E> value, String invalidMessage) {
        super(value, invalidMessage);
    }

    /**
     * リストの必須チェックを行うインスタンスを生成する。
     *
     * @param value 検証値
     * @param invalidMessage 不正だった場合のメッセージ
     * @return 必須チェックインスタンス
     */
    public static <E> ListRequired<E> listRequired(List<E> value, String invalidMessage) {
        return new ListRequired<E>(value, invalidMessage);
    }

    @Override
    protected boolean validate() {
        return ValidationUtils.isNotEmptyList(getValue());
    }
}
