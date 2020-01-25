package sk.sufliarsky.peter.cowrierest.entity;

import javax.persistence.*;

@Entity
@Table(name="ttylog")
public class TTYLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session")
    String session;

    @Column(name="ttylog")
    String ttylog;

    @Column(name="size")
    Integer size;

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

    public String getTtylog() {
        return ttylog;
    }

    public void setTtylog(String ttylog) {
        this.ttylog = ttylog;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
