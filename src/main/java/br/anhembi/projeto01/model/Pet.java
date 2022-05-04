package br.anhembi.projeto01.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // indica que esta classe será persistida no BD
@Table(name = "usuario") // nome da tabela no BD para esta entidade
public class Pet {
    @Id // indica que este atributo será chave primária na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, ...
    private long codigo;

    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    
    @Column(name = "raca", length = 100)
    private String raca;
    
    @Column(name = "localizacao", length = 20)
    private String localizacao;
   
    @Column(name = "imagem")
    private String imagem;
    
    @Column(name = "idade", length = 200)
    private int idade;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

 



    
}
