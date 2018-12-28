package DesignPatterns.Pattreni_proektirovaniya.Command;


/**
 * Команда выключения света
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public LightOffCommand() {
    }

    @Override
    public void execute() {
        light.off();
    }
}
