package command;

import templateMethod.Question;

public class MarquerCommand implements Command {
    private Question questionCible;
    private boolean etaitMarquee;

    public MarquerCommand(Question questionCible, boolean etaitMarquee) {
        this.questionCible = questionCible;
        this.etaitMarquee = etaitMarquee;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
