package controller;

import DTO.SubredditRequestDTO;
import DTO.SubredditResponseDTO;
import model.Subreddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SubredditService;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/subreddit")
public class SubredditController {
    private SubredditService subredditService;

    @Autowired
    public SubredditController(SubredditService subredditService) {
        this.subredditService = subredditService;
    }


    @PostMapping("/add")
    public ResponseEntity<Subreddit> addSubreddit(@RequestBody SubredditRequestDTO subredditRequestDTO){//Subreddit;  //ResponseEntity -> controlam noi cum sa arate raspunsul
        return status(HttpStatus.OK).body(subredditService.addSubreddit(subredditRequestDTO));//subredditService.addSubreddit(subredditRequestDTO)
    }

    @GetMapping("/all")
    public ResponseEntity<List<SubredditResponseDTO>> getAllSubreddits(){
        return status(HttpStatus.OK).body(subredditService.getAllSubreddits());
    }
}
