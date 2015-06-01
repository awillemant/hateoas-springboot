package hateoas.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Talk> talks;

    public Conference() {
        super();
        this.talks = new ArrayList<>();
    }

    public Conference(String name, LocalDate startDate, LocalDate endDate) {
        this();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public boolean isPast() {
        return endDate.isBefore(LocalDate.now());
    }
}
