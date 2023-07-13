package com.TimothyNguyen.DogDaycare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long imageId;
    private String name;
    private String type;
    @Lob
    private byte [] picture ;
    @ManyToOne(fetch = LAZY)
    @JsonBackReference
    private Order order;
}
