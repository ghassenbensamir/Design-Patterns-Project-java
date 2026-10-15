package factory;

import templateMethod.Question;
import templateMethod.QuestionCode;

public class CodeQuestionFactory implements QuestionFactory {
    @Override
    public Question createQuestion(String enonce, double pointsMax, String expectedValue) {
        return new QuestionCode(enonce, pointsMax, expectedValue);
    }
}
