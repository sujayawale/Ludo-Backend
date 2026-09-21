package com.LudoGame.rules;

import org.springframework.stereotype.Component;

import com.LudoGame.enums.TokenState;
import com.LudoGame.model.Cell;
import com.LudoGame.model.Game;
import com.LudoGame.model.Player;
import com.LudoGame.model.Token;

@Component
public class StandardLudoRules implements GameRules{

	private static final int HOME =-1;
	private static final int START=0;
	private static final int FINISH=57;
	
	@Override
	public boolean canMove(Game game, Player player, Token token, int diceValue) {
		if(token.getState()==TokenState.FINISHED) {return false;}
		if(token.getState()==TokenState.HOME) {return diceValue==6;}
		int current =token.getPosition().getValue();
		int newPosition=current+diceValue;
		return newPosition<=FINISH;
	}

	@Override
	public void move(Game game, Player player, Token token, int diceValue) {
		if(!canMove(game, player, token, diceValue)) {
			throw new IllegalStateException("Invalid move");
		}
		if(token.getState()==TokenState.HOME) {
			int boardPosition=player.getPath().getBoardPosition(START);
			token.setPosition(START);
			token.setState(TokenState.ACTIVE);
			game.getBoard().getCell(boardPosition).addToken(token);
			return;
		}
		int current=token.getPosition().getValue();
		int newPosition=current+diceValue;
		
		if(current<52) {
			int oldBoardPosition=player.getPath().getBoardPosition(current);
			game.getBoard().getCell(oldBoardPosition).removeToken(token);
		}
		
		if(newPosition==FINISH) {
			token.setPosition(FINISH);
			token.setState(TokenState.FINISHED);
			return;
		}
		if(newPosition>=52) {
			token.setPosition(newPosition);
			return;
		}
		
		int newBoardPosition=player.getPath().getBoardPosition(newPosition);
		token.setPosition(newBoardPosition);
		game.getBoard().getCell(newBoardPosition).addToken(token);
		
		captureOpponents(game, player, newBoardPosition, token);
		
	}

	private void captureOpponents(Game game, Player player, int newBoardPosition, Token movingToken) {
		Cell cell=game.getBoard().getCell(newBoardPosition);
		
		if(cell.isSafe()) {return;}
		
		for(Token token: cell.getTokens()) {
			if(token==movingToken) {continue;}
			if(token.getColor()!=player.getColor()) {
				token.setPosition(HOME);
				token.setState(TokenState.HOME);
			}
		}
		cell.getTokens().removeIf(token-> token!=movingToken && token.getColor()!=player.getColor());
	}

	@Override
	public boolean hasWon(Player player) {
		return player.getTokens().stream().allMatch(token->token.getState()==TokenState.FINISHED);
	}

	@Override
	public boolean getExtraTurn(int diceValue) {
		return diceValue==6;
	}
}
