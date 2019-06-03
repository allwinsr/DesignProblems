package com.allwin.tetrimino;

import org.junit.Test;

import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.IDown;
import com.allwin.tetrimino.model.OSquare;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.Tetriminos;

import junit.framework.TestCase;

public class MainApplicationTest extends TestCase {

	@Test
	public void playGame() {
		play();
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

	}
}
