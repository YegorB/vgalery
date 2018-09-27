package com.example.vgalery.repository;

import com.example.vgalery.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long>{

    List<Painting> findByProfileId(Long profileId);
}
