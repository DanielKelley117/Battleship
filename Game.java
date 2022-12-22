//My name is Daniel Kelley and this is part of my final project for CS110. This class contains the data for a Game object.
//I import the necessary class.
import java.io.*;
public class Game
{
   //I declare the class fields.
   ComputerBoard computer;
   UserBoard player;
   /*This is the Game constructor.
      It takes in no arguments.
      It initializes both of the fields.
   */
   public Game() throws IOException
   {
      computer = new ComputerBoard("CompFleet.txt");
      player = new UserBoard("UserFleet.txt");
   }
   /*This is a makeComputerMove method.
      @Param It takes in no arguments.
      @return It returns the result of the makeComputerMove method from the UserBoard class.
   */
   public String[] makeComputerMove()
   {
      return player.makeComputerMove();
   }
   /*This is a makePlayerMove method.
      @Param it takes in a String called decision.
      @return it returns the result of the makePlayerMove method from the ComputerBoard class.
   */
   public String makePlayerMove(String decision)
   {
      Move attack = new Move(decision);
      return computer.makePlayerMove(attack);
   }
   /*This is the computerDefeated method.
      @Param none
      @return the boolean value from the ComputerBoard gameOver method.
   */
   public boolean computerDefeated()
   {
      return computer.gameOver();
   }
   /*This is the userDefeated method.
      @Param none
      @return the boolean value from the UserBoard gameOver method.
   */
   public boolean userDefeated()
   {
      return player.gameOver();
   }
   /*This is the toString method.
      @Param none
      @return a String theBoards which has both boards in a specific format.
   */
   public String toString()
   {
      String theBoards = "";
      String computerLabel = "COMPUTER\n";
      theBoards += computerLabel;
      theBoards += computer + "\n\n";
      String playerLabel = "USER\n";
      theBoards += playerLabel;
      theBoards += player;
      return theBoards;
   }
   
}
