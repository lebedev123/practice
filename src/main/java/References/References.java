import sun.misc.GC;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Strong reference
 * Weak Reference
 * Soft Reference
 * Phantom Reference
 */
public class References {
    public static void main(String[] args) throws InterruptedException {
        //Strong
        String string1 = new String("gachiBASS");
        String string2 = new String("gachiGASM");
        String string3 = new String("forsenS");

        //Weak
        WeakReference<String> weakString = new WeakReference<String>(string1); // При обнулении string1 , (string1 = null) weak ссылка не спасет от удаления объекта , соответственно до объекта можно достучаться пока есть стронг ссылка
        SoftReference<String> softString = new SoftReference<String>(string2); //Тоже что и weak только объект удалится только если есть острая нехватка памяти
        PhantomReference<String> phantomString = new PhantomReference<String>(string3, new ReferenceQueue<String>());
        string1 = null;
        string2 = null;
        string3 = null;
        System.gc();
        Thread.sleep(10000);
        if (softString.get() != null) {
            System.out.println("Soft is " + softString.get().toString());
        } else {
            System.out.println("Soft is empty");
        }
        if (phantomString.get() != null) {
            System.out.println("Phantom is " + phantomString.get().toString());
        }else{
            System.out.println("Phantom is empty");
        }
        if (weakString.get() != null){
            System.out.println("Weak is" + weakString.get().toString());
        }else {
            System.out.println("Weak is empty");
        }


    }

}
