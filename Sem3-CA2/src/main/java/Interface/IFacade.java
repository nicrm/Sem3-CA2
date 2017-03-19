/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.InfoEntity;
import entities.Person;
import entities.Phone;
import java.util.List;

/**
 *
 * @author Nicolai
 */
public interface IFacade {
    
    Person addPerson(Person person);
    Person addHobbyToPerson(Hobby hobby, long id);
    Hobby addHobby(Hobby hobby);
    Person addPhoneToPerson(Phone phone, long id);
    Person addAddressToPerson(Address address, long id);
    boolean deletePerson(long id);
    Person editPerson(Person person, long id);
    Person getPerson(long id);
    List<Person> getPersons();
    Person GetPersonInfoTlf(String tlf);
    List<Person> getPersonsFromZipcode(int zip);
    List<Person> PeopleWithHobby(String hobby);
    int HobbyCount(String hobby);
    List<Integer> AllZips(CityInfo ci);
    
    public InfoEntity addInfoEntity(InfoEntity infoEntity);
    public InfoEntity editInfoEntity(InfoEntity infoEntity);
    public InfoEntity deleteInfoEntity(int infoEntityId);
    
    public List<Person> getAllPersons();
    public Person getPersonById(int personId);
    public List<Person> getPersonsByHobby(String hobby);
}
