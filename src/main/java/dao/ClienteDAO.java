package dao;

import cliente.Cliente; // Importa a classe Cliente (modelo)
import org.hibernate.Session; // Representa uma sessão com o banco
import org.hibernate.SessionFactory;  // Fábrica de sessões
import org.hibernate.Transaction; // Representa uma transação
import org.hibernate.cfg.Configuration; // Utilizada para configurar o Hibernate
import java.util.List; // Para retornar listas de clientes

public class ClienteDAO {

    // Instância única da SessionFactory (compartilhada entre os métodos)
    private static final SessionFactory sessionFactory;

    // Bloco estático para inicializar a SessionFactory uma única vez
    static {
        try {
            // Cria a SessionFactory lendo o arquivo hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Erro ao criar SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método para cadastrar um novo cliente no banco
    public void cadastrar(Cliente cliente) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction(); // Inicia uma transação
            session.save(cliente); // Persiste o objeto Cliente no DB
            tx.commit(); // Confirma a transação
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // Em caso de erro, desfaz a transação
            System.err.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes cadastrados
    public List<Cliente> listar() {
        try (Session session = sessionFactory.openSession()) {
            // Executa uma query HQL (Hibernate Query Language) para buscar todos os clientes
            return session.createQuery("FROM Cliente", Cliente.class).list();
        } catch (Exception e) {
            System.err.println("Erro ao listar clientes: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar os dados de um cliente existente
    public void atualizar(int id, String novoNome, String novoEmail, String novoTelefone) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            Cliente cliente = session.get(Cliente.class, id); // Busca o cliente pelo ID
            if (cliente != null) {
                tx = session.beginTransaction(); // Inicia a transação
                cliente.setNome(novoNome); // Altera o nome
                cliente.setEmail(novoEmail);
                cliente.setTelefone(novoTelefone);
                session.update(cliente); // Atualiza o objeto Cliente no DB
                tx.commit();  // Confirma a transação
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Método para excluir um cliente pelo ID
    public void excluir(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                tx = session.beginTransaction(); // Inicia a transação
                session.delete(cliente); // Remove o objeto Cliente do banco
                tx.commit(); // Inicia a transação
                System.out.println("Cliente excluído com sucesso!");
            } else  {
                System.out.println("Cliente com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarPorId(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cliente.class, id); // Retorna o cliente se existir
        } catch (Exception e) {
            System.err.println("Erro ao buscar cliente: " + e.getMessage());
            return null;
        }
    }
}
