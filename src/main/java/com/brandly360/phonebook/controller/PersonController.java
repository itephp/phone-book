package com.brandly360.phonebook.controller;

import com.brandly360.phonebook.dto.PersonDTO;
import com.brandly360.phonebook.entity.Person;
import com.brandly360.phonebook.exception.PersonNotFoundException;
import com.brandly360.phonebook.service.IPersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/persons")
public class PersonController {

  private final IPersonService personService;

  public PersonController(IPersonService personService) {
    this.personService = personService;
  }

  @GetMapping("")
  public List<Person> findAll() {
    return personService.findAll();
  }

  @GetMapping("/{name}")
  public Person get(@PathParam("name") String name) throws PersonNotFoundException {
    return personService.getByName(name);
  }

  @PostMapping("")
  public Map<String, Object> add(@RequestBody PersonDTO personDTO) {
    var entity = personService.add(personDTO);

    Map<String, Object> result = new HashMap<>();
    result.put("id", entity.getId());
    result.put("name", entity.getName());
    result.put("phone", entity.getPhone());
    result.put("group", entity.getGroup().getName());

    return result;
  }

  @PostMapping("/{name}")
  public void remove(@PathVariable String name) {
    personService.remove(name);
  }

}
