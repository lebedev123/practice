public class InnerTest {
    private String name;
    private int i;
    InnerTest(String name,int i){
        this.name = name;
        this.i = i;
    }

    public void sout(){
        System.out.println("InnerTest");
    }
    public InnerClass ret(int id){
        return new InnerClass(id);
    }
    public class InnerClass{
        private int id;
        InnerClass(int id){
            this.id = id;
        }
        void sout(){
            System.out.print("InnerClass" + name + i);
        }
    }

    public static void main(String[] args) {
        InnerTest clas = new InnerTest("John",31);
        InnerClass inner = clas.ret(34);
        InnerClass cl = clas.new InnerClass(35);
    }
}
