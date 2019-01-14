package ru.bur.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.bur.domain.Meeting;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */

@RepositoryRestResource
public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
