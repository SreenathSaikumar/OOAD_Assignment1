package com.sreenath.assignment1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToMany
    private List<collegeSubject> collegeSubjects;

    public Student(){ super(); }
    public Student(String firstName, String lastName, String email,
    List<collegeSubject> collegeSubjects) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.collegeSubjects = collegeSubjects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<collegeSubject> getCollegeSubjects() {
        return collegeSubjects;
    }

    public void setCollegeSubjects(List<collegeSubject> collegeSubjects) {
        this.collegeSubjects = collegeSubjects;
    }

    public boolean hasSubject(collegeSubject collegeSubject) {
        for (collegeSubject containedSubject: getCollegeSubjects()) {
            if (containedSubject.getId() == collegeSubject.getId()) {
                return true;
            }
        }
        return false;
    }
}
