package DesignPatterns.Pattreni_proektirovaniya.Command;


/**
 * "Паттерн команда инкапсулирует запрос в виде объекта
 * делая возможной параметризацию клиентских объектов с другими запросами,
 * организацию очереди или регистрацию запросов"
 *
 * По сути паттерн позволяет делегировать выполнение определенной команды определеному объекту который может исполнить ее
 * В нашем случае это Light, а RemoteControl делегирует выполнение этому объекту посредством интерфейса Command и определенным объектам
 * В итоге сам объект RemoteControl ничего не знает о самих реализациях а лишь содержит набор каких то команд которые назначаются в тестовом Main
 *
 * Что это за хуета не понимаю, и почему в main не можем просто вызывать light.on/off раз уж мы тут его и создаем, не понятно.
 * Вероятно есть вариант когда я получаю уже готовые команды, в которых уже есть требуемый объект,
 * хотя они должны где то конструироваться с нужными объектами
 *
 * Ну да ладно, потом разберусь (нет)
 */
public class Test {
    public static void main(String[] args) {
        Light light = new Light(); // Создание объекта лампы
        LightOnCommand lightOnCommand = new LightOnCommand(light);//Создание объекта команды под включение
        LightOffCommand lightOffCommand = new LightOffCommand(light);//Создание объекта команды под выключение
        RemoteControl remoteControl = new RemoteControl();//Управление
        remoteControl.setCommand(1,lightOnCommand,lightOffCommand);//Установка команды на управление
        remoteControl.offButtonPushed(1);
        remoteControl.onButtonPushed(1);
    }
}
