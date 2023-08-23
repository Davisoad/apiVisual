package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codCliente;
    @Column(length = 100, nullable = false)
    private String nomeCliente;
    @Column(length = 100, nullable = false)
    private String descricaoc;
    @Column(length = 100, nullable = false)
    private String cpfCnpj;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Evento> eventos;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String descricaoc, String cpfCnpj, List<Evento> eventos) {
        this.nomeCliente = nomeCliente;
        this.descricaoc = descricaoc;
        this.cpfCnpj = cpfCnpj;
        this.eventos = eventos;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricaoc() {
        return descricaoc;
    }

    public void setDescricaoc(String descricaoc) {
        this.descricaoc = descricaoc;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
