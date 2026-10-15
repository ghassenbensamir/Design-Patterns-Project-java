package core;

import java.util.Date;

public class Examen {

    private String titre;
    private Date datePassage;
    private Section racine;

    public Examen(String titre, Date datePassage, Section racine) {
        this.titre = titre;
        this.datePassage = datePassage;
        this.racine = racine;
    }

    public Session demarrer() {
        return new Session(this);
    }

    public Section getRacine() {
        return racine;
    }

    public String getTitre() {
        return titre;
    }
}
