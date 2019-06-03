package com.allwin.tetrimino.action;

import com.allwin.tetrimino.exception.PositionAlreadyFilledException;
import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.Size;
import com.allwin.tetrimino.model.Tetriminos;
import com.allwin.tetrimino.validation.Validations;

public class ShadowFillValidation extends Validations implements Cloneable {

	private Actions action;
	private Tetriminos tetrimino;
	private Board board;
	private Position position;

	public ShadowFillValidation(Actions action, Tetriminos tetriminos, Position position) {
		this.action = action;
		this.tetrimino = tetriminos;
		this.board = action.getBoard();
		this.position = position;
	}

	@Override
	public void validate() throws TetriminosException {
		int[][] copyBoard = board.getBoard();
		shadowFill(tetrimino, copyBoard);
	}

	public void displayShadow() {

		int[][] cloned = clone(board.getBoard());
		try {
			shadowFill(tetrimino, cloned);
			System.out.println("Displaying Demo Board");
			print(cloned);
		} catch (Exception e) {
			System.err.println("Can't have this tetrimino at this location");
		}

	}

	public void print(int[][] board) {
		System.out.println("Displaying Board");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print("\t" + board[i][j]);
			}
			System.out.println("");
		}
	}

	private void shadowFill(Tetriminos tetrimino, int[][] copyBoard) throws PositionAlreadyFilledException {
		Size size = tetrimino.getMatrixSize();
		int[][] shape = tetrimino.getShape();

		int row = 0;
		for (int i = size.getM() - 1; i >= 0; --i) {
			for (int j = size.getN() - 1; j >= 0; --j) {
				if (copyBoard[board.getRows() - position.getX() - row][position.getY() + j] == 1) {
					throw new PositionAlreadyFilledException(
							"Can't occupy this position because this position already occupied");
				}
				copyBoard[board.getRows() - position.getX() - row][position.getY() + j] = shape[i][j];
			}
			row++;
		}
	}

	private int[][] clone(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				newBoard[i][j] = board[i][j];

		return newBoard;
	}

}
