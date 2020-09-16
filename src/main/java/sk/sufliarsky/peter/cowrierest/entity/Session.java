package sk.sufliarsky.peter.cowrierest.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import sk.sufliarsky.peter.cowrierest.serializer.SessionSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonSerialize(using=SessionSerializer.class)
@Table(name="sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Transient
    Integer asnId;

    @Transient
    String asnName;

    @Transient
    String country;

    @Column(name="starttime", nullable = false)
    LocalDateTime startTime;

    @Column(name="endtime")
    LocalDateTime endTime;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sensor", nullable = false)
    Sensor sensor;

    @Column(name="ip", nullable = false)
    String ip;

    @Column(name="termsize")
    String termSize;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="client")
    @NotFound(action = NotFoundAction.IGNORE)
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

    public Integer getAsnId() {
        return asnId;
    }

    public void setAsnId(Integer asnId) {
        this.asnId = asnId;
    }

    public String getAsnName() {
        return asnName;
    }

    public void setAsnName(String asnName) {
        this.asnName = asnName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
