/**
 * Created by dos on 07.10.2016.
 */
public class QuizCard {
    String question;
    String answer;

    public QuizCard(String q, String a) {
        this.answer = a;
        this.question = q;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
