import java.io.*;

/**
 * Created by dos on 07.10.2016.
 */
public class GameSaverTest {
    public static void main(String[] args){
        GameCharacter one = new GameCharacter(50,"elf",new String[]{"bow","knife","kastet"});
        GameCharacter two = new GameCharacter(200,"dworf",new String[]{"axe","big axe","super axe"});
        GameCharacter three = new GameCharacter(300,"mage",new String[] {"magic,supa magic","giga magic"});
    try{
        ObjectOutputStream os = null;
        os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
        os.writeObject(one);
        os.writeObject(two);
        os.writeObject(three);
        os.close();
    }catch (IOException e)
    {
        e.printStackTrace();
    }
    one = null;
    two = null;
    three = null;
    try{
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
        GameCharacter oneRestore = (GameCharacter) is.readObject();
        GameCharacter twoRstore = (GameCharacter)is.readObject();
        GameCharacter threeRestore = (GameCharacter)is.readObject();

        System.out.println("Тип первого: " + oneRestore.getType());
        System.out.println("Тип второго: " + twoRstore.getType() );
        System.out.println("Тип третьего :" + threeRestore.getType());
    }catch(Exception ex){
        ex.printStackTrace();
    }
}}

