package net.jp.rirazou.validation;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class RequiredTest {

    @Test
    public void testNull() {
        Required req = Required.required(null, "");
        assertThat(req.validate(), is(false));
    }

    @Test
    public void testEmptyStr() {
        Required req = Required.required("", "");
        assertThat(req.validate(), is(false));
    }

    @Test
    public void testNotEmptyStr() {
        Required req = Required.required("a", "");
        assertThat(req.validate(), is(true));
    }

    @Test
    public void testWhiteSpace() throws Exception {
        Required req1 = Required.required(" ", "");
        assertThat(req1.validate(), is(false));

        Required req2 = Required.required("　", "");
        assertThat(req2.validate(), is(false));

        Required req3 = Required.required("a　a a", "");
        assertThat(req3.validate(), is(true));
    }
}
