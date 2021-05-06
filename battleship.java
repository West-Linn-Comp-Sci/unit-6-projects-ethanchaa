/*battle ship program, this program lets you play battle ship against yourself
have not implemented players choosing their own boat position and have not implemented
custom board size, ETHAN CHA 5/6/21*/

//if you want to create your own ships via hardcode use the pilcolReturn function
//(its a static method of the Ship class)

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Vector2 {
  public int X;
  public int Y;
  public Vector2 (int x, int y){
   X = x;
   Y = y;
  }

  public boolean equals (Vector2 tryVec){
    if (tryVec.X == X && tryVec.Y == Y) return true;
    return false;
  }
}

class Ship {
  private List<Vector2> shipBounds;
  private int parts;
  
  public Ship (List<Vector2> input){
    shipBounds = input;
    parts = input.size();
  }

  public boolean isHit (Vector2 tryPoint){
    for (Vector2 bound :shipBounds){
      if (tryPoint.equals(bound)) {
        shipBounds.remove(bound);
        parts--;
        return true;
      }
    }
    return false;
  }

  public boolean isAlive (){
    if (parts <= 0) return false;
    return true;
  }
  //i made this so that ship creation is easier (it was painful without it)
  public static List<Vector2> pilcolReturn (Vector2 position, int length, int dir){
    List<Vector2> returnList = new ArrayList<Vector2>();
    for (int i = 0; i<length; i++){
      switch (dir){
        case 1:
          returnList.add(new Vector2(position.X+i, position.Y));
          break;
        case 2:
          returnList.add(new Vector2(position.X-i, position.Y));
          break;
        case 3:
          returnList.add(new Vector2(position.X, position.Y+i));
          break;
        case 4:
          returnList.add(new Vector2(position.X, position.Y-i));
          break;
        default:
          System.out.println("something went wrong");
          break;
      }
    }
    return returnList;
  }
}

class Player {
  private List<Ship> ships;

  public Player (List<Ship> startingShips){
    ships = startingShips;
  }

  public boolean testHit (Vector2 hit){
    for (Ship xd:ships){
      if (xd.isHit(hit)){
        System.out.println("Ship hit!");
        if (!xd.isAlive()){ships.remove(xd); System.out.println("Ship killed!");} 
        return true;
      }
    }
    System.out.println("Miss!");
    return false;
  }

  public boolean outOfShips (){
    if (ships.size() == 0)return true;
    return false;
  }

  public int shipsLeft (){
    return ships.size();
  }
}

class Main {
  public static void main(String[] args) {
    //will implement player boat placement later (to lazy rn)
    Scanner scannerObj = new Scanner(System.in);
    String userIn;
    Vector2 boardSize = new Vector2(1,7);
    List<Vector2> testShip1 = Ship.pilcolReturn(new Vector2(1,1), 2, 3); //new ship that starts at position 1-1, is 2 points long and faces towards y++
    List<Vector2> testShip2 = Ship.pilcolReturn(new Vector2(1,4), 2, 3);//new ship that starts at position 1-4, is 2 points long and faces towards y++


    List<Ship> player1Ships =  new ArrayList<Ship>();//test players!
    player1Ships.add(new Ship(testShip1));//add the test ships!
    player1Ships.add(new Ship(testShip2));
    Player plr1 = new Player(player1Ships);

    List<Ship> player2Ships =  new ArrayList<Ship>();
    //player2Ships.add(new Ship(testShip1));
    player2Ships.add(new Ship(testShip2));
    Player plr2 = new Player(player2Ships);
    //Next few ships declared are for testing purposes! the implementation will be shabby at best... (plus 1 by 7 board size does not allow for many ships)

    boolean gameOver = false;
    boolean turn = true;
    while (!gameOver){
      System.out.println("----------------------");
      if (turn){
        //plr1 turn
        System.out.println("(Player 1's turn) You have " + plr1.shipsLeft() + " ships left");
        System.out.println("Enter where you would like to attack. exmpl: 1,1");
        userIn = scannerObj.nextLine();
        int x;
        int y;
        if (userIn.charAt(1) == ','){
          x = Character.getNumericValue(userIn.charAt(0));
          y = Character.getNumericValue(userIn.charAt(2));

          plr2.testHit(new Vector2(x,y));
          turn = !turn;
        }else{
          System.out.println("invalid input");
        }
      }else{  
        //plr2 turn
        System.out.println("(Player 2's turn) You have " + plr2.shipsLeft() + " ships left");
        System.out.println("Enter where you would like to attack. exmpl: 1,1");
        userIn = scannerObj.nextLine();
        int x;
        int y;
        if (userIn.charAt(1) == ','){
          x = Character.getNumericValue(userIn.charAt(0));
          y = Character.getNumericValue(userIn.charAt(2));

          plr1.testHit(new Vector2(x,y));
          turn = !turn;
        }else{
          System.out.println("invalid input");
        }
      }
      
      if (plr1.outOfShips()){
        System.out.println("----------------------");
        gameOver = true;
        System.out.println("Player 2 won");
        //plr 2 won
      }else if (plr2.outOfShips()){
        System.out.println("----------------------");
        gameOver = true;
        System.out.println("Player 1 won");
        //plr 1 won
      }
    }
  }
}
