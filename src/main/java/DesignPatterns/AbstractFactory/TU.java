package DesignPatterns.AbstractFactory;

public class TU implements Air {
    public TU() {
        String jopa = "Может долетите, но это не точно";
    }

    @Override
    public void flight() {
        System.out.println("Вам выпал объект Tu-76.Вы трясетесь так, что шасси выпадают в полете");
    }
}
