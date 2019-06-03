package com.allwin.tetrimino.model;

import lombok.Getter;

@Getter
public abstract class Tetriminos {

	public int[][] tetrimino;

	public abstract Size getMatrixSize();

	public abstract int[][] getShape();

	public abstract String getShapeName();

	public void fillRow(int[][] matrix, int row, int pos) {
		for (int i = 0; i < pos; i++) {
			matrix[row][i] = 1;
		}
	}

	public void fillCol(int[][] matrix, int col, int pos) {
		for (int i = 0; i < pos; i++) {
			matrix[i][col] = 1;
		}
	}

	public void print() {
		int[][] shape = getShape();
		int rows = shape.length;
		int cols = shape[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print("\t" + shape[i][j]);
			}
			System.out.println("");
		}
	}

	@Override
	public String toString() {
		return getShapeName();
	}

}
