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
     @OneToMany( mappedBy = "parent", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    // @JoinColumn(name = "parent_id")
     private List<Child> child = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String userName;
    private boolean isActive;

}
