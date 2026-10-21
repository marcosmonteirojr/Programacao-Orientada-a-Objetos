# ☕ Unidade 6 — Organização de projetos, tratamento de exceções e Conexão com banco de dados
> **Planejamento Didático da Disciplina**  

---

## 📌 Sumário
- [Objetivos de Aprendizagem](#-objetivos-de-aprendizagem)
- [Tópicos da Unidade](#-tópicos-da-unidade)
- [Orientações Gerais](#-orientações-gerais)
- [Material de Apoio e Referências](#-material-de-apoio-e-referências)

---

## 🎯 Objetivos de Aprendizagem
No final desta unidade, o estudante será capaz de:

* Compreender a organização física e lógica do código através de pacotes .
* Aplicar o padrão de arquitetura de software MVC (Model, View, Controller) para separar as regras de negócio, a interface de utilizador e a lógica de controlo .
* Implementar o tratamento de exceções em Java, utilizando blocos `try-catch-finally` e compreendendo a diferença entre exceções verificadas e não verificadas.
* Criar exceções personalizadas para lidar com regras de negócio específicas, como a validação de saldos em contas bancárias 11, 12].
* Estabelecer a comunicação com bases de dados relacionais utilizando a API JDBC (Java Database Connectivity).
* Executar operações de manipulação de dados (inserção, consulta, atualização e exclusão) utilizando as classes `Statement` e `PreparedStatement` 19, 22].
* Implementar o padrão de Fábrica de Conexões (`ConnectionFactory`) para centralizar a criação e gestão de ligações à base de dados 26, 2.

## 🧭 Tópicos da Unidade

1. **Organização e Pacotes:** Utilização de diretórios para separar classes com finalidades distintas .
2. **Padrão Arquitetural MVC:** Divisão da aplicação nas camadas Model (regras de negócio), View (interface gráfica) e Controller (ponte de ligação) .
3. **Tratamento de Exceções:** Captura de erros, classes `Exception` e `RuntimeException`, e as palavras-chave `throw` e `throws`.
4. **JDBC (Java Database Connectivity):** Arquitetura, dependências de drivers (ex: MySQL) e as classes principais `DriverManager`, `Connection` e `ResultSet` 15, 1.
5. **Instruções SQL em Java:** Construção de consultas e atualizações com `Statement`.
6. **Desempenho e Segurança com SQL:** Utilização de `PreparedStatement` para instruções pré-compiladas com parâmetros dinâmicos 22].
7. **Fábrica de Conexões:** Centralização da lógica de configuração da base de dados numa única classe utilitária 26].

## 🧭 Orientações Gerais
Para um excelente aproveitamento do conteúdo desta unidade, recomenda-se:

1. **Leitura Dirigida:** Realize a leitura atenta do material para fixar a base concetual sobre a separação de responsabilidades (MVC) e o funcionamento interno do JDBC 7,.
2. **Prática em Laboratório:** Implemente todos os códigos de exemplo, configurando corretamente o ficheiro `.jar` do conector MySQL no seu ambiente de desenvolvimento.
3. **Resolução de Exercícios:** Pratique os exercícios propostos sobre o tratamento de exceções (como `DivisaoPorZeroException` e `SaldoInsuficienteException`) para consolidar as boas práticas de programação segura.

## 🧭 Orientações Gerais
Para um aproveitamento excelente do conteúdo desta unidade, recomenda-se:

1. **Leitura Dirigida:** Realize a leitura atenta do material teórico indicado para fixar a base conceitual de classes abstratas e contratos de interface.
2. **Prática em Laboratório:** Implemente os códigos de exemplo.
3. **Resolução de Exercícios:** Pratique com os exercícios propostos para consolidar a programação orientada a objetos avançada.

## 📚 Material de Apoio e Referências

| Tipo | Referência / Descrição | Acesso |
| :---: | :--- | :---: |
| **📄 PDF** | *Tratamento de exceções* | [Aula 10](./Aula10-Tratamento-excecoes.pdf?raw=true) |
| **🖥️ Exercícios** | Exercícios | [Exercícios](./Exercícios/Exercícios_8.pdf?raw=true) |
| **📄 PDF** | *Conexão com banco de dados* | [Aula 11](./Aula11-Conexao-com-banco-de-dados.pdf?raw=true) |
