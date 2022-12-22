public enum ShipType
{
   ST_AIRCRAFT_CARRIER{
   @Override
   public String toString()
   {
      return "Aircraft Carrier";
   }
   },
   ST_BATTLESHIP{
   @Override
   public String toString()
   {
      return "Battleship";
   }
   },
   ST_CRUISER{
   @Override
   public String toString()
   {
      return "Cruiser";
   }
   },
   ST_SUB{
   @Override
   public String toString()
   {
      return "Sub";
   }
   },
   ST_DESTROYER{
   @Override
   public String toString()
   {
      return "Destroyer";
   }
   };
}
