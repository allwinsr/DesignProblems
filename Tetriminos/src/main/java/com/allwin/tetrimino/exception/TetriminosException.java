package com.allwin.tetrimino.exception;

public class TetriminosException extends Exception {

	private static final long serialVersionUID = 1L;

	public TetriminosException() {
		super();
	}

	public TetriminosException(String errMsg) {
		super(errMsg);
	}

	public TetriminosException(Throwable throwable) {
		super(throwable);
	}

}
