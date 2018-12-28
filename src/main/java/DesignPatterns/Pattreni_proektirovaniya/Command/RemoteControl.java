package DesignPatterns.Pattreni_proektirovaniya.Command;


/**
 * Объект который должен содержать набор команд для включения и выключения ( в данном случае имеет 7 слотов, не спрашивай почему)
 * Умеет сетить команды и выполнять их при условии что ты знаешь слот в которой находится команда
 * Как ты мог заметить массива два, каждая команда имеет пару - включение и выключение, и находятся они в одинаковых индексах слотов в обоих массивов
 * Так и живем
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];
    }
    public void setCommand(int slotNumber , Command onCommand,Command offCOmmand){
        this.onCommands[slotNumber] = onCommand;
        this.offCommands[slotNumber] = offCOmmand;
    }
    public void onButtonPushed(int slotNumber){
        onCommands[slotNumber].execute();
    }
    public void offButtonPushed(int slotNumber){
        offCommands[slotNumber].execute();
    }
}
