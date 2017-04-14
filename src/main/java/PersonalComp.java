import java.util.Comparator;

/**
 * Created by dos on 30.11.2016.
 */
class PersonalComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] arg = new String[4];
        Integer i = 1000;
        int i1 = 0;
        for (String o : arg) {
            arg[i1] = i.toString();
            i -= 100;
            i1++;
        }
        PersonalComp o1 = new PersonalComp();
        if (o1.compare(arg[0], arg[2]) > 0) System.out.print("o1>o2");
    }
}
