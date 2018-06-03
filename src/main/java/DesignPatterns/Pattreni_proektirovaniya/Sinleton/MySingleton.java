package DesignPatterns.Pattreni_proektirovaniya.Sinleton;

/**
 * Создает только 1 объект класса
 */
public class MySingleton {
    private static MySingleton instance = new MySingleton();
    private MySingleton(){
        //запрещаем другим классам создавать экземпляры MySingleton и присваиваем конструктору private
        //конструктор будет использоваться только 1 раз
    }
    public static MySingleton getInstance(){
        return instance;
    }
}
