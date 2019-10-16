package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PropertySources({
        @PropertySource(value = "classpath:application-dev.properties"),
        @PropertySource(value = "classpath:application.properties")
        })
@RestController
/* https://dzone.com/articles/global-exception-handling-with-controlleradvice */
@RequestMapping(value = "/api/v1")
public class UserController {
    //@Qualifier("userServiceDummyImpl")
    @Autowired
    UserService userService;

    public UserController(  UserService userService) {
        this.userService = userService;
    }


    /* create new resource -- post*/
    @PostMapping("/track")
    public ResponseEntity<?> saveUser(@RequestBody Track user) throws TrackAlreadyExistsException {

        userService.saveUser(user);
        return new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
    }

    /*  Show that resource */
    @GetMapping("/track")
    public ResponseEntity<?> getAllUsers() throws Exception{

            return new ResponseEntity<List<Track>>(userService.getAllUsers(), HttpStatus.OK);

    }

    @GetMapping("/track/{id}")
    public ResponseEntity<?> getUserById( @PathVariable int id) throws TrackNotFoundException {

           return new ResponseEntity<Track>(userService.getUserByID(id), HttpStatus.OK);

    }

    @GetMapping("track/find/{trackName}")
    public ResponseEntity<?> getTrackByName( @PathVariable String trackName) throws Exception{
//        try {
            return new ResponseEntity<List<Track>>(userService.getTrackByName(trackName), HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }
    }

    /* update given  response */

    @PutMapping("/track/{id}/{comment}")
    public  ResponseEntity<?> updateUser(@PathVariable int id, @PathVariable String comment) throws TrackNotFoundException
    {
        return new ResponseEntity<Track>(userService.updateUser(id, comment), HttpStatus.OK);

    }
    /* Delete given  resource  */

    @DeleteMapping("/track")
    public ResponseEntity<?> deleteUser() throws Exception
    {
            userService.deleteAllUsers();
            ResponseEntity responseEntity;
            responseEntity = new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
            return responseEntity;
    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<?>  deleteTrack(@PathVariable int id) throws TrackNotFoundException{

            userService.deleteById(id);
            return new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
    }

}
