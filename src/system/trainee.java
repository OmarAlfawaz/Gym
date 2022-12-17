package system;

import java.util.LinkedList;

public class trainee {
    int height, weight;
    String name,trainer;
    LinkedList enlistedTrainee = new LinkedList<>();

    public trainee(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

}
