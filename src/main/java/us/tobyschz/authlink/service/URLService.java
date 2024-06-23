package us.tobyschz.authlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.tobyschz.authlink.common.ShortenerUtil;
import us.tobyschz.authlink.model.URLEntity;
import us.tobyschz.authlink.repository.URLRepo;

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
        URLEntity urlEntity = new URLEntity(fullLink, creator);

        URLEntity saved = urlRepo.save(urlEntity);

        return ShortenerUtil.idToStr(saved.getId());
    }


}
