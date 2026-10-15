package adapter;

import core.ComposantExamen;
import visitor.Visitor;

public class XmlQuestionAdapter implements ComposantExamen {
    private OldXmlParser oldParser;

    public XmlQuestionAdapter(OldXmlParser oldParser) {
        this.oldParser = oldParser;
    }

    @Override
    public double getScore() {
        String xml = oldParser.extraireQuestionV1();
        try {
            int start = xml.indexOf("<score>") + 7;
            int end = xml.indexOf("</score>");
            return Double.parseDouble(xml.substring(start, end));
        } catch (Exception e) {
            return 0.0;
        }
    }

    @Override
    public void accept(Visitor v) {
    }
}