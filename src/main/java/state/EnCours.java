package state;

import core.Session;
import templateMethod.Question;

public class EnCours implements State{

    @Override
    public void soumettreReponse(Session s, Question q, String reponse) {
        q.validerReponse(reponse);
    }

    @Override
    public void terminer(Session s) {
        s.setEtat(new Terminer());
    }
}
