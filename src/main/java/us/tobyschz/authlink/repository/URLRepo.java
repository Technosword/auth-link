package us.tobyschz.authlink.repository;

import org.springframework.data.repository.CrudRepository;
import us.tobyschz.authlink.model.URLEntity;

public interface URLRepo extends CrudRepository<URLEntity, Integer> {

}
