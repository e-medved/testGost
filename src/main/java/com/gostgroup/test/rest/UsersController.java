package com.gostgroup.test.rest;

import com.gostgroup.test.model.UsersEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 1/25/17.
 */
@RestController
@RequestMapping("/api")
public class UsersController {

  //curl -I http://127.0.0.1:8080/users/1
  @RequestMapping(value = "/users/", method = RequestMethod.GET)
  public ResponseEntity<UsersEntity> getUsersList(){

    int i = 0;
    return new ResponseEntity<UsersEntity>(HttpStatus.OK);

//    UsersEntity user = userService.get(id);
//    if (user != null) {
//      return new ResponseEntity<UsersEntity>(user, HttpStatus.OK);
//    }
//    else {
//      return new ResponseEntity<UsersEntity>(HttpStatus.NOT_FOUND);
//    }
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
  public ResponseEntity<UsersEntity> getUser(@PathVariable("id") long id){

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

  @RequestMapping(value = "/users/", method = RequestMethod.POST)
  public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity user){

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
  public ResponseEntity<UsersEntity> updateUser(@PathVariable("id") long id, @RequestBody UsersEntity user){

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<UsersEntity> deleteUser(@PathVariable("id") long id){

    return new ResponseEntity<UsersEntity>(HttpStatus.OK);
  }

}
