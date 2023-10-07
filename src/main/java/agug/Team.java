package agug;

import java.util.ArrayList;
import java.util.List;

class Team {
    List<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        members.add(person);
    }

    public int getTeamSize() {
        return members.size();
    }

    public int calculateTotalRate() {
        int totalRate = 0;
        for (Person person : members) {
            totalRate += person.rate;
        }
        return totalRate;
    }

}
