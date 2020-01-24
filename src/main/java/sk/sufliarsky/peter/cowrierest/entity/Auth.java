package sk.sufliarsky.peter.cowrierest.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session")
    String session;

    @Column(name="success")
    Boolean success;

    @Column(name="username")
    String username;

    @Column(name="password")
    String password;

    @Column(name="timestamp")
    LocalDateTime timestamp;

    protected Auth() {}

    public Auth(Boolean success, String usrername, String password, LocalDateTime timestamp) {}

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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
