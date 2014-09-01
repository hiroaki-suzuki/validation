package net.jp.rirazou.validation;

import static net.jp.rirazou.validation.ListRequired.*;
import static net.jp.rirazou.validation.Required.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ValidatorTest {

    @Test
    public void testValid() {
        Validator validator = new Validator() {
            private List<String> getList() {
                List<String> list = new ArrayList<String>();
                list.add("list-A");
                return list;
            }

            @Override
            public void define() {
                add(required("A", ""));
                add(listRequired(getList(), ""));
            }
        };

        assertThat(validator.validate(), is(true));
    }

    @Test
    public void testInvalid() {
        Validator validator = new Validator() {
            @Override
            public void define() {
                add(required("A", "Aが空です"));
                add(listRequired(new ArrayList<String>(), "リストが空です"));
            }
        };

        assertThat(validator.validate(), is(false));
    }
}
