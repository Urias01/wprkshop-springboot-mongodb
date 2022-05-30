package com.uriasluis.workshopmongo.resources;

import com.uriasluis.workshopmongo.domain.Post;
import com.uriasluis.workshopmongo.domain.User;
import com.uriasluis.workshopmongo.dto.UserDTO;
import com.uriasluis.workshopmongo.resources.util.URL;
import com.uriasluis.workshopmongo.services.PostService;
import com.uriasluis.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    // @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    //@GetMapping(value = "/fullsearch")
    @RequestMapping(value="/fullsearch", method=RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}
