package strategy;

public class Classique implements ScoreStrategy{
    @Override
    public double applyStrategy(double scoreBase) {
        return scoreBase;
    }
}
