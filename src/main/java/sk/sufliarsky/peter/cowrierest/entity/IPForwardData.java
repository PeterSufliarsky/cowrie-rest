package sk.sufliarsky.peter.cowrierest.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ipforwardsdata")
public class IPForwardData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session")
    String session;

    @Column(name="timestamp")
    LocalDateTime timestamp;

    @Column(name="dst_ip")
    String dstIp;

    @Column(name="dst_port")
    Integer dstPort;

    @Column(name="data")
    String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public Integer getDstPort() {
        return dstPort;
    }

    public void setDstPort(Integer dstPort) {
        this.dstPort = dstPort;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
