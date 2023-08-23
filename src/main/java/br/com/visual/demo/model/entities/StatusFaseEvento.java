package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "StatusFaseEvento")
public class StatusFaseEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codStatusFase;
    @Column(nullable = false)
    private Integer codEvento;
    @Column(nullable = false)
    private Integer codFase;
    private String status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codEvento", insertable = false, updatable = false)
    private Evento evento;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codFase", insertable = false, updatable = false)
    private FaseEvento faseEvento;

    public StatusFaseEvento() {
    }

    public StatusFaseEvento(Integer codEvento, Integer codFase, String status, Evento evento, FaseEvento faseEvento) {
        this.codEvento = codEvento;
        this.codFase = codFase;
        this.status = status;
        this.evento = evento;
        this.faseEvento = faseEvento;
    }

    public Integer getCodStatusFase() {
        return codStatusFase;
    }

    public void setCodStatusFase(Integer codStatusFase) {
        this.codStatusFase = codStatusFase;
    }

    public Integer getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(Integer codEvento) {
        this.codEvento = codEvento;
    }

    public Integer getCodFase() {
        return codFase;
    }

    public void setCodFase(Integer codFase) {
        this.codFase = codFase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public FaseEvento getFaseEvento() {
        return faseEvento;
    }

    public void setFaseEvento(FaseEvento faseEvento) {
        this.faseEvento = faseEvento;
    }
}
