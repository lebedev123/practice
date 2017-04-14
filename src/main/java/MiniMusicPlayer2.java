import javax.sound.midi.*;

/**
 * Created by dos on 03.10.2016.
 */
public class MiniMusicPlayer2 implements ControllerEventListener{
    public static void main(String[] args){
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }
    public void go(){
        try{
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            //Регистрация события
            //Метод принимает объект слушателя и массив представляющий список событий ControllerEvent ,нас интересует именно 127 событие

            int [] eventsIWant = {127};
            sequencer.addControllerEventListener(this,eventsIWant);
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();
            for(int i =5;i<60;i+=4){
                track.add(makeEvent(144,1,i,100,i));
                //Вставляем событие (176 - тип события ControllerEvent) которое реагирует на воспроизведение каждой ноты.
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,i,100,i+2));
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//метод обработки события, прикаждом вызове мы получаем ля
    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("ля");
    }
    public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick){ // четыре параметра для сообщения а событие tick - момент появление данного сообщения
        MidiEvent event = null;
        try{        //создаем сообщение и событие используя параметры метода
            ShortMessage a =new ShortMessage();
            a.setMessage(comd,chan,one,two);
            event = new MidiEvent(a,tick);
        }catch (Exception ex){}
        return event;
    }
}
