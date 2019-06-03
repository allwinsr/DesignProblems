package com.allwin.tetrimino.validation;

import java.util.ArrayList;
import java.util.List;

import com.allwin.tetrimino.exception.TetriminosException;

public class Validations {

	protected List<Validations> allValidations = new ArrayList<>();

	public void addValidations(Validations v) {
		allValidations.add(v);
	}

	public void validate() throws TetriminosException {
		for (Validations validation : allValidations) {
			validation.validate();
		}
	}

}
