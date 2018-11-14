package ru.bur.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bur.domain.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {
}
