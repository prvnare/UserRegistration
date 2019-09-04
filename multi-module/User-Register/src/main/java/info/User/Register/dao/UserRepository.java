package info.User.Register.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.User.Register.RestApiConstants;
import info.User.Register.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(@Param(RestApiConstants.USERNAME_PARAM) String username);

    @Query("select u from User u where u.username = :username")
    User findUserForLogin(@Param(RestApiConstants.USERNAME_PARAM) String username);


    @Override
    <S extends User> S save(S entity);

    @Override
    List<User> findAll();

}
