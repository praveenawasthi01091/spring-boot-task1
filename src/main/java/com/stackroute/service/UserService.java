package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    public Track saveUser(Track user) throws TrackAlreadyExistsException;

    public List<Track> getAllUsers();

    public Track getUserByID(int id) throws TrackNotFoundException;

    public Track updateUser(int id, String comment) throws TrackNotFoundException;

    public String deleteAllUsers();

    public String deleteById(int id) throws TrackNotFoundException;

    public List<Track> getTrackByName(String trackName);
}
