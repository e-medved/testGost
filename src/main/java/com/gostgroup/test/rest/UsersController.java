package com.gostgroup.test.rest;

import com.gostgroup.test.model.UsersEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 1/25/17.
 */
@RestController
public class UsersController {

  //curl -I http://127.0.0.1:8080/users/1
  @RequestMapping(value = "/users/", method = RequestMethod.GET)
  public ResponseEntity<UsersEntity> getUser(@PathVariable("id") String id){

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

}
