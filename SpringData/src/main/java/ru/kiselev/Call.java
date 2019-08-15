package ru.kiselev;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;


@lombok.Getter
@lombok.Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Call {
    @Id
    private String id;
    private Integer caller_id;
    private Integer receiver_id;
    private String date;

    public Call(Integer caller_id, Integer receiver_id, String date) {
        this.caller_id = caller_id;
        this.receiver_id = receiver_id;
        this.date = date;
    }
}
