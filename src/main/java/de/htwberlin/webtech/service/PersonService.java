package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.PersonEntity;
import de.htwberlin.webtech.persistence.PersonRespository;
import de.htwberlin.webtech.web.api.api.Person;
import de.htwberlin.webtech.web.api.api.PersonManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRespository personRespository;

    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public List<Person> findAll(){
        List<PersonEntity> persons = personRespository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person create(PersonManipulationRequest request){
        var personEntity = new PersonEntity(request.getFirstName(), request.getLastName(), request.getDate(), request.getTime());
        personEntity = personRespository.save(personEntity);
        return transformEntity(personEntity);
    }


    public Person update(Long id, PersonManipulationRequest request){
        var personEntityOptional = personRespository.findById(id);
        if (personEntityOptional.isEmpty()){
            return null;
        }

        var personEntity = personEntityOptional.get();
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setDate(request.getDate());
        personEntity.setTime(request.getTime());
        personEntity = personRespository.save(personEntity);

        return transformEntity(personEntity);
    }


    public Person findById(Long id){
        var personEntity = personRespository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }


    public boolean deleteById(Long id){
        if (!personRespository.existsById(id)){
            return false;
        }

        personRespository.deleteById(id);
        return true;
    }
    private Person transformEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getDate(),
                personEntity.getTime()
        );
    }

    public boolean deleteByFirstAndLastName(String firstName, String lastName) {
        var personEntityOptional = personRespository.findAllByFirstName(firstName)
                .stream()
                .filter(person -> person.getLastName().equals(lastName))
                .findFirst();

        if (personEntityOptional.isEmpty()) {
            return false;
        }

        var personEntity = personEntityOptional.get();
        personRespository.delete(personEntity);
        return true;
    }


}
