// Joanne To
// 11/03/2022
// CS&141
// Lab #1: Guessing Game
//
// This program will play a guessing game where the user has to guess the random number that is generated between 1-100.

import java.util.Scanner;
import java.lang.Math;

public class JTGuess2
{
   public static void main(String[] args)
   {
      Scanner intake = new Scanner(System.in);
      //creates new scanner to read user input
      
      introduction();
      //prints the introduction/intructions for the guessing game
      
      int guessCount = playGame();
      int gameCount = 1;
      int bestGame = guessCount;
      int totalGuesses = guessCount;
      int prevGuessCount = guessCount;
      //plays the first game
      //sets some intial values with the results of the first game

      System.out.print("Do you want to play again? ");
      String playAgain = intake.next();
      //asks the user if they want to play again
      //sets the user's answer into a string variable   
            
      while (playAgain.charAt(0) == 'Y' || playAgain.charAt(0) == 'y')
      {
         System.out.printf("%n");
         gameCount++;
         guessCount = playGame();
         totalGuesses = totalGuesses + guessCount;
         if (guessCount > prevGuessCount)
         {
            bestGame = guessCount;
         }//sets the best score to the current score if it is lower then the previous
         prevGuessCount = guessCount;
         System.out.print("Do you want to play again? ");
         playAgain = intake.next();
      }//repeats the game until the user quits out
      //arrGameInfo = [];
      
         System.out.printf("%n%n");
         gameResults(gameCount, bestGame, totalGuesses);
         //prints the final game results and the program ends
   }
   
   
   
   public static void introduction()
   {
      //prints out the introduction/intructions to the guessing game
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.\n\n");
   }
   
   
   
   public static int playGame()
   {
      //plays one game with the user
      Scanner input = new Scanner (System.in);
      
      int min = 1;
      int max = 100;
      //sets the constants for the range of the game answer
      int guess = 0;
      int guessCount = 0;
      //sets some varaibles to manipulate later
      int answer = (int)(Math.random() * (max-min + 1) + min);
      //creates a random integer for the answer
      
      System.out.println("I'm thinking of a number between 1 and 100...");
      
      while (guess != answer)
      {
         //asks the user for their guess
         //adds to guessCount for each guess
         //prints whether their guess is higher or lower than the answer when the guess is not correct
         System.out.print("Your guess? ");
         guess = input.nextInt();
         guessCount++;
         if (guess > answer)
         {
            System.out.println("It's lower.");
         }
         if (guess < answer)
         {
            System.out.println("It's higher.");
         } 
      }//repeats until the user's guess is correct/the same as the answer
      
      if (guessCount != 1)
      {
         System.out.printf("You got it right in %d guesses%n", guessCount);
      }//prints the pural version of guess if it took mulitple guesses
      else
      {
         System.out.printf("You got it right in %d guess%n", guessCount);
      }//prints the singular version of guess if it took one guess
      
      return guessCount;
   }
   
   
   
   public static void gameResults(int gameCount, int bestGame, int totalGuesses)
   {
      //prints the overall results of the games
      
      double guessPerGame = (double)totalGuesses / (double)gameCount;
      //calculates the average guesses it took for the user to get ir right across their games
      System.out.printf("Overall results: %n");
      System.out.printf("\t total games: %d%n", gameCount);
      System.out.printf("\t total guesses: %d%n", totalGuesses);
      System.out.printf("\t guesses/game: %.2f%n", guessPerGame);
      System.out.printf("\t best game: %d", bestGame);
   }
}