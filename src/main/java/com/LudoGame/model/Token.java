package com.LudoGame.model;


import com.LudoGame.enums.Color;
import com.LudoGame.enums.TokenState;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Token {

	private final Long id;
	private final Color color;
	
	@Setter
	private TokenState state=TokenState.HOME;
	
	private Position position=new Position(-1);
	
	public void setPosition(int value) {
		this.position.setValue(value);
	}
}
