package sk.sufliarsky.peter.cowrierest.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sk.sufliarsky.peter.cowrierest.serializer.InputSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonSerialize(using=InputSerializer.class)
@Table(name="input")
public class Input {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session", nullable=false)
    String session;

    @Column(name="timestamp", nullable=false)
    LocalDateTime timestamp;

    @Column(name="realm")
    String realm;

    @Column(name="success")
    Boolean success;

    @Column(name="input", nullable=false)
    String input;

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

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
