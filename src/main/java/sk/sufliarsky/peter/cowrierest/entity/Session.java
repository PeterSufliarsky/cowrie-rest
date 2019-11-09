package sk.sufliarsky.peter.cowrierest.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name = "starttime", nullable = false)
    LocalDateTime startTime;

    @Column(name = "endtime")
    LocalDateTime endTime;

    @ManyToOne()
    @JoinColumn(name = "sensor", nullable = false)
    Sensor sensor;

    @Column(name = "ip", nullable = false)
    String ip;

    @Column(name = "termsize")
    String termSize;

    @ManyToOne()
    @JoinColumn(name="client")
    Client client;

    protected Session() {}

    public Session(
            LocalDateTime startTime,
            LocalDateTime endTime,
            Sensor sensor,
            String ip,
            String termSize,
            Client client) {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTermSize() {
        return termSize;
    }

    public void setTermSize(String termSize) {
        this.termSize = termSize;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}