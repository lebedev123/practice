package Actions;

/**
 * Created by dos on 01.02.2017.
 */
public class User {
    String name;
    char[] password;

    public User(String name, char[] password) {
        this.name = name;
        this.password = password;
    }
    public String getName(){
        return name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setName(String name) {

        this.name = name;
    }
}
