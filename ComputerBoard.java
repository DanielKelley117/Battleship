//My name is Daniel Kelley and this is part of my final project for CS110. It contains the data for a computer's BattleShip board which is a Board.
//I import the necessary classes.
import java.util.ArrayList;
import java.io.*;
public class ComputerBoard extends Board
{
   /*This is the ComputerBoard constructor.
      @Param a String called fileName.
      It calls the super constructor with fileName.
   */
   public ComputerBoard(String fileName) throws IOException
   {
      super(fileName);
   }
   /*This is the makePlayerMove method.
      @Param a Move object called decision.
      @return a String stating that a ship was sunk, or null.
   */
   public String makePlayerMove(Move decision)
   {
      CellStatus carryOut;
      if (this.moveTaken(decision))
      {
         carryOut = this.applyMoveToLayout(decision);
      }
      else
      {
         return "";
      }
      ShipType theShip = null;
      String message = "";
      CellStatus hitType = carryOut;
      if (carryOut == CellStatus.AIRCRAFT_CARRIER)
      {
         theShip = ShipType.ST_AIRCRAFT_CARRIER;
         message = "You sunk my Aircraft Carrier!";
         hitType = CellStatus.AIRCRAFT_CARRIER_HIT;
      }
      else if (carryOut == CellStatus.SUB)
      {
         theShip = ShipType.ST_SUB;
         message = "You sunk my Sub!";
         hitType = CellStatus.SUB_HIT;
      }
      else if (carryOut == CellStatus.BATTLESHIP)
      {
         theShip = ShipType.ST_BATTLESHIP;
         message = "You sunk my BattleShip!";
         hitType = CellStatus.BATTLESHIP_HIT;
      }
      else if (carryOut == CellStatus.CRUISER)
      {
         theShip = ShipType.ST_CRUISER;
         message = "You sunk my Cruiser!";
         hitType = CellStatus.CRUISER_HIT;
      }
      else if (carryOut == CellStatus.DESTROYER)
      {
         theShip = ShipType.ST_DESTROYER;
         message = "You sunk my Destroyer!";
         hitType = CellStatus.DESTROYER_HIT;
      }
      else if (carryOut == CellStatus.NOTHING)
      {
         return "";
      }
      
      Fleet myFleet = this.getFleet();
      boolean sunk = myFleet.updateFleet(theShip);
      
      if (sunk == true)
      {
         this.displaySunk(hitType);
         return message;
      }
      else
      {
         return "";
      }
      
   }
   /*This is the toString method.
      @Param none
      @return a formatted String of the computer's board.
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
            CellStatus cSpot = theList.get(counter1).get(counter2);
            String theDisplay;
            if (cSpot == CellStatus.AIRCRAFT_CARRIER_HIT || cSpot == CellStatus.BATTLESHIP_HIT || cSpot == CellStatus.DESTROYER_HIT || cSpot == CellStatus.CRUISER_HIT || cSpot == CellStatus.SUB_HIT)
            {
               theDisplay = "H";
            }
            else if (cSpot == CellStatus.NOTHING_HIT)
            {
               theDisplay = "x";
            }
            else if (cSpot == CellStatus.AIRCRAFT_CARRIER_SUNK)
            {
               theDisplay = "A";
            }
            else if (cSpot == CellStatus.BATTLESHIP_SUNK)
            {
               theDisplay = "B";
            }
            else if (cSpot == CellStatus.CRUISER_SUNK)
            {
               theDisplay = "C";
            }
            else if (cSpot == CellStatus.DESTROYER_SUNK)
            {
               theDisplay = "D";
            }
            else if (cSpot == CellStatus.SUB_SUNK)
            {
               theDisplay = "S";
            }
            else
            {
               theDisplay = "o";
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
