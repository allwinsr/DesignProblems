package com.allwin.tetrimino.exception;

public class NoSpaceException extends TetriminosException {

	private static final long serialVersionUID = 1L;

	public NoSpaceException() {
		super();
	}

	public NoSpaceException(String errMsg) {
		super(errMsg);
	}

	public NoSpaceException(Throwable throwable) {
		super(throwable);
	}

}
