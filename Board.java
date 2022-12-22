//My name is Daniel Kelley and this is part of my CS110 final project. This contains the necessary information for a BattleShip board.
//I import the necessary classes.
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Board
{
   //I declare the class fields.
   public final int SIZE = 10;
   private ArrayList<ArrayList<CellStatus>> layout = new ArrayList(SIZE);
   private Fleet fleet;
   /*This is the Board constructor.
     @Param a String fileName.
      It opens a file and uses it to create the board.
   */
   public Board(String fileName) throws IOException
   {
      File file = new File(fileName);
      Scanner inputFile = new Scanner(file);
      int counter1 = 0;
      int counter2;
      CellStatus nothing = CellStatus.NOTHING;
      CellStatus battleShip = CellStatus.BATTLESHIP;
      CellStatus aircraftCarrier = CellStatus.AIRCRAFT_CARRIER;
      CellStatus cruiser = CellStatus.CRUISER;
      CellStatus destroyer = CellStatus.DESTROYER;
      CellStatus sub = CellStatus.SUB;
      ArrayList<CellStatus> rowList;
      for (int creator = 0; creator < 10; creator++)
      {
         rowList = new ArrayList<CellStatus>();
         for (int creator2 = 0; creator2 < 10; creator2++)
         {
            rowList.add(creator2, nothing);
            layout.add(creator, rowList);
         }
      }
      while (inputFile.hasNext())
      {
         String line = inputFile.nextLine();
         String type = "" + line.charAt(0);
         CellStatus c;
         if (type.equals("D"))
         {
            c = destroyer;
         }
         else if (type.equals("A"))
         {
            c = aircraftCarrier;
         }
         else if (type.equals("B"))
         {
            c = battleShip;
         }
         else if (type.equals("C"))
         {
            c = cruiser;
         }
         else
         {
            c = sub;
         }
         int room = line.length();
         String place = "" + line.charAt(2) + line.charAt(3);
         Move locationHolder = new Move(place);
         String end;
         if (room == 7)
         {
            end = "" + line.charAt(5) + line.charAt(6);
         }
         else
         {
            end = "" + line.charAt(5) + line.charAt(6) + line.charAt(7);
         }
         Move endHolder = new Move(end);
         int colEnd = endHolder.col();
         int rowEnd = endHolder.row();
         int colStart = locationHolder.col();
         int rowStart = locationHolder.row();
         layout.get(colStart-1).set(rowStart-1, c);
         if (rowEnd > rowStart && !(colEnd > colStart))
         {
            int difference = rowEnd - rowStart;
            for (int adder = rowStart; adder < rowEnd-1; ++adder)
            {
               layout.get(colStart-1).set(adder, c);
            }
            layout.get(colStart-1).set(rowEnd-1, c);
         }
         else if (colEnd > colStart && !(rowEnd > rowStart))
         {
            int difference = colEnd - colStart;
            for (int adder = colStart; adder < colEnd-1; ++adder)
            {
               layout.get(adder).set(rowStart-1, c);
            }
            layout.get(colEnd-1).set(rowStart-1, c);
         }
        
       }
      fleet = new Fleet();

     }
      /*This is the applyMoveToLayout method. It processed a move's impact on the board.
         @Param a Move attack
         @return the CellStatus of what was just attacked.
      */
      public CellStatus applyMoveToLayout(Move attack)
      {
         int attackRow = attack.row()-1;
         int attackCol = attack.col()-1;
         
         CellStatus square = layout.get(attackCol).get(attackRow);
         if (square == CellStatus.NOTHING)
         {
            CellStatus c = CellStatus.NOTHING_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         else if (square == CellStatus.SUB)
         {
            CellStatus c = CellStatus.SUB_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         else if (square == CellStatus.DESTROYER)
         {
            CellStatus c = CellStatus.DESTROYER_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         else if (square == CellStatus.AIRCRAFT_CARRIER)
         {
            CellStatus c = CellStatus.AIRCRAFT_CARRIER_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         else if (square == CellStatus.CRUISER)
         {
            CellStatus c = CellStatus.CRUISER_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         else if (square == CellStatus.BATTLESHIP)
         {
            CellStatus c = CellStatus.BATTLESHIP_HIT;
            layout.get(attackCol).set(attackRow, c);
         }
         return square;
      }
      /*This is the moveTaken method. It sees if a certain move is available.
         @Param a Move attack
         @return a boolean value stating whether or not the move is available.
      */
      public boolean moveTaken(Move attack)
      {
         int attackRow = attack.row()-1;
         int attackCol = attack.col()-1;
         CellStatus square = layout.get(attackCol).get(attackRow);
         if (square == CellStatus.BATTLESHIP_HIT || square == CellStatus.CRUISER_HIT || square == CellStatus.AIRCRAFT_CARRIER_HIT || square == CellStatus.DESTROYER_HIT || square == CellStatus.SUB_HIT || square == CellStatus.NOTHING_HIT)
         {
            return false;
         }
         else
         {
            return true;
         }
      }
      /*This si the getLayout method.
         @Param none
         @return the layout field.
      */
      public ArrayList<ArrayList<CellStatus>> getLayout()
      {
         return layout;
      }
      /*This is the getFleet method
         @Param none
         @return the fleet field.
      */
      public Fleet getFleet()
      {
         return fleet;
      }
      /*This is the gameOver method
         @Param none
         @return the boolean value of fleet's gameOver method.
      */
      public boolean gameOver()
      {
         return fleet.gameOver();
      }
      


}
