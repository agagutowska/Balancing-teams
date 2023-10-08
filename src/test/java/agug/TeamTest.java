package agug;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    @Test
    @DisplayName("Test checks if team members are added correctly")
    void testAddMembers() {
        //given
        Person person1 = new Person("Johnny", 8.0);
        Person person2 = new Person("Robbie", 5.0);
        //when
        Team team = new Team();
        team.addMembers(person1, person2);
        //then
        assertEquals(2, team.getTeamSize());
        assertTrue(team.getMembers().contains(person1));
        assertTrue(team.getMembers().contains(person2));
    }

    @Test
    @DisplayName("Test checks if the sum ot the team's rates is calculated correctly")
    void testCalculateTotalRate() {
        //given
        Person person1 = new Person("Johnny", 8.0);
        Person person2 = new Person("Robbie", 5.0);
        //when
        Team team = new Team();
        team.addMembers(person1, person2);
        //then
        assertEquals(13.0, team.calculateTotalRate());
    }

}