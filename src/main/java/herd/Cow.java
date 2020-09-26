package herd;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
 public class Cow {

    private @Id @GeneratedValue Long id;
    private Integer cowNumber;
    private String collarId;
    private String status;

    public Cow() {}

    public Cow(Integer cowNumber, String collarId, String status) {
        super();
        this.cowNumber = cowNumber;
        this.collarId = collarId;
        this.status = status;
    }

    public String getCollarId() {
        return collarId;
    }

    public void setCollarId(String collarId) {
        this.collarId = collarId;
    }

    public Integer getCowNumber() {
        return cowNumber;
    }

    public void setCowNumber(Integer cowNumber) {
        this.cowNumber = cowNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}

