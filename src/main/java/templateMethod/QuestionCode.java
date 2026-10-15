package templateMethod;

import visitor.Visitor;

import java.util.List;

public class QuestionCode extends Question {
    private String motCleAttendu;

    public QuestionCode(String enonce, double pointsMax, String motCleAttendu) {
        super(enonce, pointsMax);
        this.motCleAttendu = motCleAttendu.toLowerCase();
    }

    @Override
    protected double calculerPoints(String reponse) {
        if (reponse.contains(motCleAttendu)) {
            return pointsMax;
        }
        return 0.0;
    }

    @Override
    public void accept(Visitor v) {
        v.visitQuestionCode(this);
    }
}
