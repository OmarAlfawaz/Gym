package system;
import java.io.*;
public class OfflineSave {
    OfflineSave(String name, String password, String type) throws IOException {
        String details = name + "," + password + "," + type;
        FileOutputStream fileOutputStream = new FileOutputStream("OfflineSave.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(details);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
    public String uploud() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/Users/saudabdulaziz/Documents/Gym/OfflineSave.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String details = (String) objectInputStream.readObject();
        objectInputStream.close();
        return details;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OfflineSave m = new OfflineSave("Osamah", "1234", "trainer");
        System.out.println(m.uploud());
    }
}