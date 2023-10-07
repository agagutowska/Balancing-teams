package agug;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Johnny", 8));
        persons.add(new Person("Robbie", 5));
        persons.add(new Person("Juliet", 3));
        persons.add(new Person("Scarlet", 5));
        persons.add(new Person("Jude", 9));
        persons.add(new Person("Deborah", 6));

        int numberOfTeams = 3;

        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            teams.add(new Team());
        }

        persons.sort((p1, p2) -> Integer.compare(p2.rate, p1.rate));

        int teamIndex = 0;
        for (Person person : persons) {
            teams.get(teamIndex).addMember(person);
            teamIndex = (teamIndex + 1) % numberOfTeams;
        }

        teams.sort((t1, t2) -> Integer.compare(t2.calculateTotalRate(), t1.calculateTotalRate()));

        for (int i = 0; i < numberOfTeams; i++) {
            Team team = teams.get(i);
            System.out.println("Team no " + (i + 1) + " has " + team.getTeamSize() +
                    " players (" + team.members.get(0).name + ", " + team.members.get(1).name +
                    "). Average rate: " + team.calculateTotalRate()/team.getTeamSize());
        }
    }
}