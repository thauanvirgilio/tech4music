package com.tech4me.tech4music.service;

import java.util.List;

import com.tech4me.tech4music.dto.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodasMusicas();
    MusicaDto obterPorNome(String nome);
    MusicaDto cadastrarMusica(MusicaDto musica);
    void excluirMusica(String id);
    MusicaDto alterarInfoMusica(String id, MusicaDto musica);

}
