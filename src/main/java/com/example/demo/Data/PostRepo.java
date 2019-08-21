package com.example.demo.Data;

import com.example.demo.Model.Create;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepo extends MongoRepository<Create,String> {
    List<Create> findByName(String name);
    Create findAllByName(String name);
    Create findAllByTitle(String t);

    void deleteByName(String name);

    void deleteByNameAndId(String name, String title);
    Create findAllByNameAndId(String s,String t);
}
