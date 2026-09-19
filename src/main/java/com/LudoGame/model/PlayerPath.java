package com.LudoGame.model;

import java.util.ArrayList;
import java.util.List;

import com.LudoGame.enums.Color;

public class PlayerPath {
    private final Color color;
    private final List<Integer> boardPath;
    
    public PlayerPath(Color color) {
    	this.color=color;
    	this.boardPath=createBoardPath(color);
    }

	private List<Integer> createBoardPath(Color color) {
		int start=switch (color) {
		case RED ->0;
		case GREEN -> 13;
		case YELLOW ->26;
		case BLUE ->39;
		};
		List<Integer>path=new ArrayList<Integer>();
		for(int i=0; i<52; i++) {
			path.add((start+i)%52);
		}
		return path;
	}
	public int getBoardPosition(int relavtivePosition) {
		if(relavtivePosition<0 || relavtivePosition>=52) {
			throw new IllegalArgumentException("Position is not on common board");
		}
		return boardPath.get(relavtivePosition);
	}
	
	public Color getColor() {
		return color;
	}
}
