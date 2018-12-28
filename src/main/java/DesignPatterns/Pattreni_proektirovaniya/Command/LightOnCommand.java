package DesignPatterns.Pattreni_proektirovaniya.Command;


/**
 * Команда включения света
 */
public class LightOnCommand implements Command {
    private Light light;


    @Override
    public void execute() {
        light.on();
    }

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public LightOnCommand() {
    }
}
