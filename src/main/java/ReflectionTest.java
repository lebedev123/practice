import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ReflectionTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Integer i = new Integer(34);
        DateTestForClone dateTestForClone = new DateTestForClone(new Date());
        DateTestForClone dateTestForClone1 = dateTestForClone.clone();


    }

    public static class DateTestForClone implements  Cloneable{
        Date date;

        public DateTestForClone(Date date) {
            this.date = date;
        }

        public DateTestForClone clone() throws CloneNotSupportedException {
            return (DateTestForClone) super.clone();
        }

        protected Integer testMethod(){
            return  new Integer(34);
        }
    }

    private static class TestOverride extends DateTestForClone{
        public TestOverride(Date date) {
            super(date);
        }

    }
}
