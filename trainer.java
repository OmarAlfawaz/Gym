import java.util.Dictionary;
import java.util.LinkedList;

public class trainer {
    double height , weight;
    String name , specialty;
    LinkedList enlistedTrainee = new LinkedList<>();
    
    public trainer (String name ,String speciality , double height , int weight){
        this.name = name;
        this.specialty = speciality;
        this.height = height;
        this.weight = weight;
    }

    public void addtrainee(trainee s){
        enlistedTrainee.addFirst(s);
    }


public void displayProfile(){
    System.out.println("name: " +name + "\n"
    + "specialty:" + specialty + "\n"
    + "height: " + height + "\n"
    + "weight: " + weight  );
}

    public void showEnlisted(){
       System.out.println(enlistedTrainee.toString());
    }

    public void mangePlan(){

    }

    public void mangeProfile(){

    }

    public void newPlan(){
        
    }

}