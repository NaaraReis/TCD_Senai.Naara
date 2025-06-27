
package cliente; // Pacote onde esta classe está localizada

// Importa as anotações da API de persistência (JPA)
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


// Indica que esta classe é uma entidade do Hibernate (tabela no banco de dados)
@Entity
// Especifica o nome da tabela no banco como "cliente"
@Table(name = "cliente")

public class Cliente {
    // Indica que este campo é a chave primária da tabela
    @Id
    // Define que o valor do ID será gerado automaticamente (auto-incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String telefone;

    // Métodos Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
