package command;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> historique = new Stack<>();

    public void push(Command c) {
        historique.push(c);
    }

    public Command pop() {
        if (!historique.isEmpty()) {
            return historique.pop();
        }
        return null;
    }
}
