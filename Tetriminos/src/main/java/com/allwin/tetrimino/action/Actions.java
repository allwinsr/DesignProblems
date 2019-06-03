package com.allwin.tetrimino.action;

import com.allwin.tetrimino.exception.TetriminosException;
import com.allwin.tetrimino.model.Board;
import com.allwin.tetrimino.model.Position;
import com.allwin.tetrimino.model.Tetriminos;

public interface Actions {

	public Board getBoard();
	
	public Position getPosition();

	void fill(Tetriminos tetriminos, Position position) throws TetriminosException;

	void validate(Tetriminos tetriminos) throws TetriminosException;

}
