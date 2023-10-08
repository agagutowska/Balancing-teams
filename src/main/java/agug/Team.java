package agug;

import java.util.ArrayList;
import java.util.List;

class Team {
    List<Person> members = new ArrayList<>();

    public void addMembers(Person person1, Person person2) throws UnequalTeamSizeException {
        if (members.size() % 2 != 0) {
            throw new UnequalTeamSizeException("Unequal number of members in the team");
        }
        members.add(person1);
        members.add(person2);
    }

    public int getTeamSize() {
        return members.size();
    }

    public double calculateTotalRate() {
        double totalRate = 0.0;
        for (Person person : members) {
            totalRate += person.rate;
        }
        return totalRate;
    }

}