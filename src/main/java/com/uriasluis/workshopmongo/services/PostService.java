package com.uriasluis.workshopmongo.services;

import com.uriasluis.workshopmongo.domain.Post;
import com.uriasluis.workshopmongo.domain.User;
import com.uriasluis.workshopmongo.dto.UserDTO;
import com.uriasluis.workshopmongo.repository.PostRepository;
import com.uriasluis.workshopmongo.repository.UserRepository;
import com.uriasluis.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}