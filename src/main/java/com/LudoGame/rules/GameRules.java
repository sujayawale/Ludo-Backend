package com.LudoGame.rules;

import com.LudoGame.model.Game;
import com.LudoGame.model.Player;
import com.LudoGame.model.Token;

public interface GameRules {
   boolean canMove(Game game, Player player, Token token, int diceValue);
   
   void move(Game game, Player player, Token token, int diceValue);
   
   boolean hasWon(Player player);
   
   boolean getExtraTurn(int diceValue);
}
