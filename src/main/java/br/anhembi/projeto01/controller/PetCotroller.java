package br.anhembi.projeto01.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.projeto01.model.Pet;
import br.anhembi.projeto01.repository.PetRepo;

@RestController // esta é uma classe de Controller REST
@CrossOrigin("*") // aceita requisições de qualquer origem (server)
@RequestMapping("/pet") // toda requisição para este controlle será "../pet"
public class PetCotroller {

    @Autowired // implementa a inteface com os métodos e retorna um objeto
    private PetRepo repo;

    // método acionado por uma chamada GET
    @GetMapping
    public ArrayList<Pet> listaPets() {
        ArrayList<Pet> listUsers = (ArrayList<Pet>) repo.findAll();

        return listUsers;
    }

    @PostMapping
    public ResponseEntity<Pet> inserirPet(@RequestBody Pet pet) { // os dados do User deve vir no corpo da requisição
        // Para inserir um novo User, não deve ser informado o ID, pois este sera gerado
        // pelo BD

        Pet novoPet = repo.save(pet); // o método é usado para inserir um novo User no BD. Não deve ter o ID informado

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet); // retorna o código http 201 e no corpo da msg o
                                                                        // usuário inserido no BD
    }

    @PutMapping // a chamada neste caso deve ser via método PUT
    public ResponseEntity<Pet> updateUser(@RequestBody Pet pet) {
        // antes de atualizar, verifica se o User existe no BD para evitar inserir um
        // novo User no BD
        Pet petFound = repo.findById(pet.getCodigo()).orElse(null);

        if (petFound == null) {
            return ResponseEntity.notFound().build();
        }

        Pet newUser = repo.save(pet); // o mesmo método para inserir um novo User, porém aqui deve ser informado o ID

        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}") // a chamada deve ser via DELETE informando o ID do User a ser removido
    public ResponseEntity<Pet> deleteUser(@PathVariable long id) {
        // verifica se o usuário existe para depois apagar
        Pet petFound = repo.findById(id).orElse(null);

        if (petFound == null) {
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // @GetMapping("/email") // acionado via GET também, mas acrescentamos /email após o /pet
    // public ResponseEntity<Pet> findUserUsingEmail(@RequestBody Pet pet) {
    //     // O método findByEmail foi declarado na Interface e é implementado pelo Spring
    //     // JPA
    //     Pet petFound = repo.findByEmail(pet.getRaca());

    //     if (petFound == null) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok(petFound);
    // }

}
