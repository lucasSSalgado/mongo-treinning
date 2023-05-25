package treining.mongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treining.mongo.domain.Post;
import treining.mongo.services.PostService;
import treining.mongo.util.URL;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Post>> findByAuthor(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.searchInBody(text);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> searchByTextAndData(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.converteDate(minDate, new Date(0L));
        Date max = URL.converteDate(maxDate, new Date());
        List<Post> list = service.searchByTextAndData(min, max, text);
        return ResponseEntity.ok(list);
    }
}
