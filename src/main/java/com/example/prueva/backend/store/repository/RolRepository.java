package com.example.prueva.backend.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueva.backend.store.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

}