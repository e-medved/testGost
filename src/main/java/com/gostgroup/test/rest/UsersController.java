package com.gostgroup.test.rest;

import com.gostgroup.test.model.UsersEntity;
import com.gostgroup.test.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    if (users != null) {
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
  public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity user){

    if (usersRepository.exists(user.getId()))
      return new ResponseEntity<UsersEntity>(HttpStatus.CONFLICT);

    usersRepository.save(user);
    return new ResponseEntity<UsersEntity>(HttpStatus.CREATED);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
  public ResponseEntity<UsersEntity> updateUser(@PathVariable("id") int id, @RequestBody UsersEntity user){

    UsersEntity currentUser = usersRepository.findOne(id);
    if (currentUser == null)
      return new ResponseEntity<UsersEntity>(HttpStatus.NOT_FOUND);

    currentUser.setLogin(user.getLogin());
    currentUser.setName(user.getName());
    currentUser.setPassword(user.getPassword());
    usersRepository.save(currentUser);

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<UsersEntity> deleteUser(@PathVariable("id") int id){

    if (usersRepository.findOne(id) == null)
      return new ResponseEntity<UsersEntity>(HttpStatus.NOT_FOUND);

    usersRepository.delete(id);

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

}
