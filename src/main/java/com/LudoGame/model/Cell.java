package com.LudoGame.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cell {

	private final int index;
	private final boolean safe;
	private final List<Token> tokens=new ArrayList<Token>();
	public void addToken(Token token) {
		tokens.add(token);
	}
	public void removeToken(Token token) {
		tokens.remove(token);
	}
}
