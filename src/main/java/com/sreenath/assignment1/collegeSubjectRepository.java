package com.sreenath.assignment1;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface collegeSubjectRepository extends CrudRepository<collegeSubject,Long> {
    public List<collegeSubject> findByLabel(String label);
}
