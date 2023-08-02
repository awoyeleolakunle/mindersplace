package com.example.mindersplace.data.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Parent {
     @OneToOne
     @JoinColumn(name = "user_id")
    private User user;
     @OneToMany
             (fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    // @JoinColumn(name = "parent_id")
     private List<Child> child = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String userName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BookingRecord> bookingRecord;
    private boolean isActive;

}
