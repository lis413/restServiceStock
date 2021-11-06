package ru.lis154.restServiceStock.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserSec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String email;


}
