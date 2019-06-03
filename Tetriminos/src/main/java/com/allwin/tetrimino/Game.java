package com.allwin.tetrimino;

import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.IDown;
import com.allwin.tetrimino.model.OSquare;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.TDown;
import com.allwin.tetrimino.model.Tetriminos;

public class Game {

	public static void main(String[] args) throws Exception {
		Game tetriminos = new Game();
		// tetriminos.play();
		tetriminos.play2();
	}

	private void play() {
		Board board = new Board(8, 8);
		board.display();

		Tetriminos line = new IDown();
		line.print();

		Tetriminos square = new OSquare();
		square.print();

		board.addTetrimino(new Position(1, 2), square);
		System.out.println();
		square.print();
/*
		board.addTetrimino(new Position(3, 0), line);
		System.out.println();
		board.display();

		board.addTetrimino(new Position(3, 4), square);
		System.out.println();
		board.display();

		board.addTetrimino(new Position(5, 0), line);
		board.display();

		board.addTetrimino(new Position(5, 4), line);
		board.display();
*/
	}

	private void play1() {
		Board board = new Board(7, 6);
		board.display();

		System.out.println("");
		Tetriminos tDown = new TDown();
		tDown.print();

		System.out.println("");
		Tetriminos line = new IDown();
		line.print();

		board.addTetrimino(new Position(1, 2), line);
		board.addTetrimino(new Position(2, 2), line);
		board.addTetrimino(new Position(3, 0), line);
		board.addTetrimino(new Position(3, 4), line);

		board.addTetrimino(new Position(5, 0), line);
		// board.addTetrimino(new Position(4, 2), line);
		board.display();
		/*
		 * board.addTetrimino(new Position(2, 2), line); // board.addTetrimino(new
		 * Position(4, 2), line);
		 * 
		 * board.addTetrimino(new Position(3, 2), line);
		 * 
		 * 
		 * board.addTetrimino(new Position(4, 2), line); board.display();
		 */
	}

	private void play2() {
		Board board = new Board(7, 6);
		board.display();

		System.out.println("");
		Tetriminos square = new OSquare();
		square.print();
		Tetriminos line = new IDown();
		line.print();

		board.addTetrimino(new Position(1, 0), line);
		board.addTetrimino(new Position(2, 0), line);
		board.addTetrimino(new Position(3, 0), line);
		board.addTetrimino(new Position(1, 4), square);

		board.display();

	}
}
