package com.portfolio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private TranslationString degree;
    private String institution;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Long gpa;
    @JsonManagedReference("education-courseworks")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationCourse")
    private List<Coursework> coursework;
    @JsonManagedReference("education-projects")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationProject")
    private List<Coursework> projects;
    @JsonManagedReference("education-achievements")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "education")
    private List<Achievement> achievements;
}
