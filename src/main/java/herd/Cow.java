package herd;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
 class Cow {


    private @Id @GeneratedValue Long id;
    private Integer cowNumber;
    private Long collarId;
    private String status;

    Cow() {}

    Cow(Integer cowNumber, Long collarId, String status) {
        this.cowNumber = cowNumber;
        this.collarId = collarId;
        this.status = status;
    }


}
