import java.util.Scanner;

/**
 * The Dice game 12 - Marked assignment 1
 * 0. Create Constants and variables needed
 * 1. Print the welcome
 * 2. Get user input of what dice to roll
 * 3. Validate the input is valid (1,2,3 and q)
 * 4. Validate that dice is not already thrown
 * 5. Create Random number 1-6 (random(6) + 1)
 * 6. Calculate total
 * 7. Print state
 * 8. Repeat step 2-5 until all 3 is thrown
 * 9. Check if 12, < 12 or > 12 - Win, draw or loss
 * 10. Add result to amount of wins and losses
 * 11. Start new round
 * 12. When Quit, print result of wins and losses
 *
 * @author Jonas Wennberg (wenjon-3)
 */

public class Main {

    // Constants
    static final String WELCOME = "Welcome to dice game 12. "
            + "You must roll 1-3 dice and try to get the sum of 12 ...";
    static final String CHOICES = "Enter which dice you want to roll [1,2,3]"
            + " (exit with q):";
    static final String ALREADY_ROLLED = "Sorry, you have already rolled that "
            + "dice. Try again";
    static final String INVALID_ENTRY = "Sorry, that is an invalid entry. "
            + "Try again. Valid entries are 1, 2, 3, and q";
    static final String WIN = "You won!!";
    static final String LOSS = "You lost!!";
    static final String DRAW = "You neither won nor lost the game.";
    static final String NEXT_ROUND = "Next round!";
    static final String GAME_OVER = "Game Over!";
    static final int MIN_DICE_VALUE = 1;
    static final int MAX_DICE_VALUE = 6;
    static final int WINNING_NUMBER = 12;
    static final int INPUT_VALUE1 = 1;
    static final int INPUT_VALUE2 = 2;
    static final int INPUT_VALUE3 = 3;

    /**
    * Main program for The Dice game 12
    * All inputs, calculations and prints are handled here
     * @param args for eventual java arguments
    */
    public static void main(final String[] args) {

        // Create variables
        int totalWins = 0;
        int totalLosses = 0;
        boolean isDice1thrown = false;
        boolean isDice2thrown = false;
        boolean isDice3thrown = false;
        boolean gameIsQuit = false;
        int dice1 = 0;
        int dice2 = 0;
        int dice3 = 0;
        int totalAmount = 0;
        int currentDiceInput = 0;
        int randomNumber = 0;

        // Create input scanner
        Scanner userInput = new Scanner(System.in);

        // Print header
        System.out.println(WELCOME);

        // Loop until quit
        while (!gameIsQuit) {

            // print choices
            System.out.print(CHOICES);
            if (userInput.hasNextInt()) {
                currentDiceInput = userInput.nextInt();

                // Handle the different kind of inputs
                switch (currentDiceInput) {
                    case INPUT_VALUE1:
                        /* Verify dice 1 is not already thrown
                         * and calculate value
                         */
                        if (!isDice1thrown) {
                            randomNumber = (int) (Math.random()
                                    * MAX_DICE_VALUE);
                            dice1 = MIN_DICE_VALUE + randomNumber;
                            totalAmount += dice1;
                            isDice1thrown = true;
                            System.out.printf(
                                    "%d %d %d sum: %d #win: %d # loss: %d %n",
                                    dice1, dice2, dice3,
                                    totalAmount, totalWins, totalLosses);
                        } else {
                            System.out.println(ALREADY_ROLLED);
                        }
                        break;
                    case INPUT_VALUE2:
                        /* Verify dice 2 is not already thrown
                         * and calculate value
                        */
                        if (!isDice2thrown) {
                            randomNumber = (int) (Math.random()
                                    * MAX_DICE_VALUE);
                            dice2 = MIN_DICE_VALUE + randomNumber;
                            totalAmount += dice2;
                            isDice2thrown = true;
                            System.out.printf(
                                    "%d %d %d sum: %d #win: %d # loss: %d %n",
                                    dice1, dice2, dice3,
                                    totalAmount, totalWins, totalLosses);
                        } else {
                            System.out.println(ALREADY_ROLLED);
                        }
                        break;
                    case INPUT_VALUE3:
                        /* Verify dice 3 is not already thrown
                         * and calculate value
                         */
                        if (!isDice3thrown) {
                            randomNumber = (int) (Math.random()
                                    * MAX_DICE_VALUE);
                            dice3 = MIN_DICE_VALUE + randomNumber;
                            totalAmount += dice3;
                            isDice3thrown = true;
                            System.out.printf(
                                    "%d %d %d sum: %d #win: %d # loss: %d %n",
                                    dice1, dice2, dice3,
                                    totalAmount, totalWins, totalLosses);
                        } else {
                            System.out.println(ALREADY_ROLLED);
                        }
                        break;
                    default:
                        System.out.println(INVALID_ENTRY);
                        break;
                }

            } else if (userInput.hasNext()) {
                String input = userInput.next();
                // Quit if "q" is pressed
                if (input.equals("q")) {
                    // Print result
                    System.out.printf("#win: %d #loss: %d  %n",
                            totalWins, totalLosses);
                    System.out.println(GAME_OVER);
                    gameIsQuit = true;
                } else {
                    System.out.println(INVALID_ENTRY);
                }
            } else {
                System.out.println(INVALID_ENTRY);
            }
            if (isDice1thrown && isDice2thrown && isDice3thrown) {

                // Reset dices
                dice1 = 0;
                dice2 = 0;
                dice3 = 0;
                isDice1thrown = false;
                isDice2thrown = false;
                isDice3thrown = false;

                // Add win or loss to result
                if (totalAmount == WINNING_NUMBER) {
                    totalWins++;
                    System.out.println(WIN);
                } else if (totalAmount > WINNING_NUMBER) {
                    totalLosses++;
                    System.out.println(LOSS);
                } else {
                    System.out.println(DRAW);
                }
                // Reset score
                totalAmount = 0;
                System.out.println(NEXT_ROUND);

            }


        }
        // Print total result
        System.exit(0);

    }
}
