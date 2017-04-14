package JavaExact;

public class test {
    public static void main(String[] args) {
        int[] i = {43, 32, 11};
        int[] j = i.clone();
        String[] s = {"one", "two", "three"};
        String[] s1 = s.clone();
        System.out.println("s1 =");
        for (String l : s1
                ) {
            System.out.println(l);
        }
        System.out.println(" i = ");
        for (int i1 : j
                ) {
            System.out.println(i1);
        }
        User[] users = {new User("John",34),new User("Booba",33)};
        User[] users1 = users.clone();
        for(User u : users1){
            System.out.println(u);
        }
        users[0].setAge(88);
        for(User u : users1){
            System.out.println(u);
        }
    }
}
