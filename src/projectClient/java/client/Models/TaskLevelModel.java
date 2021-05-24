package client.Models;

import javafx.scene.image.ImageView;

public class TaskLevelModel {
    private String topicTask = "NOT FOUND";
    private String textTask = "NOT FOUND";
    private Integer numberAnswer = 0;
    private Integer trueAnswer = 0;
    private ImageView[] masImageAnswer = null;
    private String[] masTextAnswer = null;
    private String meshFilename = null;
    private Integer typeAnswer = 0; // 1 - text, 2 - image

    public TaskLevelModel(String topicTask, String textTask, Integer numberAnswer, Integer trueAnswer, ImageView[] masImageAnswer, String[] masTextAnswer, String meshFilename, Integer typeAnswer) {
        this.topicTask = topicTask;
        this.textTask = textTask;
        this.numberAnswer = numberAnswer;
        this.trueAnswer = trueAnswer;
        this.masImageAnswer = masImageAnswer;
        this.masTextAnswer = masTextAnswer;
        this.meshFilename = meshFilename;
        this.typeAnswer = typeAnswer;
    }

    public String getTopicTask() {
        return topicTask;
    }

    public void setTopicTask(String topicTask) {
        this.topicTask = topicTask;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public Integer getNumberAnswer() {
        return numberAnswer;
    }

    public void setNumberAnswer(Integer numberAnswer) {
        this.numberAnswer = numberAnswer;
    }

    public Integer getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(Integer trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public ImageView[] getMasImageAnswer() { return masImageAnswer; }

    public void setMasImageAnswer(ImageView[] masImageAnswer) { this.masImageAnswer = masImageAnswer; }

    public String getMeshFilename() {
        return meshFilename;
    }

    public void setMeshFilename(String meshFilename) {
        this.meshFilename = meshFilename;
    }

    public Integer getTypeAnswer() { return typeAnswer; }

    public void setTypeAnswer(Integer typeAnswer) { this.typeAnswer = typeAnswer; }

    public String[] getMasTextAnswer() { return masTextAnswer; }

    public void setMasTextAnswer(String[] masTextAnswer) { this.masTextAnswer = masTextAnswer; }
}
