package ru.mikhail.katya.lab1.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString(callSuper = true)
public class Pdf extends Document {

    public Pdf(String name, String content) {
        super(name, content);
    }

}
