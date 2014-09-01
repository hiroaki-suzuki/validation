package net.jp.rirazou.validation;

import static net.jp.rirazou.validation.Required.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.jp.rirazou.validation.Validator;

import org.junit.Test;
public class ValidatorTest {

	@Test
	public void testRequired() {
		Validator validator = new Validator() {

			@Override
			public void specify() {
				add(required("a", "Aが空です"));
				add(required(null, "Bが空です"));
			}
		};

		assertThat(validator.validate(), is(true));
	}
}
