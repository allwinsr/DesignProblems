package com.allwin.tetrimino.exception;

public class BoardSizeExceededException extends TetriminosException {

	private static final long serialVersionUID = 1L;

	public BoardSizeExceededException() {
		super();
	}

	public BoardSizeExceededException(String errMsg) {
		super(errMsg);
	}

	public BoardSizeExceededException(Throwable throwable) {
		super(throwable);
	}

}
