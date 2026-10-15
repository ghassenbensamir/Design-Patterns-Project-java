package factory;

import templateMethod.Question;
import templateMethod.QuestionQcm;

public class QcmFactory implements QuestionFactory {
    @Override
    public Question createQuestion(String enonce, double pointsMax, String expectedValue) {
        return new QuestionQcm(enonce, pointsMax, expectedValue);
    }
}
