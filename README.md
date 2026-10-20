# Lista de Usuários — Android

Aplicativo Android desenvolvido em Java como atividade acadêmica da disciplina de **Programação para Dispositivos Móveis**, com o objetivo de praticar a criação de interfaces, o armazenamento local de dados e as operações CRUD.

## Sobre o projeto

O **Lista de Usuários** é um aplicativo que permite cadastrar e gerenciar informações de usuários por meio de uma interface composta por três telas: principal, cadastro e manutenção.

O projeto utiliza XML para a construção das interfaces, Java para a lógica da aplicação e SQLite para o armazenamento local das informações.

## Funcionalidades

### Tela principal
- Exibição da lista de usuários cadastrados.
- Visualização do nome e do ID de cada usuário.
- Navegação para a tela de cadastro por meio do botão de adicionar.
- Acesso à tela de manutenção ao selecionar um usuário.

### Tela de cadastro
- Cadastro de usuários com nome completo, CPF e telefone.
- Salvamento das informações no banco de dados.
- Limpeza dos campos preenchidos.
- Navegação de volta para a tela principal.

### Tela de manutenção
- Visualização dos dados do usuário selecionado.
- Alteração das informações cadastradas.
- Exclusão de usuários.
- Navegação de volta para a tela principal.

## Tecnologias utilizadas

| Tecnologia | Aplicação no projeto |
|---|---|
| Java | Lógica e funcionalidades do aplicativo |
| XML | Construção das interfaces Android |
| SQLite | Armazenamento local dos dados |
| Android Studio | Ambiente de desenvolvimento |
| Gradle | Gerenciamento da configuração e construção do projeto |

## Conceitos praticados

Durante o desenvolvimento, foram trabalhados conceitos importantes para o desenvolvimento de aplicações mobile:

- Criação e organização de interfaces com XML.
- Manipulação de componentes e eventos em Java.
- Navegação entre Activities.
- Operações CRUD: Create, Read, Update e Delete.
- Armazenamento e consulta de dados com SQLite.
- Integração entre interface, lógica da aplicação e banco de dados.

## Possíveis evoluções

Como continuidade dos estudos, o projeto poderá ser expandido com novas funcionalidades, como:

- Integração com uma API REST desenvolvida com Spring Boot.
- Centralização dos dados em um banco de dados acessível por diferentes clientes.
- Implementação de validações para CPF e telefone.
- Melhorias na interface e na experiência do usuário.

Essas melhorias representam possibilidades futuras e não fazem parte necessariamente da implementação atual.

## Como executar o projeto

1. Clone este repositório:

   ```bash
   git clone https://github.com/araujosantos20/listaUsuario.git
   ```

2. Abra o Android Studio.
3. Selecione a opção para abrir um projeto existente e escolha a pasta clonada.
4. Aguarde a sincronização do Gradle.
5. Execute o aplicativo em um emulador Android ou em um dispositivo físico compatível.

## Objetivo acadêmico

Este projeto foi desenvolvido com o propósito de consolidar conhecimentos fundamentais de desenvolvimento Android e praticar a implementação de operações CRUD com persistência local de dados.

A atividade também serve como base para estudos futuros envolvendo APIs, integração entre aplicações mobile e backend e desenvolvimento de serviços com Java e Spring Boot.

Desenvolvido como projeto acadêmico para a disciplina de Programação para Dispositivos Móveis.
