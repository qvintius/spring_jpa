package mainpackage.repositories;

import mainpackage.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepo extends JpaRepository<Person, Integer> {

}
