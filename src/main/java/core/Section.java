package core;

import strategy.ScoreStrategy;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Section implements ComposantExamen {
    private String titre;
    private List<ComposantExamen> enfants = new ArrayList<>();
    private ScoreStrategy strategy;

    public Section(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void add(ComposantExamen c) {
        enfants.add(c);
    }

    public void remove(ComposantExamen c) {
        enfants.remove(c);
    }

    public void setStrategy(ScoreStrategy strategy) {
        this.strategy = strategy;
    }

    public double applyStrategy() {
        if (strategy != null) {
            return strategy.applyStrategy(getScore());
        }
        return getScore();
    }

    @Override
    public double getScore() {
        double total = 0;
        for (ComposantExamen c : enfants) {
            total += c.getScore();
        }
        return total;
    }

    @Override
    public void accept(Visitor v) {
        v.visitSection(this);
        for (ComposantExamen c : enfants) {
            c.accept(v);
        }
    }
}
