package com.allwin.tetrimino.exception;

public class PositionAlreadyFilledException extends TetriminosException {

	private static final long serialVersionUID = 1L;

	public PositionAlreadyFilledException() {
		super();
	}

	public PositionAlreadyFilledException(String errMsg) {
		super(errMsg);
	}

	public PositionAlreadyFilledException(Throwable throwable) {
		super(throwable);
	}

}
