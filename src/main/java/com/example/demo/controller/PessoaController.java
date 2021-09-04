package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") Long id) throws Exception {
        Pessoa pessoa = this.repository.findById(id);
        return ResponseEntity.ok(pessoa);

        //@GetMapping(path = "/pessoas")
        //public String listar (){
        // return "nome, email, sexo, sobrenome, dataNascimento";
        //}
    }

    @PostMapping
    public ResponseEntity<Object> Cadastrar (@RequestBody Pessoa pessoa){
        this.repository.save(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void Alterar(@RequestBody Pessoa pessoa){
        this.repository.save(pessoa);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Pessoa> Buscar(@PathVariable("id") Long id){
        return this.repository.findById(id).map(pessoa ->
                        ResponseEntity.ok(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(path = "/{id}")
    public void Deletar(@PathVariable Long id){
        this.repository.deleteById(id);
    }

    @GetMapping(value = "/pessoas")
    public List<Pessoa> listar(){
        Pessoa p1 = new Pessoa (1l, "Marta", "dra.martasantana@hotmail.com", "Feminino", "Souto", "25 de janeiro de 1972");
        //Pessoa["nome", "email","sexo", "sobrenome", "data de nascimento"] pessoas = {p1};

        return Arrays.asList (p1);
    }
}
