package sk.sufliarsky.peter.cowrierest.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sk.sufliarsky.peter.cowrierest.serializer.UnpackedTTYLogSerializer;

@JsonSerialize(using=UnpackedTTYLogSerializer.class)
public class UnpackedTTYLog {
    private String hash;
    private int op;
    private int tty;
    private int length;
    private int dir;
    private int sec;
    private int usec;
    private String data;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getTty() {
        return tty;
    }

    public void setTty(int tty) {
        this.tty = tty;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getUsec() {
        return usec;
    }

    public void setUsec(int usec) {
        this.usec = usec;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
