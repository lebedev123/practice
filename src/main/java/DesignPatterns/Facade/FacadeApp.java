package DesignPatterns.Facade;

/**
 * Паттерн Facade скрывает сложную логику программы
 */
public class FacadeApp {
    public static void main(String[] args) {
        /*Power power  = new Power();
        power.on();
        DVDRom rom = new DVDRom();
        rom.loadData();
        HDD hdd = new HDD();
        hdd.copyFromDVD(rom);*/
        // чтобы все это не делать следует вынести весь код
        Computer computer = new Computer();
        computer.copy();
        //Теперь мы можем обращаться к Computer не вдаваясь в реализацию
    }
}
class Computer{
    Power power = new Power();
    DVDRom rom = new DVDRom();
    HDD hdd = new HDD();
    void  copy(){
        power.on();
        rom.loadData();
        hdd.copyFromDVD(rom);
    }
}

//Моделирование работы с ПК
class Power {
    void on() {
        System.out.println("Включение питания");
    }

    void off() {
        System.out.println("Выключение питания");
    }

}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void loadData() {
        data = true;
    }

    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Копирование...");
        } else {
            System.out.println("Вставьте диск");
        }
    }
}