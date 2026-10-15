package command;

import templateMethod.Question;

public class RepondreCommand implements Command {
    private Question questionCible;
    private String ancienneReponse;
    private String nouvelleReponse;

    public RepondreCommand(Question questionCible, String nouvelleReponse) {
        this.questionCible = questionCible;
        this.ancienneReponse = questionCible.getReponseSaisie();
        this.nouvelleReponse = nouvelleReponse;
    }

    @Override
    public void execute() {
        questionCible.validerReponse(nouvelleReponse);
    }

    @Override
    public void undo() {
        System.out.println("[Undo] Annulation de la reponse '" + nouvelleReponse + "', restauration de '" + ancienneReponse + "'");
        questionCible.validerReponse(ancienneReponse);
    }
}
