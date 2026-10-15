package decorator;

import core.ComposantExamen;

public class DecoratorIndice extends QuestionDecorator{
    private double penaliteIndice;
    private boolean indiceUtilise = false;

    public DecoratorIndice(ComposantExamen wrappee, double penaliteIndice) {
        super(wrappee);
        this.penaliteIndice = penaliteIndice;
    }

    public void utiliserIndice() {
        this.indiceUtilise = true;
    }

    @Override
    public double getScore() {
        double scoreBase = super.getScore();
        if (indiceUtilise && scoreBase > 0) {
            return Math.max(0, scoreBase - penaliteIndice);
        }
        return scoreBase;
    }
}
