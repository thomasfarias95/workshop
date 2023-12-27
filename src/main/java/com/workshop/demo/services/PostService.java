package com.workshop.demo.services;

import com.workshop.demo.domain.Post;
import com.workshop.demo.domain.User;
import com.workshop.demo.repository.PostRepository;
import com.workshop.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostService {
    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}