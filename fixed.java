//Ethan Cha
//AP CS A: Unit 6 ArrayLists – Coding Assignment #5
 
//1. Write a method named removeZeros that is passed an ArrayList parameter named list. The method must remove all values of 0.
import java.util.ArrayList;
import java.util.Arrays;
 
class Main {
 public static void main(String[] args) {
   System.out.println("Test Remove Zeros");
  ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3,4,0,0,1,4,0,6,0));
  System.out.println("Starting List: " + nums);
  removeZeros(nums);
  System.out.println("Expected: [3, 4, 1, 4, 6] \n Actual: " + nums);

  System.out.println();

  ArrayList<String> words = new ArrayList<>(Arrays.asList("this", "is", "a", "list", "of", "words"));
  System.out.println("Test Letter Counter:");
  System.out.println(words);
  System.out.println("Expected: 18 \n Actual: " + countLetters(words));

  System.out.println();

  System.out.println("Test keyPosition: find a 1");
  System.out.println(nums);
  System.out.println("Expected: 2 \n Actual: " + findPosition(1, nums));

  System.out.println();

  System.out.println("Test parse into array");
  System.out.println("Expected: [W, e, s, t, , L, i, n, n] \n Actual: " + parseIntoArrayList("West Linn"));

  System.out.println();

  System.out.println("Test FindMin for Personobjects");
  ArrayList<Person> people = new ArrayList<>(Arrays.asList(new Person(32, "Abe"),
          new Person(14, "Betty"), new Person(18, "Cris")));
  System.out.println(people);
  System.out.println("Expected: BETTY \n Actual: " + findMin(people));

  System.out.println();

  System.out.println("Purse Test:");
  Purse myPurse = new Purse();
  myPurse.add(new Coin(.25, "quarter"));
  myPurse.add(new Coin(.05, "nickel"));
  myPurse.add(new Coin(.01, "penny"));
  myPurse.add(new Coin(.25, "quarter"));

  System.out.println(myPurse);
  System.out.println("# of Quarters = " + myPurse.count(new Coin(.25, "quarter")));
  System.out.println("Smallest Coin = " + myPurse.findSmallest());
  System.out.println("Total of Purse = $" + myPurse.getTotal());
 }
 
 public static void removeZeros(ArrayList<Integer> list){
   for (Integer x : list){
     if (x == 0) list.remove(x);
   }
 }
 
 public static int countLetters(ArrayList<String> list) {
   int len = 0;
   for (String t : list){
     len+=t.length();
   }
   return len;
 }
 
 public static int findPosition (int keyValue, ArrayList<Integer> list){
   for (int i = 0; i<list.size(); i++){
     if (list.get(i)==keyValue) return i;
   }
   return -1;
 }
 
 public static ArrayList<String> parseIntoArrayList (String input){/*returning type String is dumb because output can only be character but i digress*/
   ArrayList<String> out = new ArrayList<String>();
   for (int i = 0; i<input.length(); i++){
     out.add(String.valueOf(input.charAt(i)));
   }
   return out;
 }
 
 public static String findMin (ArrayList<Person> list){
   int low = Integer.MAX_VALUE;
   String name = "";
   for (Person pers : list){
     if (pers.getAge() < low){
       name = pers.getName();
     }
   }
   return name;
 }
}

class Person {
  private int age;
  private String name;

  Person(int a, String b){
    age = a;
    name = b;
  }

  public int getAge(){
    return age;
  }

  public void setAge(int a){
    age = a;
  }

  public String getName(){
    return name;
  }

  public void setName (String a){
    name = a;
  }
}
 
class Coin {
 private double myValue;
 private String myName;
  public Coin(double value, String name) {
 myValue = value;
 myName = name;
 }
  public double getValue() {
 return myValue;
 }
  public String getName() {
 return myName;
 }
  // returns true if this coin is equal to aCoin,
 // which means the name and the value are both equal
 public boolean equals(Coin aCoin) {
 if (aCoin.getValue() == getValue()) return true;
 return false;
 }
} ////////////////////////////////////////////////////////////
// A Purse holds a collection of Coins
class Purse {
 private ArrayList coins;
  public Purse() {
 coins = new ArrayList();
 }
  // adds aCoin to the purse
 public void add(Coin aCoin) {
 coins.add(aCoin);
 }
  // returns total value of all coins in purse
 public double getTotal() {
   double total = 0.0;
   for (Coin c : coins){
     total+=c.getValue();
   }
   return total;
 }
  // returns the number of coins in the Purse that matches aCoin
 // (both myName & myValue)
 public int count(Coin aCoin) {
   int cnt = 0;
   for (Coin c : coins){
     if (c.equals(aCoin)) cnt++;
   }
   return cnt;
 }
  // returns the name of the Coin in the Purse that has the smallest value

  public String findSmallest(){
  Coin cn;
   for (Coin c : coins){
     if (c.getValue()<cn.getValue()) cn = c;
   }
   return cn.getName();
  }
}

