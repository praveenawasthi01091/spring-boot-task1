package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {
    @Id
    int id;
    String trackName;
    String comments;

//    public Track() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public Track(int id, String trackName, String comments) {
//        this.id = id;
//        this.trackName = trackName;
//        this.comments = comments;
//    }
//
//    @Override
//    public String toString() {
//        return "Track{" +
//                "id=" + id +
//                ", trackName='" + trackName + '\'' +
//                ", comments='" + comments + '\'' +
//                '}';
//    }
}
