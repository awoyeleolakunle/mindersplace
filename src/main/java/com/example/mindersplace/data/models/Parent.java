package com.example.mindersplace.data.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<BookingRecord> bookingRecord = new ArrayList<>();
    private boolean isActive;

}
