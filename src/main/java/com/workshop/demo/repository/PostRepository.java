package com.workshop.demo.repository;

import com.workshop.demo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostRepository, String> {

    @Query("{'title': {$regex: ?0, $options: '<i>'} }")
    List<Post> searchTitle(String text);

    @Query("{$and: [{date: {$get: ?1} },{{date: {$lte: ?2} },{$or: [{'title: {$regex: ?0, $options: i }},{'body: {$regex: ?0, $options: i }},{'commetis.text: {$regex: ?0, $options: i }}]}]}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    List<Post> findByTitleContainingIgnoreCase(String text);



}
