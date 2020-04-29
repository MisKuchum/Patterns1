package ru.mikhail.katya.lab1;

import ru.mikhail.katya.lab1.factories.PdfTestFactory;
import ru.mikhail.katya.lab1.pojo.DocumentProxy;

public class App implements Runnable {

    private final PdfTestFactory pdfTestFactory;

    @Override
    public void run() {
        final DocumentProxy document = pdfTestFactory.getDocument();
        System.out.println(document);
        document.setName("PDF");
        document.setContent("new content");
        System.out.println(document);
        document.undo();
        System.out.println(document);
    }

    private App() {
        pdfTestFactory = PdfTestFactory.getInstance();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
