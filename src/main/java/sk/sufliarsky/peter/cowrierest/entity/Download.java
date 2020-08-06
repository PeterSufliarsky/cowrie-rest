package sk.sufliarsky.peter.cowrierest.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;
import java.time.LocalDateTime;
import sk.sufliarsky.peter.cowrierest.serializer.DownloadSerializer;

@Entity
@JsonSerialize(using=DownloadSerializer.class)
@Table(name="downloads")
public class Download {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="session")
    String session;

    @Column(name="timestamp")
    LocalDateTime timestamp;

    @Column(name="url")
    String url;

    @Column(name="outfile", nullable=false)
    String outfile;

    @Column(name="shasum", nullable=false)
    String shasum;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOutfile() {
        return outfile;
    }

    public void setOutfile(String outfile) {
        this.outfile = outfile;
    }

    public String getShasum() {
        return shasum;
    }

    public void setShasum(String shasum) {
        this.shasum = shasum;
    }
}
