class Player {
      //Declaration of matrix marinemap, which tracks the players ships
      private char [][] marinemap = new char [10][10];
      //Declaration of a matrix radarmap, which trackes the shot results
      private char [][] radarmap = new char [10][10];

      //Variables defined here to be accessible for the whole class
      String whoami;
      private int shipcount;
      int dimensions = 10;
      
      Various variousvariable = new Various();

      //Default-constructor
      Player(){}

      //Constructor: One executed
      Player (String whoami, int shipcount){
         //Constructor variables are published to the whole class
         this.shipcount=shipcount;
         this.whoami=whoami;
         int i,j;
         //Fill Maps with dots
         for (i=0;i<dimensions;i++){
            for (j=0;j<dimensions;j++){
                marinemap[i][j] = '.';
                radarmap[i][j] = '.';
            }
         }
       }
       //Distribute ships
       void distributeShips(){
             //Local Variables
             int count=0;
             int x=0;
             int y=0;

             System.out.println (whoami+" Please place your ships!");
             System.out.println (whoami+" You have "+shipcount+" ships left!");

             while (count != shipcount)   {
                    System.out.print("x-Coordinate ");
                    x= variousvariable.processFalseInput();
                    System.out.print("y-Coordinate ");
                    y= variousvariable.processFalseInput();
                    //Place S on locations where ships are
                    marinemap[x][y]='S';
                    count++;
                    System.out.println ("-------------------------------");
             }
        }
        //Shot
        int []shot(){
            int []k=new int[2];
            System.out.println (whoami+" Please shoot!");
            System.out.print("x-Coordinate ");
            k[0]= variousvariable.processFalseInput();
            System.out.print("y-Coordinate ");
            k[1]= variousvariable.processFalseInput();
            return k;
        }
        //marinemap is shown to the player
        void printMarineMap(){
                    int i,j;
                    System.out.println("  0 1 2 3 4 5 6 7 8 9");
                    for (j=0;j<dimensions;j++){
                       for (i=0;i<dimensions;i++){
                           if (i==0) System.out.print(j+" "+marinemap[i][j]+" ");
                           else System.out.print(marinemap[i][j]+" ");
                       }
                       System.out.println();
                  }
        }
        //radarmap is shown to the player
        void printRadarMap(){
                    int i,j;
                    System.out.println("  0 1 2 3 4 5 6 7 8 9");
                    for (j=0;j<dimensions;j++){
                       for (i=0;i<dimensions;i++){
                           if (i==0) System.out.print(j+" "+radarmap[i][j]+" ");
                           else System.out.print(radarmap[i][j]+" ");
                       }
                       System.out.println();
                    }
        }
        //Check if enemy has hit a ship
        int evaluation(int []k){
           if (marinemap[k[0]][k[1]] == 'S'){
               System.out.println ();
               System.out.println ("HIT!"); 
               System.out.println (); 
               return 1;
           } else {
               System.out.println ();
               System.out.println ("Missed!");
               System.out.println ();  
               return 0;
           }
        }
        //If the player hits a ship of the enemy, his private radarmap will show a X
        //if he misses, it shows an ~
        void recordOnRadarMap (int result, int[] k){
               if (result == 1){
                    radarmap[k[0]][k[1]]='X';
               } else{
                    radarmap[k[0]][k[1]]='~';
               }
        }   
}// End Class