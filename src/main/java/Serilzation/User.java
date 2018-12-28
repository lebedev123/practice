package Serilzation;
import java.io.*;

public class User implements Externalizable {

    private int id;
    private String username;
    private String email;

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(username);
        out.writeObject(email);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        id = in.readInt();
        username = (String) in.readObject();
        email = (String) in.readObject();
    }

}
class Main {

    public static void main(String[] args)
            throws Exception {

        User userWrite = new User(1, "johndoe", "John Doe");
        FileOutputStream fos = new FileOutputStream("testfile");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(userWrite);
        oos.flush();
        oos.close();

        User userRead;
        FileInputStream fis = new FileInputStream("testfile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        userRead = (User)ois.readObject();
        ois.close();

        System.out.println("username: " + userRead.getUsername());

    }

}
