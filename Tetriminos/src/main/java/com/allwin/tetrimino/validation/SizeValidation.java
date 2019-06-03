package com.allwin.tetrimino.validation;

import com.allwin.tetrimino.action.Actions;
import com.allwin.tetrimino.exception.BoardSizeExceededException;
import com.allwin.tetrimino.exception.NoSpaceException;
import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;

public class SizeValidation extends Validations {

	private Actions action;

	public SizeValidation(Actions action) {
		this.action = action;
	}

	@Override
	public void validate() throws TetriminosException {
		Board board = action.getBoard();

		if (board.getRows() < action.getPosition().getX() || board.getCols() < action.getPosition().getY()) {
			throw new BoardSizeExceededException("Cant Fit this Tetrimino, Board is small");
		}
		if (board.isBoardFull()) {
			throw new NoSpaceException("The board is full");
		}

	}

}
