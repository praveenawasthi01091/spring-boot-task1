package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Profile("notdummy")
// mvn clean
// mvn spring-boot:run -Dspring.profiles.active=dummy
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        System.out.println("Inside actual impl");
        this.userRepository = userRepository;
    }


    @Override
    public Track saveUser(Track user) throws TrackAlreadyExistsException {
        if(userRepository.existsById(user.getId()))
            throw new TrackAlreadyExistsException("Track id is already exists");

        Track savedUser= userRepository.save(user);
        if(savedUser == null)
            throw new TrackAlreadyExistsException("Track id is  already exists");
        return savedUser;
    }

    @Override
    public List<Track> getAllUsers() {

        System.out.println("Inside actual impl");
        return userRepository.findAll();
    }

    @Override
    public Track getUserByID(int id) throws TrackNotFoundException
    {
        if(!userRepository.existsById(id))
            throw new TrackNotFoundException("Track not found!");
       return (userRepository.findById(id).get());
    }

    @Override
    public Track updateUser(int id, String comment) throws TrackNotFoundException
    {
        if(!userRepository.existsById(id))
            throw new TrackNotFoundException("Track not found");
        Track updatedUser=getUserByID(id);
        updatedUser.setComments(comment);
        userRepository.save(updatedUser);
        if(updatedUser == null)
            throw new TrackNotFoundException("Track not found");
        return updatedUser;
    }

    @Override
    public String deleteAllUsers()
    {
            userRepository.deleteAll();
            return "successfully deleted";
    }

    @Override
    public String deleteById(int id) throws TrackNotFoundException
    {
            if(!userRepository.existsById(id))
                throw new TrackNotFoundException("Track not found");
            userRepository.delete(userRepository.findById(id).get());
            return "successfully deleted";
    }

    @Override
    public List<Track> getTrackByName(String trackName)
    {
       List<Track>list=userRepository.findByName(trackName);
       return list;
    }

}