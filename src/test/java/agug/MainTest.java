package agug;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Test checks if each of team has at least one member")
    void testTeamCreationAndBalancing() {
        //given
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Johnny", 8.0));
        persons.add(new Person("Robbie", 5.0));
        persons.add(new Person("Juliet", 3.0));
        persons.add(new Person("Scarlet", 5.0));
        persons.add(new Person("Jude", 9.0));
        persons.add(new Person("Deborah", 6.0));

        persons.sort((p1, p2) -> Integer.compare((int) p2.rate, (int) p1.rate));

        int numberOfTeams = 3;

        //when
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            Team team = new Team();
            team.addMembers(persons.get(i), persons.get(persons.size() - 1 - i));
            teams.add(team);
        }

        //then
        for (Team team : teams) {
            assertTrue(team.getTeamSize() > 0);
        }
    }

    @Test
    @DisplayName("Test checks if the differences in total rates of teams are minimal - when the standard deviation value is < 0.5 (assumption)")
    void testTeamBalancing() {
        //given
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Johnny", 8.0));
        persons.add(new Person("Robbie", 5.0));
        persons.add(new Person("Juliet", 3.0));
        persons.add(new Person("Scarlet", 5.0));
        persons.add(new Person("Jude", 9.0));
        persons.add(new Person("Deborah", 6.0));

        persons.sort((p1, p2) -> Integer.compare((int) p2.rate, (int) p1.rate));

        int numberOfTeams = 3;

        //when
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            Team team = new Team();
            team.addMembers(persons.get(i), persons.get(persons.size() - 1 - i));
            teams.add(team);
        }

        // then
        double totalTeamAverage = teams.stream()
                .mapToDouble(team -> team.calculateTotalRate() / team.getTeamSize())
                .sum();
        double averageTeamAverage = totalTeamAverage / teams.size();

        double totalSquaredDifferences = teams.stream()
                .mapToDouble(team -> Math.pow(team.calculateTotalRate() / team.getTeamSize() - averageTeamAverage, 2))
                .sum();
        double variance = totalSquaredDifferences / teams.size();
        double standardDeviation = Math.sqrt(variance);

        assertTrue(standardDeviation < 0.5);
    }
}
