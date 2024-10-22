import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //variables
        boolean rematch = true;
        boolean pointChecker = false;
        boolean rematchChecker = false;
        boolean startGame = false;
        String userRematch;
        String userStart;
        int sum = 0;
        int sum2 = 0;
        int dice1;
        int dice2;
        int dice3;
        int dice4;

        System.out.println("Rule 1: There is an initial roll of 2 dice resulting in a sum of 2 – 12");
        System.out.println("Rule 2: If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss");
        System.out.println("Rule 3: If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win");
        System.out.println("Rule 4: For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win");
        System.out.println("\n\n");

        System.out.println("Would you like to play? Y/N");
        userStart = scan.nextLine();
        do {
            if (userStart.equalsIgnoreCase("y")) {
                startGame = true;
            } else if (userStart.equalsIgnoreCase("n")) {
                System.out.println("Get outta here!");
                System.exit(0);
            } else {
                System.out.println("Enter Y/N");
                userStart = scan.nextLine();
            }
        } while(!startGame);

        do {
            rematch = true;
            pointChecker = false;
            rematchChecker = false;
            dice1 = (int) (Math.random() * (6-1) +1);
            dice2 = (int) (Math.random() * (6-1) +1);
            sum = dice1 + dice2;
            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            System.out.println("Sum: " + sum);
            if (sum == 7 || sum == 11) {
                System.out.println("You just rolled a natural! You win!");
            }
            else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You just crapped out. Sorry try again!");
            }
            else {
                System.out.println(sum + " is now the point! Press enter to continue");
                scan.nextLine();
                do {
                    dice3 = (int) (Math.random() * (6-1) +1);
                    dice4 = (int) (Math.random() * (6-1) +1);
                    sum2 = dice3 + dice4;
                    System.out.println("Dice 1: " + dice4);
                    System.out.println("Dice 2: " + dice3);
                    System.out.println("Sum: " + sum2);
                    if (sum == sum2) {
                        System.out.println("You have matched the point! You win!");
                        pointChecker = true;
                    }
                    else if (sum2 == 7){
                        System.out.println("Ouch, you rolled a 7 and lost!");
                        pointChecker = true;
                    }
                    else {
                        System.out.println("Roll again! Press enter to continue");
                        scan.nextLine();
                    }
                } while (!pointChecker);
            }
            System.out.println("Do you want to rematch? Y/N");
            userRematch = scan.nextLine();
            do {
                if (userRematch.equalsIgnoreCase("y")) {
                    rematch = true;
                    rematchChecker = true;
                } else if (userRematch.equalsIgnoreCase("n")) {
                    rematchChecker = true;
                    rematch = false;
                }
                else {
                    System.out.println("please enter Y/N");
                    userRematch = scan.nextLine();
                }
            } while (!rematchChecker);
        } while (rematch);
    }
}