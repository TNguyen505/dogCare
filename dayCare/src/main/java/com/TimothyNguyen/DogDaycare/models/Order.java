package com.TimothyNguyen.DogDaycare.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "`order`")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long orderId;
    String dogName;
    String dogBreed;
    LocalDateTime dayCareDate;
    String groomingServices;
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "description" )
    String description;
    @OneToMany(fetch = LAZY,mappedBy = "order")
    @JsonManagedReference
    private List<Image> images;
}
