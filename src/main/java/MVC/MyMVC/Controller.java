package MVC.MyMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;

    public Controller(Model model) {
        this.model = model;
        setValue();
    }

    public void setValue() {
        this.setValue1(0);
        this.setValue2(0);
    }
    public int getValue1() {
        return model.value1;
    }

    public void setValue1(int value1) {
        model.value1 = value1;
    }

    public int getValue2() {
        return model.value2;
    }

    public void setValue2(int value2) {
        model.value2 = value2;
    }
}
