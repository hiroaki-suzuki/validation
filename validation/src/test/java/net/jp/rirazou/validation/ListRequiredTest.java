package net.jp.rirazou.validation;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListRequiredTest {

    @Test
    public void testNull() {
        ListRequired<String> sut = new ListRequired<String>(null, "");
        assertThat(sut.validate(), is(false));
    }

    @Test
    public void testEmptyList() {
        ListRequired<String> sut = new ListRequired<String>(new ArrayList<String>(), "");
        assertThat(sut.validate(), is(false));
    }

    @Test
    public void testNotEmptyList() {
        List<String> list = new ArrayList<String>();
        list.add("list");

        ListRequired<String> sut = new ListRequired<String>(list, "");
        assertThat(sut.validate(), is(true));
    }


}
