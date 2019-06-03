package com.allwin.tetrimino.action;

import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.Size;
import com.allwin.tetrimino.model.Tetriminos;
import com.allwin.tetrimino.validation.InSpaceValidation;
import com.allwin.tetrimino.validation.SizeValidation;
import com.allwin.tetrimino.validation.Validations;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardActions implements Actions {

	private Board board;
	private Position positionToFill;

	public BoardActions(Board board) {
		this.board = board;
	}

	@Override
	public void validate(Tetriminos tetriminos) throws TetriminosException {
		Validations validation = new Validations();

		validation.addValidations(new SizeValidation(this));
		validation.addValidations(new ShadowFillValidation(this, tetriminos, positionToFill));
		//validation.addValidations(new InSpaceValidation(this, tetriminos));
		// TODO : Add More validations

		validation.validate();
	}

	@Override
	public void fill(Tetriminos tetriminos, Position position) throws TetriminosException {
		positionToFill = position;
		validate(tetriminos);

		fillFromBottom(tetriminos, position, false);
		isAnyRowCompleted();
	}

	public void demoFill(Tetriminos tetriminos, Position position) throws TetriminosException {
		ShadowFillValidation shadow = new ShadowFillValidation(this, tetriminos, position);
		shadow.displayShadow();
	}

	private void fillFromBottom(Tetriminos tetrimino, Position position, boolean isRefill) {
		int[][] shape = tetrimino.getShape();
		Size size = tetrimino.getMatrixSize();

		int row = 0;
		for (int i = size.getM() - 1; i >= 0; --i) {
			for (int j = size.getN() - 1; j >= 0; --j) {
				board.getBoard()[board.getRows() - position.getX() - row][position.getY() + j] = isRefill ? 0
						: shape[i][j];
			}
			row++;
		}
	}

	private void isAnyRowCompleted() {
		for (int i = 0; i < board.getRows(); i++) {
			boolean isRowFilled = true;
			for (int j = 0; j < board.getCols(); j++) {
				if (board.getBoard()[i][j] != 1) {
					isRowFilled = false;
					break;
				}
			}
			if (isRowFilled) {
				System.out.println("One full row filled" + (i + 1));
				board.display();
				fillTheRowWith(i, 0);
				bringAllRowsDownByOneRow(i);
			}
		}

	}

	private void bringAllRowsDownByOneRow(int row) {

		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j < board.getCols(); j++) {
				board.getBoard()[i + 1][j] = board.getBoard()[i][j];
			}
		}
	}

	private void fillTheRowWith(int row, int value) {
		for (int i = 0; i < board.getCols(); i++) {
			board.getBoard()[row][i] = value;
		}
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public Position getPosition() {
		return positionToFill;
	}

}
