package system;

import java.util.Dictionary;
import java.util.Hashtable;

public class session extends progress {
    Dictionary<String, progress> sessions=new Hashtable();
    progress info=new progress();


    public session(String workout) {
        sessions.put(workout, info);
    }
    public session(String workout,int rips, int sits, int weight, String muscle){
        info=new progress(rips,sits,weight,muscle);
        sessions.put(workout,info);
    }

    public void showState(String workout){
        System.out.println(sessions.get(workout));
    }


    public static void main(String[] args) {
        session x=new session("Signup",8,8,180,"chest");

        x.sessions.get("Signup").setRips(6);// Example of changing info
        x.showState("Signup");

    }
}