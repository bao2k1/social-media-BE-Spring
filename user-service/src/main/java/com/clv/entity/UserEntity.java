package com.clv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate the ID (auto-increment)
    private Long id;

    @Column(nullable = false, unique = true)  // Make username unique and non-nullable
    private String username;

    @Column(nullable = false)  // Make password non-nullable
    private String password;
}
