package state;

import core.Session;
import templateMethod.Question;

public class Terminer implements State {
    @Override
    public void soumettreReponse(Session s, Question q, String reponse) {
        System.out.println("Erreur: L'examen est termine. Reponse ignoree.");
    }

    @Override
    public void terminer(Session s) {
        System.out.println("L'examen est deja termine.");
    }
}
