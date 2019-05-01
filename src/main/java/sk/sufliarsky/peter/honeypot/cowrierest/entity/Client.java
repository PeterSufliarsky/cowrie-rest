package sk.sufliarsky.peter.honeypot.cowrierest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {

    @Id
    Long id;
    String version;

}
