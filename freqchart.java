//Program by ethan cha Apr 28th
/* this program reads in some numbers
then prints out a chart graphing where the numbers are on a table*/
 
import java.util.Scanner;
class Main {
public static void main(String[] args) {
  int maxEntries = 100;//How many entries should user be able to enter?
  String singles  = "";//Keeping track of how many numbers there are in each category.
  String tens = "";
  String twenties ="";
  String thirties = "";
  String forties = "";
  String fifties = "";
  String sixties = "";
  String seventies = "";
  String eighties = "";
  String nineties = "";
  int[] inputInts = new int[maxEntries];//Declare array of size maxEntries
  for (int i=0; i<inputInts.length; i++){//loop for each entry spot
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter a number between 1 and 100 (inclusive) or enter 'done' to continue.");//prompt
    String userIn = myObj.nextLine();//read in
    System.out.println("Given input was :"+userIn+".");//affirm
    if (userIn.equals("done")){break;}//exit if the user wants to quit
    else{
     int input = Integer.valueOf(userIn);//to number then read and keep track of the added numbers
 
     if (input >=1 && input <= 100){
     inputInts[i]=input;
     if(input>=1&&input<=10)
         singles+="*";
     if(input>=11&&input<=20)
         tens+="*";
     if(input>=21&&input<=30)
               twenties+="*";
     if(input>=31&&input<=40)
               thirties+="*";
     if(input>=41&&input<=50)
               forties+="*";
     if(input>=51&&input<=60)
               fifties+="*";
     if(input>=61&&input<=70)
               sixties+="*";
     if(input>=71&&input<=80)
               seventies+="*";
     if(input>=81&&input<=90)
               eighties+="*";
     if(input>=91&&input<=100)
               nineties+="*";
     if(input>=1&&input<=10)
               singles+="*";
     if(input>=1&&input<=10)
               singles+="*";
     }
   }
  }
  System.out.println(" 1 - 10 |"+singles);//print everything out in format
  System.out.println("11 - 20 |"+tens);
  System.out.println("21 - 30 |"+twenties);
  System.out.println("31 - 40 |"+thirties);
  System.out.println("41 - 50 |"+forties);
  System.out.println("51 - 60 |"+fifties);
  System.out.println("61 - 70 |"+sixties);
  System.out.println("71 - 80 |"+seventies);
  System.out.println("81 - 90 |"+eighties);
  System.out.println("91 - 100|"+nineties);
 }
}
