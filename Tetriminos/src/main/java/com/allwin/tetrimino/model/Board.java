package com.allwin.tetrimino.model;

import com.allwin.tetrimino.action.BoardActions;
import com.allwin.tetrimino.exception.TetriminosException;

import lombok.Getter;

@Getter
public class Board {

	private int rows;
	private int cols;
	private int[][] board;
	private BoardActions actions;

	public Board() {
		this(7, 6);
	}

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new int[rows][cols];
		actions = new BoardActions(this);
		System.out.println("Board Created with size [" + rows + "][" + cols + "]");
	}

	public boolean isBoardFull() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		System.out.println("Board is Full!!!");
		return true;
	}

	public void display() {
		System.out.println("Displaying Board");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("\t" + board[i][j]);
			}
			System.out.println("");
		}
	}

	public void addTetrimino(Position position, Tetriminos tetriminos) {
		try {
			System.out.println("Adding Tetrimino " + tetriminos);
			actions.fill(tetriminos, position);
		} catch (TetriminosException te) {
			System.err.println("Could not fill tetrimino : " + te.getLocalizedMessage());
		} catch (Exception e) {
			// System.err.println("Somethig went wrong : " + e.getLocalizedMessage());
		}

	}

	public void demoTetrimino(Position position, Tetriminos tetriminos) {
		try {
			System.out.println("Going to demo " + tetriminos);
			actions.demoFill(tetriminos, position);
		} catch (TetriminosException te) {
			System.err.println("Could not fill tetrimino : " + te.getLocalizedMessage());
		} catch (Exception e) {
			// System.err.println("Somethig went wrong : " + e.getLocalizedMessage());
		}

	}

	public int[][] getBoard() {
		return board;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public BoardActions getActions() {
		return actions;
	}

	public void setActions(BoardActions actions) {
		this.actions = actions;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

}
