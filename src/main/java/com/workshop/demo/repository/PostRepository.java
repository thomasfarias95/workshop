package com.workshop.demo.repository;

import com.workshop.demo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostRepository, String> {
    List<Post> searchTitle(String text);
}
