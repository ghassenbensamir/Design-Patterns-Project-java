package observer;

import core.Session;
import visitor.StatsVisitor;

import java.util.Observable;
import java.util.Observer;

public class Dashboard implements Subscriber {

    @Override
    public void update(Session s) {
        System.out.println("\n=== DASHBOARD MISE A JOUR ===");
        StatsVisitor stats = new StatsVisitor();
        s.getExamen().getRacine().accept(stats);
        stats.genererRapport();
    }


}
