package spring.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "temperature")
public class Temperature {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "temp_Id")
    private int tempId;

    @Basic
    @Column(name = "temp_value")
    private int tempValue;

    public int getTempId() {
        return tempId;
    }

    public void setTempId(int tempId) {
        this.tempId = tempId;
    }

    public int getTempValue() {
        return tempValue;
    }

    public void setTempValue(int tempValue) {
        this.tempValue = tempValue;
    }

}


