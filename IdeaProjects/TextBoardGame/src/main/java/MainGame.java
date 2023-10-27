public class MainGame {
    public static void main(String[] args) {
        Grid grid = new GameGrid();
        grid.setSize(3);
        Game game = new Game(grid);
        game.startGame();
    }
}
