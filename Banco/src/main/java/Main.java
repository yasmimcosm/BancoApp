import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco b = new Banco();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("--------BEM-VINDO--------");

        while (continuar) {
            System.out.println("\n------MENU------");
            System.out.println(" 1 - Cadastro");
            System.out.println(" 2 - Depósito");
            System.out.println(" 3 - Saque");
            System.out.println(" 4 - Transferência");
            System.out.println(" 5 - Listar contas");
            System.out.println(" 0 - Sair");
            System.out.println("----------------");

            System.out.print("O que deseja realizar? ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1: {
                    System.out.print("Digite seu Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite seu CPF (somente números): ");
                    String cpf = scanner.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();

                    Pessoa p = new Pessoa(cpf, nome, senha);

                    if (b.cadastrarPessoa(p)) {
                        System.out.println("Pessoa cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar pessoa.");
                        break;
                    }

                    System.out.print("Digite o número da sua conta: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    Conta c = new Conta(num);
                    if (b.cadastrarConta(c, cpf)) {
                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar conta.");
                    }

                    break;
                }

                case 2: {
                    System.out.print("Digite seu Numero da Conta: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite sua senha da Conta: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();

                    b.deposito(num, deposito, senha);
                    System.out.print(b.extrato(num, senha));

                    break;
                }

                case 3: {
                    System.out.print("Digite seu Numero da Conta: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite sua senha da Conta: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite o valor do saque: ");
                    double saque = scanner.nextDouble();

                    b.saque(num, deposito, senha);
                    System.out.print(b.extrato(num, senha));

                    break;
                }

                case 4: {
                    System.out.print("Digite seu Numero da Conta: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite sua senha da Conta: ");
                    String senha = scanner.nextLine();

                    System.out.print("Digite seu Numero da Conta que deseja enviar o valor: ");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor que deseja transferir: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    b.transfere(num, num2, valor, senha);
                    System.out.print(b.extrato(num, senha));

                    break;
                }

                case 5: {
                    b.listarContas();
                    System.out.println("Quantidade de contas: " + b.quantidadeContas());

                    break;
                }

                case 0:
                    continuar = false;

                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Fechando...");
        scanner.close();
    }
}
