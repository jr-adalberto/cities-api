package com.cidadesapi.staties.resources;

import com.cidadesapi.countries.entities.Country;
import com.cidadesapi.countries.repositories.CountryRepository;
import com.cidadesapi.staties.entities.State;
import com.cidadesapi.staties.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/staties")
public class StateResource {

    @Autowired
    private StateRepository repository;

    @GetMapping
    public Page<State> staties(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<State> optional = repository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
