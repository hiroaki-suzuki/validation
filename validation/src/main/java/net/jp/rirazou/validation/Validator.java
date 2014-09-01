package net.jp.rirazou.validation;

import java.util.ArrayList;
import java.util.List;



public abstract class Validator {

	private List<Validation<?>> validations;

	public Validator() {
		validations = new ArrayList<Validation<?>>();
	}

	public abstract void specify();

	public boolean validate() {
		specify();

		for (Validation<?> validation : validations) {
			if (validation.validate()) {
				return false;
			}
		}

		return true;
	}

	protected <T> void add(Validation<? super T> validation) {
		validations.add(validation);
	}
}
