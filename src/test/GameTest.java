package src.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Game;
import src.main.models.Team;


public class GameTest {

    Game game;

    @Before
    public void setup(){      
        game = new Game(
            new Team("GRYFFINDOR", "Oliver", "Harry",
            new String[] {"Angelina", "Ginny", "Katie"}) , 
            new Team("SLYTHERIN" , "Vincent", "Draco", 
            new String[] {"Bridget", "Harper", "Malcolm"}));
    }

    @Test
    public void getPlaceholderTest(){
        assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholder(){
        assertEquals("Katie gets the next pass", game.replacePlaceholder("<chaser> gets the next pass", "chaser", "Katie"));
    }






}
