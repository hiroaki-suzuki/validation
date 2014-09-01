package net.jp.rirazou.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * バリデーションを定義し、実行する抽象クラス。<br>
 * specifyメソッドを実装し、その中でaddメソッドでバリデーションを追加する。<br>
 * validateメソッドで実際のバリデーションを行い、その結果を返す。
 *
 * @author Hiroaki Suzuki
 */
public abstract class Validator {

    private List<Validation<?>> validations;

    private List<String> errors;

    /**
     * バリデーションを定義、実行するインスタンスを生成する。
     */
    public Validator() {
        validations = new ArrayList<Validation<?>>();
        errors = new ArrayList<String>();
    }

    /**
     * バリデーションの定義をおこなう抽象メソッド。
     */
    public abstract void define();

    /**
     * specifyで定義されたバリデーションを実施しその結果を返す。
     *
     * @return trueなら正しい、falseなら不正
     */
    public boolean validate() {
        define();

        for (Validation<?> validation : validations) {
            if (!validation.validate()) {
                errors.add(validation.getInvalidMessage());
            }
        }

        return (errors.size() == 0);
    }

    /**
     * バリデーションを追加する。
     *
     * @param validation バリデーション
     */
    protected <T> void add(Validation<? super T> validation) {
        validations.add(validation);
    }

}
