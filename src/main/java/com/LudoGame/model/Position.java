package com.LudoGame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {

	private int value;
}

// -1 Home
// 0 Starting cell
//1 51 common board
//52 56 home stretch
//57 Finished
