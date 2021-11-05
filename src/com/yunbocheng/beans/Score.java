package com.yunbocheng.beans;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.Serializable;

public class Score implements Serializable {

    // 最高分
    private double maxScore;

    // 最低分
    private double minScore;

    // 平均分
    private double avgScore;

    public Score() {
    }

    public Score(double maxScore, double minScore, double avgScore) {
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.avgScore = avgScore;
    }

    public double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(double maxScore) {
        this.maxScore = maxScore;
    }

    public double getMinScore() {
        return minScore;
    }

    public void setMinScore(double minScore) {
        this.minScore = minScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "maxScore=" + maxScore +
                ", minScore=" + minScore +
                ", avgScore=" + avgScore +
                '}';
    }
}
