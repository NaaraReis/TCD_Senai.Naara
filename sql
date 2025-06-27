
**Instruções para Configuração do Banco de Dados**

Para configurar o banco de dados e a tabela `cliente` no seu MySQL Workbench, siga estes passos:

1.  Copie o script SQL abaixo.
2.  No MySQL Workbench**, abra uma nova aba de consulta (Query Tab).
3.  **Cole o script** na aba.
4.  **Execute o script** clicando no ícone do raio (ou use `Ctrl + Enter` para executar a linha,
ou `Ctrl + Shift + Enter` para o script inteiro).

   sql

CREATE DATABASE IF NOT EXISTS cliente_crud;
USE cliente_crud;
CREATE TABLE IF NOT EXISTS cliente (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL,
  email VARCHAR(45) UNIQUE NOT NULL,
  telefone VARCHAR(20)
);


Após a execução bem-sucedida, o banco de dados `cliente_crud` e a tabela `cliente` estarão prontos
para serem usados pelo seu projeto Java.
