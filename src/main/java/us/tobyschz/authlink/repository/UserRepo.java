package us.tobyschz.authlink.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import us.tobyschz.authlink.model.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {

    @Query
    UserEntity findUserEntityByUsername(String username);


}
