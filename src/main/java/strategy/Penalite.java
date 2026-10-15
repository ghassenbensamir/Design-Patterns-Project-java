package strategy;

public class Penalite implements ScoreStrategy{
    private double valeurMalus;

    public Penalite(double valeurMalus) {
        this.valeurMalus = valeurMalus;
    }

    @Override
    public double applyStrategy(double scoreBase) {
        return Math.max(0, scoreBase - valeurMalus);
    }
}
