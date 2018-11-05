package ru.bur.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bur.domain.Meeting;

/**
 * Created by Alexander Ushakov on 05.11.2018.
 */

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {
}
