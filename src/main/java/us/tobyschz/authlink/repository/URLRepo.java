package us.tobyschz.authlink.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.tobyschz.authlink.model.URLEntity;
import us.tobyschz.authlink.model.UserEntity;

import java.util.List;

@Repository
public interface URLRepo extends CrudRepository<URLEntity, Integer> {

    @Query
    List<URLEntity> findURLEntitiesByCreator(String creator);
    @Query
    List<URLEntity> findURLEntitiesByFullURL(String fullURL);
    @Query
    URLEntity findURLEntityById(Long id);
}
