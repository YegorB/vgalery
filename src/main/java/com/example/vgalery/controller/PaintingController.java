package com.example.vgalery.controller;

import com.example.vgalery.exception.ResourceNotFoundException;
import com.example.vgalery.model.Painting;
import com.example.vgalery.repository.PaintingRepository;
import com.example.vgalery.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PaintingController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping("/profiles/{profileId}/paintings")
    public List<Painting> getPaintingsByProfile(@PathVariable Long profileId) {
        return paintingRepository.findByProfileId(profileId);
    }

    @PostMapping("/profiles/{profileId}/paintings")
    public Painting addPainting(@PathVariable Long profileId, @Valid @RequestBody Painting painting) {
        return profileRepository.findById(profileId)
                .map(profile -> {
                    painting.setProfile(profile);
                    return paintingRepository.save(painting);
                }).orElseThrow(() -> new ResourceNotFoundException("Profile is not found with id = " + profileId));
    }
}
