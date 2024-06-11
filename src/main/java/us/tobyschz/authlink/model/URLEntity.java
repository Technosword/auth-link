package us.tobyschz.authlink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name="urls")
public class URLEntity {

    @Id
    private Integer id;
    @Setter
    private String shortURL, fullURL, creator;
    @Setter
    private int uses;

    protected URLEntity() {}

    @Override
    public String toString() {
        return String.format("URL{id: %d, short_url: %s, full_url: %s", id, shortURL, fullURL);
    }

}
