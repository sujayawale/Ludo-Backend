package com.LudoGame.component;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Dice {
   private final Random random= new Random();
   
   public int roll() {
	   return random.nextInt(6)+1;
   }
}
