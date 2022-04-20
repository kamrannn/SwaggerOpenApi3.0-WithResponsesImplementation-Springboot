package edu.leicester.co2103.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Module {

    @Id
    private String code;
    private String title;
    private int level;
    private boolean optional;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "module")
    private List<Session> sessions;

    public Module() {
        sessions = new ArrayList<Session>();
    }

    public Module(String code, String title, int level, boolean optional) {
        this(code, title, level, optional, new ArrayList<>());
    }

    public Module(String code, String title, int level, boolean optional, List<Session> sessions) {
        this.code = code;
        this.title = title;
        this.level = level;
        this.optional = optional;
        this.sessions = sessions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
