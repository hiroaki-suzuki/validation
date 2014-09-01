package net.jp.rirazou.validation;

import static net.jp.rirazou.validation.Required.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

    @Test
    public void testInvalid() {
        Validator validator = new Validator() {
            @Override
            public void specify() {
                add(required("A", "Aが空です"));
                add(required("B ", "Bが空です"));
            }
        };

        assertThat(validator.validate(), is(true));
    }

    @Test
    public void testValid() {
        Validator validator = new Validator() {
            @Override
            public void specify() {
                add(required("A", ""));
                add(required(" ", ""));
            }
        };

        assertThat(validator.validate(), is(false));
    }
}
