# Relatório Técnico: Desenvolvimento Back-End Corp. Java

## Identificação do Projeto
**Instituição**: Faculdade Estácio de Sá
**Curso**: Superior de Tecnologia em Desenvolvimento Full Stack 
**Módulo**: Desenvolvimento Back-End Corp. Java 
***Aluno**: João Pedro Ramos Ferreira Oliveira

---

## Organização do Projeto
O projeto corporativo no NetBeans foi estruturado seguindo o padrão Java EE 6, dividido em três módulos principais para garantir o desacoplamento e facilitar a manutenção

**Módulo EAR (Enterprise Archive)**: Responsável pelo empacotamento da aplicação para deploy
**Módulo EJB**: Contém a lógica de negócios e a camada de persistência
**Módulo WAR**: Gerencia a interface web e a comunicação com o usuário

---

## Arquitetura e Persistência
A implementação utiliza tecnologias nativas da plataforma Enterprise para automação de processos:

**JPA (Java Persistence API)**: Realiza o mapeamento objeto-relacional da tabela Produto sem necessidade de SQL explícito, utilizando o pacote javax.persistence
**EJB (Enterprise JavaBeans)**: Uso de Session Beans Stateless para encapsular as regras de negócio e gerenciar as transações com o banco de dados automaticamente
**Entidade Produto**: A classe modelo utiliza anotações como @Entity, @Table e @Id para definir a estrutura no banco de dados

---

## Padrões de Projeto e Camada de Visão
O fluxo da aplicação segue padrões de mercado para organização de código

**Front Controller**: Implementado através do ServletProdutoFC, que centraliza todas as requisições e identifica a ação desejada: listar, incluir, alterar ou excluir
**Servlets e JSPs**: Os Servlets atuam como controladores do fluxo de navegação, enquanto as JSPs funcionam como a camada de visão (View)
**Design Responsivo**: Inclusão do framework Bootstrap via CDN para garantir um design limpo e profissional sem a necessidade de arquivos CSS customizados

---

## Funcionalidades Implementadas
Listagem de produtos com JSTL (c:forEach)
Operações de CRUD completas integradas ao EJB Facade
Redirecionamento dinâmico de páginas via RequestDispatcher
