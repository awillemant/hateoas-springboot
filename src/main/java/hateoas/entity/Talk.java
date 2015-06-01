package hateoas.entity;

import javax.persistence.*;

@Entity
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String speakerName;

    private String title;

    @ManyToOne
    private Conference conference;

    public Talk() {
        super();
    }

    public Talk(String speakerName, String title, Conference conference) {
        this.speakerName = speakerName;
        this.title = title;
        this.conference = conference;
    }

    public long getId() {
        return id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
