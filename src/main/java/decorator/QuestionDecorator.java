package decorator;

import core.ComposantExamen;
import visitor.Visitor;

public abstract  class QuestionDecorator implements ComposantExamen {
    protected ComposantExamen wrappee;

    public QuestionDecorator(ComposantExamen wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public double getScore() {
        return wrappee.getScore();
    }

    @Override
    public void accept(Visitor v) {
        wrappee.accept(v);
    }
}
