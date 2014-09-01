package net.jp.rirazou.validation;

import java.util.List;

/**
 * バリデーションパッケージのユーティリティクラス。
 *
 * @author Hiroaki Suzuki
 */
public class ValidationUtils {

    /**
     * 文字列がnullか空文字かを判定する。<br>
     *
     * @param cs 判定対象の文字列
     * @return 文字列がnull、または空文字ならtrue
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 文字列がnullか空文字かを判定する。<br>
     *
     * @param cs 判定対象の文字列
     * @return 文字列がnull、または空文字でなければtrue
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !ValidationUtils.isEmpty(cs);
    }

    /**
     * 文字列がnullか空文字かを判定する。<br>
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
     * 文字列がnullか空文字かを判定する。<br>
     * Character.isWhitespaceでの空白判定も行う。
     *
     * @param cs 判定対象の文字列
     * @return 文字列がnull、または空文字でなければtrue
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !ValidationUtils.isBlank(cs);
    }

    /**
     * リストがnullか空かを判定する。
     *
     * @param list 判定対象のリスト
     * @return リストがnullか空ならtrue
     */
    public static <T> boolean isEmptyList(List<T> list) {
        return (list == null || list.size() == 0);
    }

    /**
     * リストがnullか空かを判定する。
     *
     * @param list 判定対象のリスト
     * @return リストがnullか空でなければtrue
     */
    public static <T> boolean isNotEmptyList(List<T> list) {
        return !ValidationUtils.isEmptyList(list);
    }
}
