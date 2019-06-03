package com.allwin.tetrimino.model;

import lombok.Getter;

@Getter
public class Size {

	private int M;
	private int N;

	public Size(int m, int n) {
		this.M = m;
		this.N = n;
	}

	public int getM() {
		return M;
	}

	public int getN() {
		return N;
	}
}
