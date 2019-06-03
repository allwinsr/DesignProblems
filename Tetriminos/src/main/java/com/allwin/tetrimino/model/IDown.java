package com.allwin.tetrimino.model;

public class IDown extends Tetriminos {

	int[][] horizontal = new int[1][4];

	@Override
	public int[][] getShape() {
		fillRow(horizontal, 0, 4);
		return horizontal;
	}

	@Override
	public String getShapeName() {
		return "Horizontal Line";
	}

	@Override
	public Size getMatrixSize() {
		return new Size(1, 4);
	}
}
