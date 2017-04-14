import javax.sound.midi.*;

/**
 * Created by dos on 02.10.2016.
 */
public class MiniMusicPlayer1 {
    public static void main(String[] args){
        try{
            Sequencer sequencer = MidiSystem.getSequencer();//создаем и открываем синтезатор
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);// Создаем последовательность и дорожку
            Track track = seq.createTrack();
            for(int i=5;i<61;i+=4){     //группа событий чтобы ноты поднимались от 5 до 61
                track.add(makeEvent(144,1,i,100,i));//144 - включение
                track.add(makeEvent(128,1,i,100,i+2));//128 - выключение
            }
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
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
