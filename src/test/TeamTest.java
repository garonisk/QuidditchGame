package src.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;

import org.junit.Test;

import src.main.models.Team;

public class TeamTest {

    @Test
    public void hasNullTest(){
        String[] chasers = new String[] {null, "Ginny" , "Katie" };
        assertTrue(Team.hasNull(chasers));;
    }
    

}
