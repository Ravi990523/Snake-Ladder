import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder {
    static HashMap<Integer, Integer> snakes = new HashMap<>();
    static HashMap<Integer, Integer> ladders = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Define Snakes (bite down)
        snakes.put(99, 10);
        snakes.put(95, 20);
        snakes.put(80, 45);
        snakes.put(50, 5);

        // Define Ladders (climb up)
        ladders.put(3, 22);
        ladders.put(10, 32);
        ladders.put(28, 77);
        ladders.put(58, 96);

        int player1 = 1, player2 = 1; // Both players start at position 1
        boolean turn = true; // true = Player 1's turn, false = Player 2's turn

        System.out.println(" Welcome to Snake and Ladder (2 Player Mode)!\n");

        while (player1 < 100 && player2 < 100) {
            System.out.println("\n" + (turn ? "Player 1" : "Player 2") + ", press ENTER to roll the dice...");
            input.nextLine();

            int dice = rand.nextInt(6) + 1; // Rolling dice (1-6)
            System.out.println(" You rolled: " + dice);

            // Move the current player
            if (turn) {
                player1 = movePlayer(player1, dice);
                System.out.println(" Player 1 Position: " + player1);
            } else {
                player2 = movePlayer(player2, dice);
                System.out.println(" Player 2 Position: " + player2);
            }

            // Check if a player has won
            if (player1 == 100) {
                System.out.println("\n Player 1 wins! ");
                break;
            } else if (player2 == 100) {
                System.out.println("\n Player 2 wins! ");
                break;
            }

            turn = !turn; // Switch turns
        }

        input.close();
    }

    static int movePlayer(int position, int dice) {
        if (position + dice <= 100) // Move only if within 100
            position += dice;

        // Check for ladder
        if (ladders.containsKey(position)) {
            System.out.println(" Ladder! Climb up to " + ladders.get(position));
            position = ladders.get(position);
        }

        // Check for snake
        if (snakes.containsKey(position)) {
            System.out.println(" Snake! Slide down to " + snakes.get(position));
            position = snakes.get(position);
        }

        return position;
    }
}