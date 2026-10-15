package decorator;

import core.ComposantExamen;

public class DecoratorTimer extends QuestionDecorator{
    private int tempsLimiteSecondes;

    public DecoratorTimer(ComposantExamen wrappee, int tempsLimiteSecondes) {
        super(wrappee);
        this.tempsLimiteSecondes = tempsLimiteSecondes;
    }

    @Override
    public double getScore() {
        return super.getScore();
    }
}
