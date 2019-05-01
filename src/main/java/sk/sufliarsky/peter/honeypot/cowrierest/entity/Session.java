package sk.sufliarsky.peter.honeypot.cowrierest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="sessions")
public class Session {

    @Id
    String id;

    @Column(name="starttime")
    LocalDateTime startTime;

    @Column(name="endtime")
    LocalDateTime endTime;

    // Sensor sensor;

    @Column(name="ip")
    String ip;

    @Column(name="termsize")
    String termSize;

    // Client client;

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
/*
    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
*/
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
/*
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
 */
}