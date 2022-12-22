//My name is Daniel Kelley and this is part of my final project for CS110. This class contains the data for a Fleet object.
public class Fleet
{
   //The class fields are declared.
   private Ship battleShip;
   private Ship sub;
   private Ship destroyer;
   private Ship cruiser;
   private Ship aircraftCarrier;
   /*This is the Fleet constructor.
      It takes in no arguments and initializes all of the fields.
   */
   public Fleet()
   {
      battleShip = new Battleship();
      sub = new Sub();
      destroyer = new Destroyer();
      cruiser = new Cruiser();
      aircraftCarrier = new AircraftCarrier();
   }
   /*This is the updateFleet method. It updates the fleet after a ship is hit.
      @Param a ShipType variable theShip
      @return a boolean value stating whether or not the ship has been sunk.
   */
   public boolean updateFleet(ShipType theShip)
   {
      Ship casualty;
      if (theShip == ShipType.ST_AIRCRAFT_CARRIER)
      {
         aircraftCarrier.hit();
         casualty = aircraftCarrier;
      }
      else if (theShip == ShipType.ST_BATTLESHIP)
      {
         battleShip.hit();
         casualty = battleShip;
      }
      else if (theShip == ShipType.ST_CRUISER)
      {
         cruiser.hit();
         casualty = cruiser;
      }
      else if (theShip == ShipType.ST_SUB)
      {
         sub.hit();
         casualty = sub;
      }
      else
      {
         destroyer.hit();
         casualty = destroyer;
      }
      
      return casualty.getSunk();
   }
   /*This is the gameOver method. It determines if the fleet has been sunk.
      @Param none
      @return a boolean value stating whether or not the entire fleet has been sunk.
   */
   public boolean gameOver()
   {
      if (!(battleShip.getSunk() && cruiser.getSunk() && sub.getSunk() && destroyer.getSunk() && aircraftCarrier.getSunk()))
      {
         return false;
      }
      else
      {
         return true;
      }
   }

}
