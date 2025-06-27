# Gerenciamento de Clientes com Hibernate

Este é um projeto Java simples que demonstra um CRUD (**Create, Read, Update, Delete**) de clientes utilizando o framework de persistência Hibernate para interagir com um banco de dados MySQL.

---

## 📌 Visão Geral do Projeto

O projeto é estruturado em diferentes componentes para garantir a separação de responsabilidades:

- **Cliente.java**: classe de entidade que representa a tabela cliente no banco de dados, com anotações JPA (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`).
- **ClienteDAO.java**: camada de acesso a dados (DAO) que gerencia sessões, transações do Hibernate e fornece métodos de CRUD.
- **Main.java**: classe principal que interage com o usuário via menu de console.
- **hibernate.cfg.xml**: arquivo de configuração do Hibernate (conexão com o banco, dialeto, etc).
- **pom.xml**: configuração do Maven com as dependências do Hibernate e MySQL.

---

## ✅ Pré-requisitos

- JDK 23  
- Maven  
- MySQL Server  
- Git

---

## 🚀 Como Testar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/NaaraReis/TCD_Senai.Naara.git
cd TCD_Senai.Naara
````

---

### 2️⃣ Criar o banco de dados

Execute no MySQL:

```sql
CREATE DATABASE IF NOT EXISTS cliente_crud;

USE cliente_crud;

CREATE TABLE IF NOT EXISTS cliente (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  email VARCHAR(45) UNIQUE NOT NULL,
  telefone VARCHAR(20)
);
```

---

### 3️⃣ Configurar o acesso ao banco de dados

No arquivo `hibernate.cfg.xml` (em `src/main/resources`):

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/cliente_crud</property>
<property name="hibernate.connection.username">SEU_USUARIO</property>
<property name="hibernate.connection.password">SUA_SENHA</property>
```

> **Observação**: o `hibernate.hbm2ddl.auto` está como `update`, para que o Hibernate atualize o esquema sem apagar dados.

---

### 4️⃣ Executar o Projeto

#### Opção A: Usando a IDE

1. Importe o projeto como Maven
2. Localize `Main.java`
3. Clique com o botão direito → *Run 'Main.main()'*

#### Opção B: Usando o terminal

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="Main"
```

---

### 5️⃣ Interagir com o Menu no Console

Após a execução, o console exibirá:

```
----- MENU CLIENTES -----
1. Cadastrar
2. Listar
3. Atualizar
4. Excluir
0. Sair
```

**Funções**:

* **Cadastrar**: digite 1 e forneça nome, e-mail, telefone
* **Listar**: digite 2
* **Atualizar**: digite 3, informe o ID e novos dados
* **Excluir**: digite 4 e informe o ID
* **Sair**: digite 0

---

## 👩‍💻 Autor / Contato

Nome: Naara Reis / E-mail: naara.dev@gmail.com


