import java.util.Scanner;

class Battleship{
  public static void main(String args[]) { 
      //Parts of the Ships
      int shipnumber=0;
      int shotresult=0;
      int hitcount1=0;
      int hitcount2=0;
      int []coordinates =new int[2];
   
      System.out.println ("Game Start!");
      System.out.println ("-------------------------------");

      //How many ships
      System.out.print ("With how many ships do you want to play with? ");
      Scanner sc = new Scanner(System.in);
      shipnumber = sc.nextInt();

      System.out.println ("The playingfield is 10x10 and includes "+shipnumber+" ships."); 

      //2 Players are created
      Player player1 = new Player("Spieler1", shipnumber);
      Player player2 = new Player("Spieler2", shipnumber);

      //Both players distribute their ships
      player1.distributeShips();
      player2.distributeShips();
      
      System.out.println ("Your marine charts:");
      player1.printMarineMap();
      player2.printMarineMap();

      System.out.println ("Your Radars:");
      player1.printRadarMap();
      player2.printRadarMap();
      
      //Gamestart
      //The game is played till all ships of one player are destroyed
      while (hitcount1 != shipnumber && hitcount2 != shipnumber) {

           //Player 1 shoots first
           coordinates=player1.shot();
           shotresult=player2.evaluation(coordinates);
           hitcount1=hitcount1+shotresult;
           player1.recordOnRadarMap(shotresult,coordinates);
           player1.printRadarMap();

           //Player 2 shoots second
           coordinates=player2.shot();
           shotresult=player1.evaluation(coordinates);
           hitcount2=hitcount2+shotresult;
           player2.recordOnRadarMap(shotresult,coordinates);
           player2.printRadarMap();           
      }// Ende while

      //The game ends if all ships of one player are destroyed
      //Check if all ships are destroyed
      if (hitcount1 == shipnumber){
           System.out.println ("*****************************");
           System.out.println ("  Player 1 wins!");
           System.out.println ("*****************************");
      } else {
           System.out.println ("*****************************");
           System.out.println ("  Player 2 wins!");
           System.out.println ("*****************************");
      }
   }//Ende Battleship
}// Ende Class
