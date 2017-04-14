import javax.swing.*;

/**
 * Created by dos on 30.11.2016.
 */
public class CallBackTest {
    interface CallBack{
        void CallBack();
    }
    CallBack callBack;
    public void registerCallBack(CallBack callBack){
        this.callBack = callBack;
    }
    void doSmth(){
        JOptionPane.showMessageDialog(null,"Working");
        callBack.CallBack();
    }
}
class MyClass implements CallBackTest.CallBack{

    @Override
    public void CallBack() {
        System.out.println("Calling back");
    }
}
class Main{
    public static void main(String[] args){
        CallBackTest callBackTest = new CallBackTest();
        MyClass myClass = new MyClass();
        callBackTest.registerCallBack(myClass);
        callBackTest.doSmth();
    }
}