//My name is Daniel Kelley and this is part of my final project for CS110. This is the board for the User, which is a Board.

//I import the necessary classes.
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
public class UserBoard extends Board
{
   //I declare the class fields.
   ArrayList<Move> move;
   Random rand;
   /*This is the UserBoard Constructor
      @Param a String fileName
      It initializes the fields and calls the super constructor with fileName
   */
   public UserBoard(String fileName) throws IOException
   {
      super(fileName);
      int counter1 = 1;
      int counter2 = 1;
      move = new ArrayList<Move>(10);
      while (counter1 <= 10)
      {
         counter2 = 1;
         while (counter2 <= 10)
         {
            move.add(new Move(counter1, counter2));
            ++counter2;
         }
         ++counter1;
       }
       rand = new Random();
    }
   /*This is the makeComputerMove method.
      @Param none
      @return a String array containing the move the computer made, and a possible message to the user if any ships were sunk.
   */
   public String[] makeComputerMove()
   {
      
      int index = rand.nextInt(9);
      Move attack = move.get(index);
      move.remove(index);
      CellStatus carryOut;
      String[] outPut = new String[2];
      String strAttack = "" + attack;
      outPut[0] = strAttack;
      outPut[1] = "";
      if (this.moveTaken(attack))
      {
         carryOut = this.applyMoveToLayout(attack);
      }
      else
      {
         return outPut;
      }
      ShipType theShip = null;
      CellStatus hitMark = null;
      if (carryOut == CellStatus.AIRCRAFT_CARRIER)
      {
         outPut[1] = "The computer sunk your AirCraft Carrier!";
         hitMark = CellStatus.AIRCRAFT_CARRIER_HIT;
         theShip = ShipType.ST_AIRCRAFT_CARRIER;
      }
      else if (carryOut == CellStatus.SUB)
      {
         outPut[1] = "The computer sunk your sub!";
         hitMark = CellStatus.SUB_HIT;
         theShip = ShipType.ST_SUB;
      }
      else if (carryOut == CellStatus.BATTLESHIP)
      {
         outPut[1] = "The computer sunk your Battleship!";
         hitMark = CellStatus.BATTLESHIP_HIT;
         theShip = ShipType.ST_BATTLESHIP;
      }
      else if (carryOut == CellStatus.CRUISER)
      {
         outPut[1] = "The computer sunk your Cruiser!";
         hitMark = CellStatus.CRUISER_HIT;
         theShip = ShipType.ST_CRUISER;
      }
      else if (carryOut == CellStatus.DESTROYER)
      {
         outPut[1] = "The computer sunk your Destroyer!";
         hitMark = CellStatus.DESTROYER_HIT;
         theShip = ShipType.ST_DESTROYER;
      }
      else if (carryOut == CellStatus.NOTHING)
      {
         outPut[1] = "";
         return outPut;
      }
      
      Fleet myFleet = this.getFleet();
      boolean sunk = myFleet.updateFleet(theShip);
      
      if (sunk)
      {
         this.displaySunk(hitMark);
         return outPut;
      }
      else
      {
         outPut[1] = "";
         return outPut;
      }
   }
   /*This is the toString method.
      @Param none
      @return a formatted String of the user's board.
   */
   public String toString()
   {
      String theBoard = "     1    2    3    4    5    6    7    8    9    10\n";
      String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
      int counter1 = 0;
      int counter2 = 0;
      ArrayList<ArrayList<CellStatus>> theList = this.getLayout();
      for (counter1 = 0; counter1 < letters.length; counter1++)
      {
         theBoard += letters[counter1];
         for (counter2 = 0; counter2 < letters.length; counter2++)
         {
            String theDisplay;
            CellStatus cSpot = theList.get(counter1).get(counter2);
            CellStatus hitMark;
            if (cSpot == CellStatus.BATTLESHIP)
            {
               theDisplay = "B";
            }
            else if (cSpot == CellStatus.AIRCRAFT_CARRIER)
            {
               theDisplay = "A";
            }
            else if (cSpot == CellStatus.CRUISER)
            {
               theDisplay = "C";
            }
            else if (cSpot == CellStatus.SUB)
            {
               theDisplay = "S";
            }
            else if (cSpot == CellStatus.DESTROYER)
            {
               theDisplay = "D";
            }
            else if (cSpot == CellStatus.NOTHING)
            {
               theDisplay = "o";
            }
            else if (cSpot == CellStatus.NOTHING_HIT)
            {
               theDisplay = "x";
            }
            else if (cSpot == CellStatus.AIRCRAFT_CARRIER_SUNK || cSpot == CellStatus.BATTLESHIP_SUNK || cSpot == CellStatus.CRUISER_SUNK || cSpot == CellStatus.DESTROYER_SUNK || cSpot == CellStatus.SUB_SUNK)
            {
               theDisplay = "X";
            }
            else
            {
               theDisplay = "H";
            }
            theBoard += "    ";
            theBoard += theDisplay;
            
         }
         theBoard += "\n";
      }
      return theBoard;
    }
    /*This is a displaySunk method. It's purpose is to change a ship's status to sunk in the board.
      @Param a CellStatus thing
      @return none
    */
    private void displaySunk(CellStatus thing)
      {
         int counter1;
         int counter2;
         CellStatus c;
         ArrayList<ArrayList<CellStatus>> zeBoard = this.getLayout();
         if (thing == CellStatus.AIRCRAFT_CARRIER_HIT)
         {
            c = CellStatus.AIRCRAFT_CARRIER_SUNK;
         }
         else if (thing == CellStatus.BATTLESHIP_HIT)
         {
            c = CellStatus.BATTLESHIP_SUNK;
         }
         else if (thing == CellStatus.CRUISER_HIT)
         {
            c = CellStatus.CRUISER_SUNK;
         }
         else if (thing == CellStatus.DESTROYER_HIT)
         {
            c = CellStatus.DESTROYER_SUNK;
         }
         else if (thing == CellStatus.SUB_HIT)
         {
            c = CellStatus.SUB_SUNK;
         }
         else
         {
            c = null;
         }
         for (counter1 = 0; counter1 < zeBoard.size(); ++counter1)
         {
            for (counter2 = 0; counter2 < zeBoard.get(counter1).size(); ++counter2)
            {
               if (zeBoard.get(counter1).get(counter2) == thing)
               {
                  zeBoard.get(counter1).set(counter2, c);
               }
            }
         }
      }

   

}

      
