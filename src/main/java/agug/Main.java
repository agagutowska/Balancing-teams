package agug;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Johnny", 8.0));
        persons.add(new Person("Robbie", 5.0));
        persons.add(new Person("Juliet", 3.0));
        persons.add(new Person("Scarlet", 5.0));
        persons.add(new Person("Jude", 9.0));
        persons.add(new Person("Deborah", 6.0));

        persons.sort((p1, p2) -> Integer.compare((int) p2.rate, (int) p1.rate));

        int numberOfTeams = 3;

        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            Team team = new Team();
            team.addMembers(persons.get(i), persons.get(persons.size() - 1 - i));
            teams.add(team);
        }

        double totalTeamAverage = teams.stream()
                .mapToDouble(team -> team.calculateTotalRate() / team.getTeamSize())
                .sum();

        double averageTeamAverage = totalTeamAverage / teams.size();

        double totalSquaredDifferences = teams.stream()
                .mapToDouble(team -> Math.pow(team.calculateTotalRate() / team.getTeamSize() - averageTeamAverage, 2))
                .sum();

        double variance = totalSquaredDifferences / teams.size();
        double standardDeviation = Math.sqrt(variance);
//
        for (int i = 0; i < numberOfTeams; i++) {
            Team team = teams.get(i);
            System.out.println("Team no " + (i + 1) + " has " + team.getTeamSize() +
                    " players (" + team.members.get(0).name + ", " + team.members.get(1).name +
                    "). Average rate: " + team.calculateTotalRate() / team.getTeamSize());
        }
        System.out.println("Teams rate standard deviation: " + standardDeviation);
    }
}


