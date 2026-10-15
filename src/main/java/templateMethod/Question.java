package templateMethod;

import core.ComposantExamen;

public abstract class Question implements ComposantExamen {

    protected String enonce;
    protected double pointsMax;
    protected double scoreObtenu = 0.0;
    protected String reponseSaisie = "";

    public Question(String enonce, double pointsMax) {
        this.enonce = enonce;
        this.pointsMax = pointsMax;
    }

    public final void validerReponse(String reponse) {
        this.reponseSaisie = nettoyerEntree(reponse);
        this.scoreObtenu = calculerPoints(this.reponseSaisie);
        archiverResultat();
    }

    protected abstract double calculerPoints(String reponse);

    private String nettoyerEntree(String reponse) {
        return reponse != null ? reponse.trim().toLowerCase() : "";
    }

    private void archiverResultat() {
        System.out.println("[Log] Reponse enregistree: " + reponseSaisie + " | Score: " + scoreObtenu);
    }

    @Override
    public double getScore() {
        return scoreObtenu;
    }

    public String getEnonce() {
        return enonce;
    }

    public String getReponseSaisie() {
        return reponseSaisie;
    }
}
