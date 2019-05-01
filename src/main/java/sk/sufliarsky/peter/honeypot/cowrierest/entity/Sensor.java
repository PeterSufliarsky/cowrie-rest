package sk.sufliarsky.peter.honeypot.cowrierest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensors")
public class Sensor {

    @Id
    Long id;
    String ip;
}
