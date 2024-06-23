package us.tobyschz.authlink.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name="urls")
public class URLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String fullURL, creator;
    @Setter
    private int uses = 0;

    public URLEntity(Long id, String fullUrl, String creator) {
        this.id = id;
        this.fullURL = fullUrl;
        this.creator = creator;
    }

    public URLEntity(String fullUrl, String creator) {
        this.fullURL = fullUrl;
        this.creator = creator;
    }

    protected URLEntity() {}


    @Override
    public String toString() {
        return String.format("URL{id: %d, full_url: %s", id, fullURL);
    }

}
