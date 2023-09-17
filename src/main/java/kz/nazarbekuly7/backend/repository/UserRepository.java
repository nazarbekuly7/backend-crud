package kz.nazarbekuly7.backend.repository;

import kz.nazarbekuly7.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
}
