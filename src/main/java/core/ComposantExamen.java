package core;

import visitor.Visitor;

public interface ComposantExamen {
    double getScore();
    void accept(Visitor v);
}
