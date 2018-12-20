package com.example.vgalery.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.vgalery.exception.ResourceNotFoundException;
import com.example.vgalery.model.Painting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://vgallery-ui.appspot.com/")
public class PaintingController {

/*
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PaintingRepository paintingRepository;
*/

    public static final String IMAGE = "https://images.pexels.com/photos/68147/waterfall-thac-dray-nur-buon-me-thuot-daklak-68147.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260";

    @GetMapping("/_status")
    public String getStatus() {
        return "Ok";
    }


    @GetMapping("/rest/images")
    public List<Painting> getImages() {
        Random random = new Random();
        List<Painting> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Painting image = new Painting(random.nextLong(), "Some description", IMAGE, "Title_" + i);
            list.add(image);
        }

        return list;


    }

    @PostMapping("/rest/image")
    public PutObjectResult uploadImages(@RequestParam("file") MultipartFile file) {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAISNLM5NKDPKNX22Q",
                "1dDUidi2pLePh67KWjRVe91nW2/MNxviA0vWq9lD"
        );
        AmazonS3 client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
        PutObjectRequest request = null;
        try {
            request = new PutObjectRequest(
                    "photo-bucket-vgalery",
                    System.currentTimeMillis() + "file.jpg",
                    file.getInputStream(),
                    metadata
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return client.putObject(request);

    }

    /*

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
*/
}
