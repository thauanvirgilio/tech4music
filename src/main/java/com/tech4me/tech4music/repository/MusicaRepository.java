package com.tech4me.tech4music.repository;

import com.tech4me.tech4music.model.Musica;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica,String>{

    Musica findByCodigo(Integer codigo);

    Musica findByDescricao(String nome);
    
}