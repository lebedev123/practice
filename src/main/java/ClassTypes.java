public class ClassTypes {


    private static class StaticInner {
        String descr;
        int id;

    }


    class JustInner{
        int asdasdasd;

        public JustInner(int asdasdasd) {
            this.asdasdasd = asdasdasd;
        }

        public int getAsdasdasd() {
            return asdasdasd;
        }

        public void setAsdasdasd(int asdasdasd) {
            this.asdasdasd = asdasdasd;
        }
    }

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner(); //Ссылка на внешний класс отсутствует, если класс private то может использоваться только в рамках этого класса
        ClassTypes types = new ClassTypes();
        JustInner justInner = types.new JustInner(123123); // Присутствует ссылка на внешний класс
        System.out.println(justInner.getAsdasdasd());


    }


}


