package factory;

import templateMethod.Question;

public interface QuestionFactory {
    Question createQuestion(String enonce, double pointsMax, String expectedValue);
}
