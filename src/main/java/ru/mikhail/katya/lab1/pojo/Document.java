package ru.mikhail.katya.lab1.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Document implements Cloneable {

    protected String name;
    protected String content;

    @Override
    @SneakyThrows
    public Document clone() {
        return (Document) super.clone();
    }
}
