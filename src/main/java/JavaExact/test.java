package JavaExact;

public class test {
    public static void main(String[] args) {
        int[] i = {43, 32, 11};
        int[] j = i.clone();
        String[] s = {"one", "two", "three"};
        String[] s1 = s.clone();
        System.out.print("s1 =");
        for (String l : s1
                ) {
            System.out.print(l + " ");
        }
        System.out.print("\ni = ");
        for (int i1 : j
                ) {
            System.out.print(i1 + " ");
        }
        System.out.println("\n");
        User[] users = {new User("John", 34), new User("Booba", 33)};
        User[] users1 = users.clone();
        for (User u : users1) {
            System.out.println(u);
        }
        System.out.println("clone");
        //users[0].setAge(88);
        for (User u : users1) {
            System.out.println(u);
        }
    }
}
