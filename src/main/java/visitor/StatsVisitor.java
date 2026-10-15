package visitor;

import core.Section;
import templateMethod.QuestionCode;
import templateMethod.QuestionQcm;

import java.util.HashMap;
import java.util.Map;

public class StatsVisitor implements Visitor {
    private int totalQuestions = 0;
    private double scoreCumule = 0.0;

    @Override
    public void visitSection(Section s) {
    }

    @Override
    public void visitQuestionQcm(QuestionQcm q) {
        totalQuestions++;
        scoreCumule += q.getScore();
    }

    @Override
    public void visitQuestionCode(QuestionCode q) {
        totalQuestions++;
        scoreCumule += q.getScore();
    }

    public void genererRapport() {
        System.out.println("Questions repondues: " + totalQuestions);
        System.out.println("Score actuel total: " + scoreCumule);
    }
}
