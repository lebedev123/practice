/**
 * Created by dos on 23.09.2016.
 */
import javax.sound.midi.*;
public class MusicTest1 {
    public static void main(String[] args){
        MusicTest1 music = new MusicTest1();
        music.play();
    }
    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track t = seq.createTrack();
            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,20,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            t.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,33,100);
            MidiEvent noteOff = new MidiEvent(b,20);
            t.add(noteOff);

            sequencer.setSequence(seq);

            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sintezator");
    }
}
