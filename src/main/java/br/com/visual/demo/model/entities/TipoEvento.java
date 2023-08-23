package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TipoEvento")
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTipoEvento;
    @Column(nullable = false)
    private String descricao;
    @OneToMany(mappedBy = "tipoEvento")
    @JsonIgnore
    private List<Evento> eventos;
    @OneToMany(mappedBy = "tipoEvento")
    @JsonIgnore
    private List<FaseEvento> faseEventos;

    public TipoEvento() {
    }

    public TipoEvento(String descricao, List<Evento> eventos, List<FaseEvento> faseEventos) {
        this.descricao = descricao;
        this.eventos = eventos;
        this.faseEventos = faseEventos;
    }

    public Integer getCodTipoEvento() {
        return codTipoEvento;
    }

    public void setCodTipoEvento(Integer codTipoEvento) {
        this.codTipoEvento = codTipoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<FaseEvento> getFaseEventos() {
        return faseEventos;
    }

    public void setFaseEventos(List<FaseEvento> faseEventos) {
        this.faseEventos = faseEventos;
    }
}
