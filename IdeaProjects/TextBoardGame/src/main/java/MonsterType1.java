public class MonsterType1 implements Monster{
    private int x;
    private int y;

    public MonsterType1() {
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getGreeting() {
        return "The Boggy Monster says: Grr! I will catch you!";
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
