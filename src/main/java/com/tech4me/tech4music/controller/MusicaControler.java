package com.tech4me.tech4music.controller;

import java.util.List;

import com.tech4me.tech4music.dto.MusicaDto;
import com.tech4me.tech4music.service.MusicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musica")
public class MusicaControler {
    
    @Autowired
    private MusicaService service;

    @GetMapping 
    public List<MusicaDto> obterMusicas(){
        return service.obterTodasMusicas();
    }

    @GetMapping
    public MusicaDto obterPorNome(@PathVariable String nome){
        return service.obterPorNome(nome);
    } 

    @PostMapping
    public MusicaDto cadastrarMusica(@RequestBody MusicaDto musica){
        return service.cadastrarMusica(musica);
    }

    @DeleteMapping("/{id}")
    public void excluirMusica(@PathVariable String id){
        service.excluirMusica(id);
    }

    @PutMapping("/{id}")
    public MusicaDto alterarInfoMusica(@PathVariable String id, @RequestBody MusicaDto musicaInfoAlterar){
        return service.alterarInfoMusica(id, musicaInfoAlterar);
    }
 
}
