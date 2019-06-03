package com.allwin.tetrimino.model;

public class TDown extends Tetriminos {

	int[][] horizontal = new int[2][3];

	@Override
	public int[][] getShape() {
		fillRow(horizontal, 1, 3);
		horizontal[0][1] = 1;
		return horizontal;
	}

	@Override
	public String getShapeName() {
		return "T Down";
	}

	@Override
	public Size getMatrixSize() {
		return new Size(2, 3);
	}
}
