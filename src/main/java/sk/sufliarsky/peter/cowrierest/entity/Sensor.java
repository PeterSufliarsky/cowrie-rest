package sk.sufliarsky.peter.cowrierest.entity;

import javax.persistence.*;

@Entity
@Table(name="sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="ip", nullable = false)
    String ip;

    protected Sensor() {}

    public Sensor(String ip) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setId(String ip) {
        this.ip = ip;
    }

}
