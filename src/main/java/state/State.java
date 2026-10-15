package state;

import core.Session;
import templateMethod.Question;

public interface State {
    void soumettreReponse(Session s, Question q, String reponse);
    void terminer(Session s);
}
