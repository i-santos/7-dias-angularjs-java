package com.cerebrobinario.servermatches;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/partidas")
public class MatchController {

    private List<Match> matches = new ArrayList<>();

    @GetMapping
    public List<Match> getMatches() {
        return this.matches;
    }

    @PostMapping
    public void setMatches(@RequestBody List<Match> matches) {
        this.matches = matches;
    }
    
}
