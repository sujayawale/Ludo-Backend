package com.LudoGame.model;

import java.util.ArrayList;
import java.util.List;

import com.LudoGame.enums.Color;

import lombok.Getter;

@Getter
public class Player {
   private final Long id;
   private final String name;
   private final Color color;
   private final PlayerPath path;
   private final List<Token> tokens=new ArrayList<Token>();
   
   public Player(Long id, String name, Color color) {
	   this.id=id;
	   this.name=name;
	   this.color=color;
	   this.path=new PlayerPath(color);
	   createTokens();
   }

   private void createTokens() {
	for(int i=1; i<=4; i++) {
		long tokenId=id*10+i;
		tokens.add(new Token(tokenId, color));
	}
   }
}
