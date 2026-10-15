package visitor;

import core.Section;
import templateMethod.QuestionCode;
import templateMethod.QuestionQcm;

import java.io.File;

public class PdfVisitor implements Visitor {
    private StringBuilder document = new StringBuilder();

    @Override
    public void visitSection(Section s) {
        document.append("\n--- SECTION: ").append(s.getTitre()).append(" ---\n");
    }

    @Override
    public void visitQuestionQcm(QuestionQcm q) {
        document.append("[QCM] ").append(q.getEnonce()).append("\n");
    }

    @Override
    public void visitQuestionCode(QuestionCode q) {
        document.append("[CODE] ").append(q.getEnonce()).append("\n");
    }

    public void export() {
        System.out.println("\n=== EXPORT PDF ===");
        System.out.println(document.toString());
    }
}
