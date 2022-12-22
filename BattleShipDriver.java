//My name is Daniel Kelley and this is part of my CS110 final project. It is the Driver for all of the BattleShip files.

//I import the necessary classes.
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class BattleShipDriver
{
   public static void main(String[] args) throws IOException
   {
      //I make a Game object called battleShip and conduct a coin toss to see who goes first.
      Game battleShip = new Game();
      Random rand = new Random();
      int starter = rand.nextInt(100);
      int choice = rand.nextInt(100);
      int coin;
      if (choice < starter)
      {
         System.out.println("You won the coin toss!");
         coin = 1;
      }
      else
      {
         System.out.println("You lost the coin toss");
         coin = -1;
      }
      System.out.println("\nThe game will begin!");
      System.out.println(battleShip);
      //This while loop will keep the game going while the user and the computer have both not been defeated.
      while (!(battleShip.computerDefeated()) && !(battleShip.userDefeated()))
      {
        try
        {
         //If it is the users turn, determined by coin, the player will be allowed to make a move, and will be told if they sunk one of the computer's ships.
         if (coin == 1)
         {
            System.out.print("Your turn: ");
            Scanner keyboard2 = new Scanner(System.in);
            String decision = keyboard2.nextLine();
            String theDisplay = battleShip.makePlayerMove(decision);
            if (!(theDisplay.equals("")))
            {
               System.out.println("Computer says: " + theDisplay);
            }
            System.out.println(battleShip);
         }
         //If it is the computer's turn, the computer will make a move against the player.
         else if (coin == -1)
         {
            System.out.print("Computer's turn: press any key to continue");
            Scanner keyboard3 = new Scanner(System.in);
            String empty = keyboard3.nextLine();
            String[] computerMove = battleShip.makeComputerMove();
            System.out.println("\nComputer chose: "+computerMove[0]);
            if (!(computerMove[1].equals("")))
            {
               System.out.println(computerMove[1]);
            }
            System.out.println(battleShip);
         }
         //The coin variable is alternated between 1 and -1 at the end of each loop iteration to determine who's turn it is.
         coin = coin * -1;
      }
      
      catch (Exception except)
      {
         System.out.println("Please try again and submit a valid input.");
      }
      }
      
      //If the computer was defeated, the user is congratulated.
      if (battleShip.computerDefeated())
      {
         System.out.println("Great job! You won!");
      }
      //If the player is defeated, they are told so.
      else if (battleShip.userDefeated())
      {
         System.out.println("Sorry. The computer won. Better luck next time.");
      }
   }
}
