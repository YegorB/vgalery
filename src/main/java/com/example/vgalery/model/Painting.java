package com.example.vgalery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name = "paintings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Painting extends AuditModel {

    private Long id;

    private String description;

    private String image;

    private String title;

/*
    @Id
    @GeneratedValue(generator = "painting_generator")
    @SequenceGenerator(
            name = "painting_generator",
            sequenceName = "painting_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "text")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }*/
}
