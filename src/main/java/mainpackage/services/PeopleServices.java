package mainpackage.services;

import mainpackage.models.Person;
import mainpackage.repositories.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleServices {
    private final PeopleRepo peopleRepo;

    @Autowired
    public PeopleServices(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public List<Person> findAll(){
        return peopleRepo.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundedPerson = peopleRepo.findById(id);
        return foundedPerson.orElse(null);
    }

    @Transactional
    public void save(Person person){
        peopleRepo.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepo.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepo.deleteById(id);
    }




}
