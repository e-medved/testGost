package com.gostgroup.test.rest;

import com.gostgroup.test.model.UsersEntity;
import com.gostgroup.test.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by root on 1/25/17.
 */
@RestController
public class UsersController {

  @Autowired
  UsersRepository usersRepository;

  @RequestMapping(value = "/users/", method = RequestMethod.GET)
  public ResponseEntity<Iterable<UsersEntity>> getUsersList(){

    Iterable<UsersEntity> users = usersRepository.findAll();

    if (users.iterator().hasNext()) {
      return new ResponseEntity<Iterable<UsersEntity>>(users, HttpStatus.OK);
    }
    else {
      return new ResponseEntity<Iterable<UsersEntity>>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public ResponseEntity<UsersEntity> getUser(@PathVariable("id") int id){

    UsersEntity user = usersRepository.findOne(id);
    if (user != null) {
      return new ResponseEntity<UsersEntity>(user, HttpStatus.OK);
    }
    else {
      return new ResponseEntity<UsersEntity>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "/users/", method = RequestMethod.POST)
  public ResponseEntity createUser(@Valid @RequestBody UsersEntity user, Errors errors){

    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
    } else {
      usersRepository.save(user);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
  public ResponseEntity updateUser(@PathVariable("id") int id, @Valid @RequestBody UsersEntity user,
                                                Errors errors){

    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
    } else {
      UsersEntity currentUser = usersRepository.findOne(id);
      if (currentUser == null)
        return ResponseEntity.notFound().build();

      currentUser.setLogin(user.getLogin());
      currentUser.setName(user.getName());
      currentUser.setPassword(user.getPassword());
      currentUser.setUserRoles(user.getUserRoles());
      usersRepository.save(currentUser);

      return ResponseEntity.ok().build();
    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<UsersEntity> deleteUser(@PathVariable("id") int id){

    if (usersRepository.findOne(id) == null)
      return new ResponseEntity<UsersEntity>(HttpStatus.NOT_FOUND);

    usersRepository.delete(id);

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

}
