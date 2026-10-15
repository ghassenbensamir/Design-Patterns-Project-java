package observer;

import core.Session;

public class Certificat implements Subscriber{
    @Override
    public void update(Session s) {
        double scoreFinal = s.getExamen().getRacine().getScore();
        System.out.println("\n=== GENERATION DU CERTIFICAT ===");
        if (scoreFinal >= 10.0) {
            System.out.println("Felicitation ! Diplome genere pour " + s.getExamen().getTitre() + " avec la note: " + scoreFinal);
        } else {
            System.out.println("Echec. Score insuffisant (" + scoreFinal + ") pour obtenir le certificat.");
        }
    }
}
