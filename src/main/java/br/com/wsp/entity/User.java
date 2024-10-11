package br.com.wsp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends PanacheEntityBase {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String username;



}
