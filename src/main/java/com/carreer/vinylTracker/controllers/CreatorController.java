package com.carreer.vinylTracker.controllers;

import com.carreer.vinylTracker.models.Creator;
import com.carreer.vinylTracker.models.auth.User;
import com.carreer.vinylTracker.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/creator")
public class CreatorController {

    @Autowired
    private CreatorRepository creatorRepository;

    //Find all users
    @GetMapping
    public @ResponseBody List<Creator> getCreators() {
        return creatorRepository.findAll();
    }

    //Find single user by ID
    @GetMapping("/{id}")
    public @ResponseBody Creator getSingleCreator(@PathVariable Long id){
        return  creatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //Create User with given input
    @PostMapping
    public ResponseEntity<Creator>  makeCreator(@RequestBody Creator newCreator){
        return new ResponseEntity<>(creatorRepository.save(newCreator), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Creator modifyCreator(@PathVariable Long id, @RequestBody Creator changes) {
        Creator creator = creatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        creator.setName(changes.getName());
        creator.setFavBrand(changes.getFavBrand());

        return creatorRepository.save(changes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  removeCreator(@PathVariable Long id){
        creatorRepository.deleteById(id);
        return new ResponseEntity<>("Removed", HttpStatus.OK);
    }

}

