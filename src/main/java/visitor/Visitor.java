package visitor;

import core.Section;
import templateMethod.QuestionCode;
import templateMethod.QuestionQcm;

public interface Visitor {
    void visitSection(Section s);
    void visitQuestionQcm(QuestionQcm q);
    void visitQuestionCode(QuestionCode q);
}
