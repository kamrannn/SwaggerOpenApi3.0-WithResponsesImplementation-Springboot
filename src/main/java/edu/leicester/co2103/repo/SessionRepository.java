package edu.leicester.co2103.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import edu.leicester.co2103.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
