import pieces.*;
import gameState.*;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        System.out.println("Hello Welcome to Command Line Chess");
        System.out.println("--Options--");
        System.out.println("1. ) Start Game ");
        System.out.println("2. ) Exit ");

        Scanner in = new Scanner(System.in);
        System.out.println("Please Select a Number : ");
        int userSelection = in.nextInt();

        if(userSelection == 1){
            System.out.println("Game Starting...");
        }
        else if (userSelection == 2) {

            System.out.println("Exiting Now, Thank You for Playing!");
        }
        else {
            System.out.println("Invalid Selection Please Choose Again");
        }











    }
}
