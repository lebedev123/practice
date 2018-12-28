public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        AClone object = new AClone(new TestField("a","b"));
        AClone clone = object.clone();
        System.out.println(clone);
        ChildObject childObject = new ChildObject(new TestField("a1","b1"));
        ChildObject cloneChild = (ChildObject) childObject.clone();
    }
}


class AClone implements Cloneable{
    TestField testField;

    public AClone(TestField testField) {
        this.testField = testField;
    }

    @Override
    public AClone clone() throws CloneNotSupportedException {
        AClone clone = (AClone)super.clone();
        TestField testField = this.testField.clone();
        clone.setTestField(testField);
        return clone;
    }

    public TestField getTestField() {
        return testField;
    }

    public void setTestField(TestField testField) {
        this.testField = testField;
    }

    @Override
    public String toString() {
        return "AClone{" +
                "testField=" + testField +
                '}';
    }
}


class TestField implements Cloneable{
    String a;
    String b;

    public TestField(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public TestField clone() throws CloneNotSupportedException {
        return (TestField) super.clone();
    }

    @Override
    public String toString() {
        return "TestField{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}


class  ChildObject extends AClone{


    public ChildObject(TestField testField) {
        super(testField);
    }
}







