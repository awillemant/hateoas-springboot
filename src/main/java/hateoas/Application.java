package hateoas;

import hateoas.entity.Conference;
import hateoas.entity.Talk;
import hateoas.repository.ConferenceRepository;
import hateoas.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private TalkRepository talkDAO;

    @Autowired
    private ConferenceRepository conferenceDAO;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) {

        Conference techforum2014 = conferenceDAO.save(new Conference("Techforum 2014", LocalDate.of(2014, 6, 3), LocalDate.of(2014, 6, 4)));
        Conference techforum2015 = conferenceDAO.save(new Conference("Techforum 2015", LocalDate.of(2015, 6, 2), LocalDate.of(2015, 6, 3)));
        Conference devoxxFr2015 = conferenceDAO.save(new Conference("Devoxx France 2015", LocalDate.of(2015, 4, 8), LocalDate.of(2015, 4, 10)));
        Conference devoxx2015 = conferenceDAO.save(new Conference("Devoxx 2015", LocalDate.of(2015, 11, 9), LocalDate.of(2015, 11, 13)));

        talkDAO.save(new Talk("Brian Clozel", "De zéro à héros avec Spring Boot", devoxxFr2015));
        talkDAO.save(new Talk("José Paumard", "Les streams sont parmi nous !", devoxxFr2015));
        talkDAO.save(new Talk("Gaël Métais", "JS : Analyser le code spaghetti d'une page web avec Yellow Lab Tools", devoxxFr2015));
        talkDAO.save(new Talk("Jean-François Arcand", "HTTP/2 : A deux c'est mieux !", devoxxFr2015));
        talkDAO.save(new Talk("Arun Gupta", "DevOps with Java EE", devoxxFr2015));


        talkDAO.save(new Talk("Nicolas Carlier", "Software Craftsmanship", techforum2015));
        talkDAO.save(new Talk("Christophe Cordenier", "Build SOLID applications", techforum2015));
        talkDAO.save(new Talk("Peter Timmermans", "Internet of Things", techforum2015));
        talkDAO.save(new Talk("Amaury Willemant", "HATEOAS : Hypercool APIs", techforum2015));
        talkDAO.save(new Talk("Patrick Tourbier", "Replace your old perl with Java 8 to process a flat file", techforum2015));

        talkDAO.save(new Talk("Angela Ricci", "Making your scripts sing with ARIA", techforum2014));
        talkDAO.save(new Talk("Nicolas Pelloux-Prayer", "Clean Code", techforum2014));
        talkDAO.save(new Talk("Amaury Willemant", "You're not service-oriented enough !", techforum2014));
    }
}
