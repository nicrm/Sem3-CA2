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
    
    Person getPerson(int ID);
    Person addPerson(Person person);
    public List<Person> getAllPersons();
    List<Person> getPersonsFromZipcode(int zipcode);
    Person editPerson(Person person, long id);
    boolean deletePerson(long id);
    
    CityInfo getCityInfo(int Zipecode);
    
    public InfoEntity addInfoEntity(InfoEntity infoEntity);
    public InfoEntity editInfoEntity(InfoEntity infoEntity);
    public InfoEntity deleteInfoEntity(int infoEntityId);
    
//    List<Person> getPersons();
//    Person GetPersonInfoTlf(String tlf);
//    
//    List<Person> PeopleWithHobby(String hobby);
//    int HobbyCount(String hobby);
//    List<Integer> AllZips(CityInfo ci);
//    

//    
//    public Person getPersonById(int personId);
//    public List<Person> getPersonsByHobby(String hobby);
}
