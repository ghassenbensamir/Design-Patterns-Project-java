package templateMethod;

import visitor.Visitor;

import java.util.List;

public class QuestionQcm extends Question {
    private String reponseCorrecte;

    public QuestionQcm(String enonce, double pointsMax, String reponseCorrecte) {
        super(enonce, pointsMax);
        this.reponseCorrecte = reponseCorrecte.toLowerCase();
    }

    @Override
    protected double calculerPoints(String reponse) {
        if (reponse.equals(reponseCorrecte)) {
            return pointsMax;
        }
        return 0.0;
    }

    @Override
    public void accept(Visitor v) {
        v.visitQuestionQcm(this);
    }
}
