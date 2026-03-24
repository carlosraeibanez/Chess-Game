import gameState.*;
import java.util.Scanner;

/** Main for the Command Line Chess game */
public class main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean gameIsRunning = true;


        while (gameIsRunning == true){
            System.out.println("Hello Welcome to Command Line Chess");
            System.out.println("--Options--");
            System.out.println("1. ) Start Game ");
            System.out.println("2. ) Exit ");
            System.out.print("Please Select a Number : ");
            
            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Exiting.");
                return;
            }
            
            int userSelection = in.nextInt();
            in.nextLine(); // Consume newline

            if (userSelection == 1) {
                System.out.println("Game Starting...");
                gameState.pieceInitialize();
                gameState.boardInitialize();
                
                boolean matchRunning=true;
                while (matchRunning ==true) {
                    gameState.display();
                    System.out.println("\nEnter move (e.g., E2 E4) or 'exit': ");
                    String move = in.nextLine();

                    if (move.equalsIgnoreCase("exit")) {
                        matchRunning = false;
                    } 
                    else if (move.matches("(?i)[A-H][1-8]\\s[A-H][1-8]")) { // Validation 
                        String[] parts = move.split("\\s+");
                        gameState.movePiece(parts[0], parts[1]);
                        System.out.println("Move '" + move + "' received.");
                    } 
                    else {
                        System.out.println("Invalid...Please use [FROM] [TO] formatting");
                    }
                }
            } else if (userSelection == 2) {
                System.out.println("Exiting... Thank You for Playing!");
                gameIsRunning = false;
            } else {
                System.out.println("Invalid... Please Choose Again");
            }

        }
        in.close();
    }
}