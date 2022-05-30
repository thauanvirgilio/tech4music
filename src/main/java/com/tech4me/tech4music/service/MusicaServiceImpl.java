package com.tech4me.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tech4me.tech4music.dto.MusicaDto;
import com.tech4me.tech4music.model.Musica;
import com.tech4me.tech4music.repository.MusicaRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaRepository repository;

    private ModelMapper mapper = new ModelMapper();  

    @Override
    public List<MusicaDto> obterTodasMusicas() {
        List<Musica> musicas = repository.findAll();
        
        return musicas.stream()
            .map(m -> mapper.map(m, MusicaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public MusicaDto obterPorNome(String nome) {
        Musica musica = repository.findByDescricao(nome);
        return mapper.map(musica, MusicaDto.class);
    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto musica) {
        Musica musicaSalvar = mapper.map(musica, Musica.class);
        repository.save(musicaSalvar);
        return mapper.map(musicaSalvar, MusicaDto.class);
    }

    @Override
    public void excluirMusica(String id) {
        repository.deleteById(id);
    }

    @Override
    public MusicaDto alterarInfoMusica(String id, MusicaDto musica) {
        Optional<Musica>musicaBusca = repository.findById(id);

        if(musicaBusca.isPresent()){
            Musica musicaInfoAlterar = mapper.map(musica, Musica.class);
            musicaInfoAlterar.setId(id);
            musicaInfoAlterar = repository.save(musicaInfoAlterar);
            return mapper.map(musicaInfoAlterar, MusicaDto.class);
        }
        return null;
    }

}
