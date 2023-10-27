
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MonsterTest {
    MonsterType1 monsterType1;
    MonsterType2 monsterType2;

    @BeforeEach
    public void setUp() {
        monsterType1 = new MonsterType1();
        monsterType2 = new MonsterType2();
    }
    @Test
    public void testMonsterType1Greeting(){
        String expectedGreeting = "The Boggy Monster says: Grr! I will catch you!";
        assertEquals(expectedGreeting, monsterType1.getGreeting());
    }
    @Test
    public void testMonster1GetX(){
        monsterType1.setPosition(3,5);
        assertEquals(3, monsterType1.getX());
    }
    @Test
    public void testMonster1GetY(){
        monsterType1.setPosition(3,5);
        assertEquals(5, monsterType1.getY());
    }
    @Test
    public void testMonsterType2Greeting(){
        String expectedGreeting = "The Goblin Monster says: Roar! You can't escape!";
        assertEquals(expectedGreeting, monsterType2.getGreeting());
    }
    @Test
    public void testMonster2GetX(){
        monsterType2.setPosition(6,2);
        assertEquals(6, monsterType2.getX());
    }
    @Test
    public void testMonster2GetY() {
        monsterType2.setPosition(6, 2);
        assertEquals(2, monsterType2.getY());

    }

}

