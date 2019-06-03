package com.allwin.tetrimino.validation;

import com.allwin.tetrimino.action.Actions;
import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.Size;
import com.allwin.tetrimino.model.Tetriminos;

public class InSpaceValidation extends Validations {

	private Actions action;
	private Position position;
	private Tetriminos tetrimino;

	public InSpaceValidation(Actions action, Tetriminos tetrimino) {
		this.action = action;
		this.tetrimino = tetrimino;
		this.position = action.getPosition();
	}

	@Override
	public void validate() throws TetriminosException {
		inSpaceValidation(action.getBoard(), this.tetrimino, position);
	}

	private void inSpaceValidation(Board board, Tetriminos tetrimino, Position position) throws TetriminosException {
		int[][] shape = tetrimino.getShape();
		Size size = tetrimino.getMatrixSize();

		int row = 0;
		boolean isRowFilled = false;
		for (int i = size.getM() - 1; i >= 0; --i) {
			for (int j = size.getN() - 1; j >= 0; --j) {

				int currRow = board.getRows() - position.getX() - row + 1;
				int currJ = position.getY() + j;

				if (currRow == 0) {
					break;
				}

				if (1 == board.getBoard()[currRow][currJ]) {
					isRowFilled = true;
				}
			}
			break;
		}

		if (!isRowFilled) {
			throw new TetriminosException("Cant fill in Space");
		}
	}
}