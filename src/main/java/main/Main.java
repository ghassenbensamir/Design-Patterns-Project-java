package main;

import adapter.OldXmlParser;
import adapter.XmlQuestionAdapter;
import command.Command;
import command.RepondreCommand;
import core.ComposantExamen;
import core.Examen;
import core.Section;
import core.Session;
import decorator.DecoratorIndice;
import decorator.DecoratorTimer;
import factory.CodeQuestionFactory;
import factory.QcmFactory;
import factory.QuestionFactory;
import observer.Certificat;
import observer.Dashboard;
import strategy.Penalite;
import templateMethod.Question;
import visitor.PdfVisitor;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        QuestionFactory qcmFactory = new QcmFactory();
        QuestionFactory codeFactory = new CodeQuestionFactory();

        Question q1 = qcmFactory.createQuestion("Java est-il oriente objet ? (oui/non)", 5.0, "oui");
        Question q2 = codeFactory.createQuestion("Ecrivez une boucle for infinie", 10.0, "for(;;)");

        DecoratorIndice q2AvecIndice = new DecoratorIndice(new DecoratorTimer(q2,5), 2.0);

        OldXmlParser parser = new OldXmlParser();
        ComposantExamen qLegacy = new XmlQuestionAdapter(parser);

        Section sectionJava = new Section("Programmation Java");
        sectionJava.add(q1);
        sectionJava.add(q2AvecIndice);

        Section sectionData = new Section("Bases de Donnees Legacy");
        sectionData.add(qLegacy);
        sectionData.setStrategy(new Penalite(1.0));

        Section examenRacine = new Section("Examen Racine");
        examenRacine.add(sectionJava);
        examenRacine.add(sectionData);

        Examen examen = new Examen("Certification Java Expert", new Date(), examenRacine);
        Session session = examen.demarrer();

        session.subscribe(new Dashboard());
        session.subscribe(new Certificat());

        System.out.println("DEBUT DE L'EXAMEN ");

        Command cmd1 = new RepondreCommand(q1, "oui");
        cmd1.execute();
        session.getHistorique().push(cmd1);

        q2AvecIndice.utiliserIndice();
        Command cmd2 = new RepondreCommand(q2, "for(;;)");
        cmd2.execute();
        session.getHistorique().push(cmd2);

        System.out.println("\nEtudiant change d'avis sur Q1...");
        Command derniereAction = session.getHistorique().pop();
        derniereAction = session.getHistorique().pop();
        if (derniereAction != null) {
            derniereAction.undo();
        }

        PdfVisitor pdf = new PdfVisitor();
        examen.getRacine().accept(pdf);
        pdf.export();

        session.terminer();
    }
}
