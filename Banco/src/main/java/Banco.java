import java.util.ArrayList;

public class Banco {

    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();


    private Pessoa pesquisarPessoa(String cpf) {
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }


    public boolean cadastrarPessoa(Pessoa p) {
        if (p.validar() && pesquisarPessoa(p.getCpf()) == null) {
            pessoas.add(p);
            return true;
        } else {
            System.out.println("Pessoa inválida ou já cadastrada.");
            return false;
        }
    }


    public boolean cadastrarConta(Conta c, String cpf) {
        Pessoa p = pesquisarPessoa(cpf);
        if (c.validar() && p != null && pesquisarConta(c.getNumero()) == null) {
            contas.add(c);
            c.setDono(p);
            p.setConta(c);
            return true;
        } else {
            System.out.println("Conta inválida ou já cadastrada.");
            return false;
        }
    }


    private Conta pesquisarConta(int num) {
        for (Conta c : contas) {
            if (c.getNumero() == num) {
                return c;
            }
        }
        return null;
    }


    public double saldo(int num, String passwd) {
        Conta c = pesquisarConta(num);
        if (c != null && c.getDono().getSenha().equals(passwd)) {
            return c.getSaldo();
        }
        System.out.println("Conta inexistente ou senha incorreta.");
        return -9999999;
    }


    public void deposito(int num, double v, String passwd) {
        Conta c = pesquisarConta(num);
        if (c != null && v > 0) {
            if (c.getDono().getSenha().equals(passwd)) {
                c.credito(v);
                System.out.println("Depósito realizado.");
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Conta inexistente ou valor inválido.");
        }
    }


    public void saque(int num, double v, String passwd) {
        Conta c = pesquisarConta(num);
        if (c != null) {
            if (c.getDono().getSenha().equals(passwd)) {
                if (c.getSaldo() >= v) {
                    c.debito(v);
                    System.out.println("Saque realizado.");
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Conta inexistente.");
        }
    }


    public String extrato(int num, String passwd) {
        Conta c = pesquisarConta(num);
        if (c != null) {
            if (c.getDono().getSenha().equals(passwd)) {
                return c.getExtrato();
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Conta inexistente.");
        }
        return "Erro ao gerar extrato.";
    }


    public void transfere(int numOrigem, int numDestino, double v, String passwd) {
        Conta cOrigem = pesquisarConta(numOrigem);
        Conta cDestino = pesquisarConta(numDestino);

        if (cOrigem != null) {
            if (cOrigem.getDono().getSenha().equals(passwd)) {
                if (cDestino != null) {
                    if (cOrigem.getSaldo() >= v) {
                        cOrigem.debito(v);
                        cDestino.credito(v);
                        System.out.println("Transferência realizada com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                } else {
                    System.out.println("Conta de destino inexistente.");
                }
            } else {
                System.out.println("Senha incorreta.");
            }
        } else {
            System.out.println("Conta de origem inexistente.");
        }
    }


    public int quantidadeContas() {
        return contas.size();
    }


    public void listarContas() {
        System.out.println("Contas cadastradas:");
        for (Conta c : contas) {
            System.out.println("Conta: " + c.getNumero() + " | Titular: " + c.getDono().getNome());
        }
    }
}
