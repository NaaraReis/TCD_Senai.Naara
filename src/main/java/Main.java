import dao.ClienteDAO; // Importa a classe responsável pelas operações no banco
import cliente.Cliente;  // Importa a entidade Cliente

import java.util.List; // Importa List para manipular listas de clientes
import java.util.Scanner;  // Importa Scanner para entrada de dados via terminal

public class Main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO(); // Instancia o DAO para manipular os dados
        Scanner scanner = new Scanner(System.in); // Scanner para ler entrada do usuário

        // Menu com switch case
        int opcao;

        do {
            System.out.println("\n----- MENU CLIENTES -----");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();  // Lê a opção escolhida
            scanner.nextLine(); // consumir linha

            switch (opcao) {
                // Caso 1: Cadastrar novo cliente
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Cliente novoCliente = new Cliente(); // Cria novo cliente
                    novoCliente.setNome(nome);
                    novoCliente.setEmail(email);
                    novoCliente.setTelefone(telefone);
                    dao.cadastrar(novoCliente);  // Chama método para salvar no banco
                    break;

                // Caso 2: Listar todos os clientes
                case 2:
                    List<Cliente> clientes = dao.listar(); // Obtém a lista de clientes
                    if (clientes != null && !clientes.isEmpty()) {
                        for (Cliente c : clientes) {
                            System.out.println("ID: " + c.getId());
                            System.out.println("Nome: " + c.getNome());
                            System.out.println("Email: " + c.getEmail());
                            System.out.println("Telefone: " + c.getTelefone());
                            System.out.println("------------------------");
                        }
                    } else {
                        System.out.println("Nenhum cliente encontrado.");
                    }
                    break;

                // Caso 3: Atualizar os dados de um cliente existente
                case 3:
                    System.out.print("ID do cliente a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    dao.atualizar(idAtualizar, novoNome, novoEmail, novoTelefone);
                    break;

                // Caso 4: Excluir um cliente pelo ID
                case 4:
                    System.out.print("ID do cliente a excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir); // Chama método de exclusão
                    break;

                // Caso 0: Sair do programa
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                // Caso padrão: opção inválida
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0); // Continua executando até o usuário digitar 0

        scanner.close(); // Fecha o scanner no final
    }
}
