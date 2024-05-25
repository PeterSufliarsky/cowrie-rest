package sk.sufliarsky.peter.cowrierest.entity;

import jakarta.persistence.*;

@Entity
@Table(name="params")
public class Params {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session")
    String session;

    @Column(name="arch")
    String arch;

    protected Params() {}

    public Params(Session session, String arch) {}

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

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }
}
