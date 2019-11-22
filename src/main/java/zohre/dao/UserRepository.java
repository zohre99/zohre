package zohre.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zohre.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
