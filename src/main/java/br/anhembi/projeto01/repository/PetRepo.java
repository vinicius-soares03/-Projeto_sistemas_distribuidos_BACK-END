package br.anhembi.projeto01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.projeto01.model.Pet;

// CRUD = Create, Read, Update, Delete
public interface PetRepo extends CrudRepository<Pet, Long> {
    //public Pet findByEmail(String email);
}
