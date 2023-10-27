import java.util.Scanner;

public class Game {
    private Grid grid;

    public Game(Grid grid) {
        this.grid = grid;
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            grid.displayGrid();
            System.out.print("Enter your move W(up)/S(down)/A(left)/D(right): ");
            char move = scanner.nextLine().toUpperCase().charAt(0);
            grid.movePlayer(move);

            if (grid.isPlayerOnTreasure()) {
                grid.displayGrid();
                System.out.println("Congratulations! You have found the treasure!");
                break;
            } else if (grid.isPlayerCaughtByMonster()) {
                grid.displayGrid();
                System.out.println("Game Over! You were caught by a monster!");
                break;
                
            } else {
                int distance = grid.calculateDistanceToTreasure();
                System.out.println("Distance to the treasure: " + distance);
            }
        }
        scanner.close();
    }
}
