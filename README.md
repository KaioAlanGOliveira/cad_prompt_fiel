# cad_prompt_fiel

#  Sistema de Dizimistas - Console

Sistema simples de cadastro e gerenciamento de fiéis e pagamentos de dízimos, desenvolvido em **Java** com conexão ao banco MySQL.

##  Funcionalidades

- **Gestão de Fiéis**
  - Cadastrar novo fiel (CPF, Nome, Idade, Telefone)
  - Listar todos os fiéis
  - Remover fiel por CPF

- **Gestão de Pagamentos**
  - Registrar pagamento de dízimo (CPF, Data e Status)
  - Listar todos os pagamentos
  - Remover pagamento por CPF

- Menu interativo via console

##  Tecnologias

- **Linguagem**: Java
- **Banco de Dados**: MySQL
- **Conexão**: JDBC
- **IDE Recomendada**: Eclipse / IntelliJ / VS Code

##  Estrutura do Projeto

- `package connection` → `Dao.java` (Camada de acesso a dados)
- `package dizimista` → `Pagamento.java` (Classe de Pagamento)
- `package javaBean` → `Fiel.java` (Classe de Fiel)
- `package view` → `P1.java` (Menu principal e lógica do sistema)

## 🗄️ Banco de Dados

- **Banco**: `dizimistas`
- **Tabelas**:
  - `fiel` (cpf, nome, idade, telefone)
  - `dizimistas` (id, cpf, dataPagamento, pago)

##  Como Executar

1. Importe o projeto na sua IDE
2. Certifique-se de ter o MySQL rodando com o banco `dizimistas`
3. Atualize as credenciais no arquivo `Dao.java` (usuário e senha)
4. Execute a classe `P1.java`

##  Observações

- Projeto em fase de desenvolvimento (console)
- Utiliza `Scanner` para interação com o usuário
- CPF tratado como número (double)

---

**Projeto desenvolvido para gerenciamento de dizimistas da igreja.**
