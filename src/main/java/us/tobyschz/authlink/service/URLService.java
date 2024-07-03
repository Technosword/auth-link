package us.tobyschz.authlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.tobyschz.authlink.common.ShortenerUtil;
import us.tobyschz.authlink.exception.URLNotFoundException;
import us.tobyschz.authlink.model.URLEntity;
import us.tobyschz.authlink.repository.URLRepo;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class URLService {

    private final URLRepo urlRepo;

    @Autowired
    public URLService(URLRepo urlRepo) { //todo: implement user repo
        this.urlRepo = urlRepo;
    }

    /**
     * Creates and inserts shortened url into database (assumes that no other exists)
     * @param fullLink The full link to be shortened
     * @param creator The creator of the shortened link todo: change this to an id and link repos
     * @return String of the shortened url
     */
    public String createShortURL(String fullLink, String creator) {
        //todo: do url validation to prevent errors
        URLEntity urlEntity = new URLEntity(fullLink, creator);

        URLEntity saved = urlRepo.save(urlEntity);

        return ShortenerUtil.idToStr(saved.getId());
    }

    public URI getLongURI(String shortLink) throws URLNotFoundException, URISyntaxException {
        URLEntity found = urlRepo.findURLEntityById(ShortenerUtil.strToId(shortLink));
        if (found == null) throw new URLNotFoundException(String.format("Could not find full url for short %s", shortLink), new Throwable());

        return new URI(found.getFullURL());
    }


}
