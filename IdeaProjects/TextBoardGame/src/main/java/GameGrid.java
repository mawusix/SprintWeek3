import java.util.ArrayList;
import java.util.Random;

public class GameGrid implements Grid {
    private char[][] grid;
    private int gridSize;
    private int playerX;
    private int playerY;
    private int treasureX;
    private int treasureY;
    private final ArrayList<Monster> monsters;
    public GameGrid() {
        monsters = new ArrayList<>();
    }
    @Override
    public void setSize(int size) {
        this.gridSize = size;
        this.grid = new char[gridSize][gridSize];
        initialiseGrid();
        placeTreasure();
        placeMonster();
        placePlayer();
    }

    private void initialiseGrid(){
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '-';
            }
        }
    }
    @Override
    public void placeTreasure() {
        Random random = new Random();
        do {
            treasureX = random.nextInt(gridSize);
            treasureY = random.nextInt(gridSize);
        } while (grid[treasureX][treasureY] != '-');

        grid[treasureX][treasureY] = 'T';
    }
    @Override
    public void placeMonster(){
        monsters.clear();
        monsters.add(new MonsterType1());
        monsters.add(new MonsterType2());
        Random random = new Random();
        for (Monster monster : monsters) {
            int monsterX, monsterY;
            do {
                monsterX = random.nextInt(gridSize);
                monsterY = random.nextInt(gridSize);
            } while (grid[monsterX][monsterY] != '-' ||  (monsterX == treasureX && monsterY == treasureY));

            grid[monsterX][monsterY] = 'M';
            monster.setPosition(monsterX, monsterY);
            System.out.println(monster.getGreeting());
        }
    }

    @Override
    public void placePlayer() {
        Random random = new Random();
        do {
            playerX = random.nextInt(gridSize);
            playerY = random.nextInt(gridSize);
        } while (grid[playerX][playerY] != '-');

        grid[playerX][playerY] = 'P';
    }


    @Override
    public void displayGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    public boolean isPlayerOnTreasure() {
        return (playerX == treasureX && playerY == treasureY);
    }

    @Override
    public void movePlayer(char direction){
        switch (direction){
            case 'W':
                if (playerX > 0) {
                    grid[playerX][playerY] = '-';
                    playerX--;
                    grid[playerX][playerY] = 'P';
                }
                break;
            case 'S':
                if (playerX < gridSize - 1) {
                    grid[playerX][playerY] = '-';
                    playerX++;
                    grid[playerX][playerY] = 'P';
                }
                break;
            case 'A':
                if (playerY > 0) {
                    grid[playerX][playerY] = '-';
                    playerY--;
                    grid[playerX][playerY] = 'P';
                }
                break;
            case 'D':
                if (playerY < gridSize - 1) {
                    grid[playerX][playerY] = '-';
                    playerY++;
                    grid[playerX][playerY] = 'P';
                }
                break;
            default:
                System.out.println("Invalid move. Please enter W (up), S (down), A (left), or D (right).");
        }
    }
    @Override
    public int calculateDistanceToTreasure(){
        return Math.abs(playerX-treasureX) + Math.abs(playerY-treasureY);
    }

    @Override
    public boolean isPlayerCaughtByMonster() {
        for (Monster monster : monsters) {
            if (playerX == monster.getX() && playerY == monster.getY()) {
                return true;
            }
        }
        return false;
    }

}