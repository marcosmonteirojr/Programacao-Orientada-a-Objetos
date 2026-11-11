# Objetivo do Trabalho
Desenvolver uma aplicação orientada a objetos (utilizando qualquer linguagem de programação), aplicando conceitos avançados de POO, separação de responsabilidades com o padrão **MVC (Model-View-Controller)**, persistência de dados utilizando o padrão **DAO (Data Access Object)** e banco de dados relacional com **duas tabelas relacionadas** contendo **CRUD completo**.
**Data de entrega: 25/11 ou 26/11 dependendo da turma**
**Para isso vocês vão utilizar a startup/projeto integrador**
---

## Requisitos do Projeto

### 1. Arquitetura e Código-Fonte
* **Linguagem:** Livre escolha (ex: Java, C#, Python, C++, PHP, JavaScript/TypeScript, etc.), desde que seja estritamente orientada a objetos.
* **Padrão de Arquitetura (MVC):** 
  * **Model:** Classes de domínio/entidades e as classes DAO para manipulação do banco de dados.
  * **View:** Interface com o usuário (pode ser console estilizado, desktop gráfica ou web, dependendo da linguagem escolhida).
  * **Controller:** Classes responsáveis por intermediar as regras de negócio entre a View e o Model.
* **Padrão DAO:** Separação completa da lógica de acesso aos dados (conexão, comandos SQL/ORM) das regras de negócio da aplicação.
* **Banco de Dados & CRUD:**
  * Utilizar um banco de dados relacional (ex: SQLite, MySQL, PostgreSQL, H2, etc.).
  * O sistema deve conter **duas tabelas relacionadas** (ex: `Cliente` e `Pedido`, `Categoria` e `Produto`, `Autor` e `Livro`).
  * Implementação obrigatória do **CRUD completo (Criar, Ler, Atualizar e Deletar)** para **ambas** as tabelas.
* **Organização:** Código-fonte limpo, organizado em pacotes/pastas seguindo o padrão MVC.

### 2. Repositório no GitHub (Entrega de Código)
O projeto deve estar hospedado em um repositório público no GitHub contendo:
* **Código-fonte completo** e estruturado em pastas/pacotes.
* **Script de Banco de Dados:** Arquivo `.sql` ou instruções claras de configuração para criação do banco e das tabelas relacionadas.
* **Instruções de Execução:** Como rodar o projeto e dependências necessárias.
* **Arquivo `README.md` estruturado com:**
  * Nome do projeto e screenshots/GIFs da aplicação em funcionamento.
  * Integrantes do grupo (Nome completo e R.A.).
  * Instruções de instalação e execução passo a passo.
  * Tecnologias e bibliotecas utilizadas.
  * **Seção Transparência de IA:** Breve descrição de onde e como a IA foi utilizada no projeto (ex: auxílio na estrutura do DAO, refatoração de classes, criação de telas, tratamento de exceções, etc.).

---

## Entrega em Vídeo (Formato Criativo)
A equipe deverá gravar e postar um **vídeo explicativo criativo** (formato horizontal, resolução mínima de 1080p). Os vídeos serão selecionados e publicados pelo professor no **canal oficial da turma no YouTube**.

> Inove no formato... Vocês podem fazer no estilo de uma esquete de comédia, um programa de TV, uma resenha bem-humorada, uma disputa de pitch de startup caótica ou uma história onde o próprio sistema de banco de dados interage com vocês. O importante é manter a criatividade sem deixar de cumprir os requisitos técnicos.

### Estrutura do Vídeo (Duração: até 5 minutos):
1. **Apresentação Criativa & Premissa (30s - 1 min):**
   * Apresentação dos integrantes de forma descontraída e introdução divertida do problema que o software resolve.
2. **Demonstração do Sistema / CRUD (1 a 3 min):**
   * Demonstração prática do sistema rodando. Mostre o cadastro, listagem, atualização e exclusão nas **duas tabelas relacionadas** (ex: cadastrando um registro pai e seus respectivos filhos, mostrando o relacionamento em ação).
3. **Explicação Técnica e Autoria (1 min):**
   * **Arquitetura:** Como aplicaram o **MVC** e o padrão **DAO** no código.
   * **Autoria dos Alunos:** O que foi desenvolvido 100% pelo grupo.
   * **Uso de IA:** Transparência total sobre quais trechos ou lógicas receberam suporte de ferramentas de Inteligência Artificial.
