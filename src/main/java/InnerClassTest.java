public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("java");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("c");
        System.out.println(innerClass.toString());
    }



}

class OuterClass{
    String java;

    public OuterClass(String java) {
        this.java = java;
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "java='" + java + '\'' +
                '}';
    }

    class InnerClass {
        String c;

        public InnerClass(String c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "InnerClass{" +
                    "c='" + c + '\'' +
                    '}' +
                    OuterClass.this.toString();
        }
    }
}
