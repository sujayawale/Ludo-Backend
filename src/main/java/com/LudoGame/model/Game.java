package com.LudoGame.model;

import java.util.ArrayList;
import java.util.List;

import com.LudoGame.enums.GameState;

public class Game {

	private final Long id;
	private final Board board;
	private final List<Player>players=new ArrayList<Player>();
	private GameState state;
	private int currentPlayerIndex;
	private int diceValue;
	private Long winnerId;
	public Game(Long id) {
		this.id=id;
		this.board=new Board();
		this.state=GameState.WAITING;
		this.currentPlayerIndex=0;
		this.diceValue=0;
	}
	public void addPlayer(Player player) {
        if (players.size() >= 4) {
            throw new IllegalStateException("Maximum 4 players allowed");
        }
        players.add(player);
        if (players.size() >= 2) {
            state = GameState.IN_PROGRESS;
        }
    }
	public Player getCurrentPlayer() {
        if (players.isEmpty()) {
            throw new IllegalStateException("No players in game");
        }
        return players.get(currentPlayerIndex);
    }
	public Long getId() {
		return id;
	}
	public Board getBoard() {
        return board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public GameState getState() {
        return state;
    }
    public void setState(GameState state) {
        this.state = state;
    }
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }
    public int getDiceValue() {
        return diceValue;
    }
    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }
    public Long getWinnerId() {
        return winnerId;
    }
    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }
}
