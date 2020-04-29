package ru.mikhail.katya.lab1.factories;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.mikhail.katya.lab1.pojo.DocumentProxy;
import ru.mikhail.katya.lab1.pojo.Pdf;

// Паттерн: Фабрика и Одиночка
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdfTestFactory implements DocumentFactory {

    private static volatile PdfTestFactory instance;

    public DocumentProxy getDocument() {
        return DocumentProxy.of(new Pdf("pdf-name", "pdf-content"));
    }

    public static PdfTestFactory getInstance() {
        PdfTestFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (PdfTestFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = instance = new PdfTestFactory();
                }
            }
        }
        return localInstance;
    }

}
