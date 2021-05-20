package client.Models;

import javax.swing.text.html.ImageView;

public class TaskLevelModel {
    private String stringTopic = "NOT FOUND";
    private String stringTask = "NOT FOUND";
    private Integer integerNumberAnswer = 0;
    private Integer integerTrueAnswer = 0;
    private ImageView masImageViewAnswer = null;
    private String stringMeshFilename = null;

    public TaskLevelModel(String stringTopic, String stringTask, Integer integerNumberAnswer, Integer integerTrueAnswer, ImageView masImageViewAnswer, String stringMeshFilename) {
        this.stringTopic = stringTopic;
        this.stringTask = stringTask;
        this.integerNumberAnswer = integerNumberAnswer;
        this.integerTrueAnswer = integerTrueAnswer;
        this.masImageViewAnswer = masImageViewAnswer;
        this.stringMeshFilename = stringMeshFilename;
    }

    public TaskLevelModel(String stringTopic, String stringTask) {
        this.stringTopic = stringTopic;
        this.stringTask = stringTask;
    }

    public String getStringTopic() {
        return stringTopic;
    }

    public void setStringTopic(String stringTopic) {
        this.stringTopic = stringTopic;
    }

    public String getStringTask() {
        return stringTask;
    }

    public void setStringTask(String stringTask) {
        this.stringTask = stringTask;
    }

    public Integer getIntegerNumberAnswer() {
        return integerNumberAnswer;
    }

    public void setIntegerNumberAnswer(Integer integerNumberAnswer) {
        this.integerNumberAnswer = integerNumberAnswer;
    }

    public Integer getIntegerTrueAnswer() {
        return integerTrueAnswer;
    }

    public void setIntegerTrueAnswer(Integer integerTrueAnswer) {
        this.integerTrueAnswer = integerTrueAnswer;
    }

    public ImageView getMasImageViewAnswer() {
        return masImageViewAnswer;
    }

    public void setMasImageViewAnswer(ImageView masImageViewAnswer) {
        this.masImageViewAnswer = masImageViewAnswer;
    }

    public String getStringMeshFilename() {
        return stringMeshFilename;
    }

    public void setStringMeshFilename(String stringMeshFilename) {
        this.stringMeshFilename = stringMeshFilename;
    }
}
