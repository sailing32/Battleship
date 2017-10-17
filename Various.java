import java.util.Scanner;
class Various{
         Various (){}
         //Methode for processing of false inputs
         int processFalseInput (){
             int coordinate;
             do {
                 System.out.print("(whole number in range of 0-9):");
                 Scanner myvar = new Scanner(System.in);
                 coordinate = myvar.nextInt(); 
             } while ( coordinate != 0 && coordinate != 1 && coordinate != 2 && coordinate != 3 && coordinate != 4 && coordinate != 5 && coordinate != 6 && coordinate != 7 && coordinate != 8 && coordinate != 9);
             return coordinate;
         } //Ende Method processFalseInput
}      