package core;

import command.CommandHistory;
import observer.Subscriber;
import state.EnCours;
import state.State;
import templateMethod.Question;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private Examen examen;
    private State etatCourant;
    private List<Subscriber> abonnes = new ArrayList<>();
    private CommandHistory historique = new CommandHistory();

    public Session(Examen examen) {
        this.examen = examen;
        this.etatCourant = new EnCours();
    }

    public void setEtat(State etat) {
        this.etatCourant = etat;
    }

    public void soumettreReponse(Question q, String reponse) {
        etatCourant.soumettreReponse(this, q, reponse);
    }

    public void terminer() {
        etatCourant.terminer(this);
        notifySubscribers();
    }

    public void subscribe(Subscriber s) {
        abonnes.add(s);
    }

    private void notifySubscribers() {
        for (Subscriber s : abonnes) {
            s.update(this);
        }
    }

    public CommandHistory getHistorique() {
        return historique;
    }

    public Examen getExamen() {
        return examen;
    }
}
