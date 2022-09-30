package headfirstjava.chapter15;

public class QuizCard {

    private String question;
    private String answer;
    
    QuizCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion(){
        return this.question;
    }

    public String getAnswer(){
        return this.answer;
    }
}
