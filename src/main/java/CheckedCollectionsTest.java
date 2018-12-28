import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;

public class CheckedCollectionsTest {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List rawList = stringList;
        rawList.add(LocalDate.now());
        List<String> checkedStringList = Collections.checkedList(stringList,String.class);
        List checkedRawList = checkedStringList;
        checkedRawList.add(LocalDate.now());
      //  stringList.forEach(s -> System.out.println(s));
    }
}
