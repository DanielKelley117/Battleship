//My name is Daniel Kelley and this is part of my CS110 final project. This contain the necessary information for moves.

public class Move
{
   //I declare the class fields.
   private int row;
   private int col;
   /*This is the first class constructor
      @Param two ints, theCol and theRow
      It initializes the fields.
   */
   public Move(int theCol, int theRow)
   {
      row = theRow;
      col = theCol;
   }
   /*This is an alternate constructor
      @Param a String info
      Uses the String to initialize the fields.
   */
   public Move(String info)
   {
      String colStr = "" + info.charAt(1);
      if (info.length() == 3)
      {
         colStr = "" + info.charAt(1) + info.charAt(2);
      }
      row = Integer.parseInt(colStr);
      char c = info.charAt(0);
      if (c == 'A' || c == 'a')
      {
         col = 1;
      }
      else if (c == 'B' || c == 'b')
      {
         col = 2;
      }
      else if (c == 'C' || c == 'c')
      {
         col = 3;
      }
      else if (c == 'D' || c == 'd')
      {
         col = 4;
      }
      else if (c == 'E' || c == 'e')
      {
         col = 5;
      }
      else if (c == 'F' || c == 'f')
      {
         col = 6;
      }
      else if (c == 'G' || c == 'g')
      {
         col = 7;
      }
      else if (c == 'H' || c == 'h')
      {
         col = 8;
      }
      else if (c == 'I' || c == 'i')
      {
         col = 9;
      }
      else if (c == 'J' || c == 'j')
      {
         col = 10;
      }
   
      
   }
   /*This is a getter for the row field
      @Param none
      @return row
   */
   public int row()
   {
      return row;
   }
   /*This is a getter for the col field
      @Param none
      @return col
   */
   public int col()
   {
      return col;
   }
   /*This is the toString method
      @Param none
      @return a formatted String the col and the row variables.
   */
   public String toString()
   {
      String colStr = "";
      if (col == 1)
      {
         colStr = "A";
      }
      else if (col == 2)
      {
         colStr = "B";
      }
      else if (col == 3)
      {
         colStr = "C";
      }
      else if (col == 4)
      {
         colStr = "D";
      }
      else if (col == 5)
      {
         colStr = "E";
      }
      else if (col == 6)
      {
         colStr = "F";
      }
      else if (col == 7)
      {
         colStr = "G";
      }
      else if (col == 8)
      {
         colStr = "H";
      }
      else if (col == 9)
      {
         colStr = "I";
      }
      else if (col == 10)
      {
         colStr = "J";
      }
      
      
      return String.format("%s%d", colStr, row);
   }
   
}
