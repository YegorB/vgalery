package com.example.vgalery.controller;

import com.example.vgalery.model.Profile;
import com.example.vgalery.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles/{profileId}")
    public Optional<Profile> getProfileById(@PathVariable Long profileId) {
        return profileRepository.findById(profileId);
    }

    @PostMapping("/profiles")
    public Profile createProfile(@Valid @RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

}
