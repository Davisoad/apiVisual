package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEvento;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codCliente", insertable = false, updatable = false)
    private Cliente cliente;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codTipoEvento", insertable = false, updatable = false)
    private TipoEvento tipoEvento;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codUsuario", insertable = false, updatable = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "evento")
    @JsonIgnore
    private List<StatusFaseEvento> statusFaseEventos;
    @Column(nullable = false)
    private Integer codCliente;
    @Column(nullable = false)
    private Integer codTipoEvento;
    @Column(nullable = false)
    private Boolean envoiDados;
    @Column(nullable = false)
    private Boolean statusLegenda;
    @Column(nullable = false)
    private LocalDate dataEntrega;
    @Column(nullable = false)
    private Integer codUsuario;
    @Column(nullable = false)
    private LocalDate dataEvento;
    @Column(nullable = false)
    private Boolean fezBackup;
    @Column(nullable = false)
    private String qualHD;
    private String editor;

    public Evento() {
    }

    public Evento(Cliente cliente, TipoEvento tipoEvento, Usuario usuario, List<StatusFaseEvento> statusFaseEventos, Integer codCliente, Integer codTipoEvento, Boolean envoiDados, Boolean statusLegenda, LocalDate dataEntrega, Integer codUsuario, LocalDate dataEvento, Boolean fezBackup, String qualHD, String editor) {
        this.cliente = cliente;
        this.tipoEvento = tipoEvento;
        this.usuario = usuario;
        this.statusFaseEventos = statusFaseEventos;
        this.codCliente = codCliente;
        this.codTipoEvento = codTipoEvento;
        this.envoiDados = envoiDados;
        this.statusLegenda = statusLegenda;
        this.dataEntrega = dataEntrega;
        this.codUsuario = codUsuario;
        this.dataEvento = dataEvento;
        this.fezBackup = fezBackup;
        this.qualHD = qualHD;
        this.editor = editor;
    }

    public Integer getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(Integer codEvento) {
        this.codEvento = codEvento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<StatusFaseEvento> getStatusFaseEventos() {
        return statusFaseEventos;
    }

    public void setStatusFaseEventos(List<StatusFaseEvento> statusFaseEventos) {
        this.statusFaseEventos = statusFaseEventos;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getCodTipoEvento() {
        return codTipoEvento;
    }

    public void setCodTipoEvento(Integer codTipoEvento) {
        this.codTipoEvento = codTipoEvento;
    }

    public Boolean getEnvoiDados() {
        return envoiDados;
    }

    public void setEnvoiDados(Boolean envoiDados) {
        this.envoiDados = envoiDados;
    }

    public Boolean getStatusLegenda() {
        return statusLegenda;
    }

    public void setStatusLegenda(Boolean statusLegenda) {
        this.statusLegenda = statusLegenda;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Boolean getFezBackup() {
        return fezBackup;
    }

    public void setFezBackup(Boolean fezBackup) {
        this.fezBackup = fezBackup;
    }

    public String getQualHD() {
        return qualHD;
    }

    public void setQualHD(String qualHD) {
        this.qualHD = qualHD;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
