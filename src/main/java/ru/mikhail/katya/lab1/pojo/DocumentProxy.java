package ru.mikhail.katya.lab1.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Stack;

// Паттерн: Заместитель
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentProxy {

    private Document document;
    private final Stack<Document> documentPrevVersions;

    // Паттерн: Фабричный метод
    public static DocumentProxy of(@NonNull Document document) {
        return new DocumentProxy(
                document,
                new Stack<>() {{
                    add(document);
                }}
        );
    }

    public String getContent() {
        return document.getContent();
    }

    public String getName() {
        return document.getName();
    }

    public void setContent(String string) {
        documentPrevVersions.add(document.clone());
        document.setContent(string);
    }

    public void setName(String string) {
        documentPrevVersions.add(document.clone());
        document.setName(string);
    }

    public void undo() {
        document = documentPrevVersions.pop();
    }

    public Document getDocument() {
        return document;
    }

    @Override
    public String toString() {
        return document.toString();
    }
}
