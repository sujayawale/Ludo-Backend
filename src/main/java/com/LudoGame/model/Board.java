package com.LudoGame.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int SIZE=52;
	private final List<Cell>cells=new ArrayList<Cell>();
	public Board() {
		for(int i=0; i<SIZE; i++) {
			cells.add(new Cell(i, isSafeCell(i)));
		}
	}
	private boolean isSafeCell(int index) {
		return index==0 || index==8 || index==13
			|| index==21 || index==26 || index==34
			|| index==39 || index==47;
	}
	public Cell getCell(int index) {
		if(index<0 || index>=SIZE) {
			throw new IllegalArgumentException("Invalid board position");
		}
		return cells.get(index);
	}
	public List<Cell>getCells(){
		return cells;
	}
}
