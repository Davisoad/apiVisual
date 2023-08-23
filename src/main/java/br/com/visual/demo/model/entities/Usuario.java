package br.com.visual.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUsuario;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String login;
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Evento> eventos;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String login, List<Evento> eventos) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.eventos = eventos;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.senha = passwordEncoder.encode(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
