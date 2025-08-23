# 🏦 Sistema Bancário em Java

## 📖 Descrição

Este é um **sistema bancário em Java** que permite gerenciar várias contas de clientes. Cada pessoa possui **uma conta**, e o banco pode ter **várias pessoas e contas**.
O sistema permite realizar operações financeiras básicas de forma segura e estruturada.

---

## ✨ Funcionalidades

1. **👤 Cadastro de Pessoa e Conta**

   * Cada pessoa tem CPF, nome e senha.
   * Cada pessoa possui apenas **uma conta** com saldo inicial 0.

2. **💰 Depósito e Saque**

   * Depósito de valores positivos.
   * Saque com validação de saldo e senha.

3. **🔄 Transferência entre contas**

   * Transferência de valores entre contas diferentes.
   * Verifica saldo e senha da conta de origem.

4. **💳 Consulta de saldo**

   * Mostra saldo atual da conta após validação da senha.

5. **📋 Listagem de contas**

   * Exibe todas as contas cadastradas e os respectivos titulares.
   * Mostra a quantidade total de contas no banco.

---

## 🗂 Estrutura do Projeto

```
/BancoApp
  ├─ src/main/java/
  │   ├─ Main.java        # Menu interativo do sistema
  │   ├─ Banco.java       # Gerenciamento de pessoas e contas
  │   ├─ Pessoa.java      # Representa uma pessoa
  │   └─ Conta.java       # Representa uma conta bancária
  └─ README.md            # Este arquivo
```

---

## 🚀 Como Rodar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/BancoApp.git
```

2. Compile todos os arquivos dentro de `src/main/java`:

```bash
javac src/main/java/*.java
```

3. Execute o programa:

```bash
java -cp src/main/java Main
```

---

## 🛠 Tecnologias

* Java
* Programação orientada a objetos (POO)
* Estruturas de dados (`ArrayList`)

---

## 🌱 Próximas melhorias

* 📜 Histórico detalhado de transações para cada conta
* 🔑 Sistema de login de usuário antes de operações financeiras
* 🖥 Interface gráfica (GUI) para facilitar o uso
