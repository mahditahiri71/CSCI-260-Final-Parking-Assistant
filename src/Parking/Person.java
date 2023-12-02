package Parking;
public class Person {
    int id;
    int rank;
    String name;

    public Person(int id, int rank, String name){
        this.id = id;
        this.rank = rank;
        this.name = name;
    }

    public boolean isHigherRank(Person person){
        return (this.rank > person.rank);
    }
}
