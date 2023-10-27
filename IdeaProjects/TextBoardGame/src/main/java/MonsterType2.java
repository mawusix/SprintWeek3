public class MonsterType2 implements Monster{

    private int x;
    private int y;

    public MonsterType2(){
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getGreeting() {
        return "The Goblin Monster says: Roar! You can't escape!";
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
