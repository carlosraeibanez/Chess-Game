import gameState.*;
import java.util.Scanner;

/**
 * Main entry point for the Command Line Chess game. [cite: 95]
 */
public class main {
    public static void main(String args[]) {
        System.out.println("Hello Welcome to Command Line Chess");
        System.out.println("--Options--");
        System.out.println("1. ) Start Game ");
        System.out.println("2. ) Exit ");

        Scanner in = new Scanner(System.in);
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
            
            boolean gameRunning = true;
            while (gameRunning) {
                gameState.display();
                System.out.println("\nEnter move (e.g., E2 E4) or 'exit': ");
                String move = in.nextLine();

                if (move.equalsIgnoreCase("exit")) {
                    gameRunning = false;
                } else if (move.matches("(?i)[A-H][1-8]\\s[A-H][1-8]")) { // Validation 
                    System.out.println("Move '" + move + "' received. (Full logic in Phase 2).");
                } else {
                    System.out.println("Invalid format! Please use [FROM] [TO] (e.g., A2 A4)."); [cite: 47, 112]
                }
            }
        } else if (userSelection == 2) {
            System.out.println("Exiting Now, Thank You for Playing!");
        } else {
            System.out.println("Invalid Selection Please Choose Again");
        }
        in.close();
    }
}