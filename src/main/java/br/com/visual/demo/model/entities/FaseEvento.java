package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FaseEvento")
public class FaseEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codFase;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Integer codTipoEvento;
    @OneToMany(mappedBy = "faseEvento")
    @JsonIgnore
    private List<StatusFaseEvento> statusFaseEventos;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codTipoEvento", insertable = false, updatable = false)
    private TipoEvento tipoEvento;

    public FaseEvento() {
    }

    public FaseEvento(String descricao, Integer codTipoEvento, List<StatusFaseEvento> statusFaseEventos, TipoEvento tipoEvento) {
        this.descricao = descricao;
        this.codTipoEvento = codTipoEvento;
        this.statusFaseEventos = statusFaseEventos;
        this.tipoEvento = tipoEvento;
    }

    public Integer getCodFase() {
        return codFase;
    }

    public void setCodFase(Integer codFase) {
        this.codFase = codFase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodTipoEvento() {
        return codTipoEvento;
    }

    public void setCodTipoEvento(Integer codTipoEvento) {
        this.codTipoEvento = codTipoEvento;
    }

    public List<StatusFaseEvento> getStatusFaseEventos() {
        return statusFaseEventos;
    }

    public void setStatusFaseEventos(List<StatusFaseEvento> statusFaseEventos) {
        this.statusFaseEventos = statusFaseEventos;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
