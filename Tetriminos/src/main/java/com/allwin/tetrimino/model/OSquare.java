package com.allwin.tetrimino.model;

public class OSquare extends Tetriminos {

	int[][] square2X2 = new int[2][2];

	@Override
	public int[][] getShape() {
		fillRow(square2X2, 0, 2);
		fillRow(square2X2, 1, 2);
		return square2X2;
	}

	@Override
	public String getShapeName() {
		return "2 X 2 Square";
	}

	@Override
	public Size getMatrixSize() {
		return new Size(2, 2);
	}
}
