package client.Models;

public class AnswerModel {
    private String answer;
    private Integer numberAnswer;

    public AnswerModel(Integer numberAnswer, String answer) {
        this.answer = answer;
        this.numberAnswer = numberAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getNumberAnswer() {
        return numberAnswer;
    }

    public void setNumberAnswer(Integer numberAnswer) {
        this.numberAnswer = numberAnswer;
    }
}
