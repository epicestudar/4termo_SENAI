<br>
<br>
<br>
<p align="center">
   <img src="/React + Node + Mongo/projeto-todolist/src/assets/img/logo.png" alt="logo" width=250px>
</p>

<p align="center">
   <img src="https://img.shields.io/badge/Backend-PRODUZINDO-red?style=for-the-badge" alt="backend" />
  <img src="https://img.shields.io/badge/Documentação-FEITO-blue?style=for-the-badge" alt="documentação" />
  <img src="https://img.shields.io/badge/Testes-PRODUZINDO-red?style=for-the-badge" alt="mobile" />
  <img src="https://img.shields.io/badge/Frontend-PRODUZINDO-red?style=for-the-badge" alt="site" />
</p>
<hr>
<br>
<br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Avaliação Formativa Node e React" alt="Typing SVG" /></a>
## Apresentação do Projeto: Desenvolvimento de Aplicação To-Do List

### Visão Geral do Projeto
**Objetivo:**
Desenvolver uma aplicação web de To-Do List utilizando tecnologias modernas e práticas de mercado, garantindo segurança, escalabilidade e uma experiência de usuário fluida. Este projeto é uma oportunidade de aplicar e aprimorar suas habilidades em React, Node.js, MongoDB, e JWT, criando uma solução completa e funcional que pode ser implementada no mundo real.

**Por Que Este Projeto?**
A Escola SENAI, que busca criar soluções educacionais para a população, precisa de uma aplicação de To-Do List bem desenvolvida que possa ser utilizada por seus colaboradores, ajudando os usuários a organizar suas tarefas de forma eficiente e segura. Estamos contratando você para nos ajudar a construir essa aplicação.
<br><br><br><br><br>
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Escopo" alt="Typing SVG" /></a>
A aplicação To-Do List será desenvolvida utilizando Node.js para o backend e React para o frontend, com MongoDB como banco de dados e JWT para autenticação. A solução visa proporcionar uma experiência de usuário intuitiva, com recursos para criação, visualização, atualização e exclusão de tarefas.
<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Objetivos SMART" alt="Typing SVG" /></a>
- **Específicos:**
  1. Implementar um sistema de autenticação de usuários utilizando JWT até o final da terceira semana.
  2. Desenvolver a interface de usuário em React, permitindo a criação e gerenciamento de tarefas, até o final da quinta semana.
  3. Configurar e integrar o banco de dados MongoDB, permitindo o armazenamento seguro e eficiente das tarefas dos usuários, até o final da quarta semana.
  4. Criar uma API RESTful com Node.js que suporte operações CRUD (Criar, Ler, Atualizar, Deletar) para tarefas, até o final da segunda semana.

- **Mensuráveis:**
  1. Alcançar uma base de 100 usuários registrados na aplicação dentro do primeiro mês após o lançamento.
  2. Garantir que 90% das operações CRUD sejam concluídas com sucesso e sem erros no primeiro mês de operação.
  3. Obter uma avaliação de satisfação do usuário de pelo menos 4,5 em uma escala de 1 a 5 após o segundo mês de uso da aplicação.
  4. Assegurar que a aplicação suporte pelo menos 500 acessos simultâneos sem degradação de performance.
 <br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Cronograma" alt="Typing SVG" /></a>
O projeto será desenvolvido ao longo de 6 semanas, distribuídas da seguinte forma:
- **Semana 1:** Análise de requisitos e definição do escopo do projeto.
- **Semana 2:** Desenvolvimento da API RESTful em Node.js para operações CRUD.
- **Semana 3:** Implementação do sistema de autenticação com JWT.
- **Semana 4:** Configuração e integração do MongoDB para armazenamento de dados.
- **Semana 5:** Desenvolvimento da interface de usuário em React.
- **Semana 6:** Testes, otimizações e ajustes finais para garantir a estabilidade e usabilidade da aplicação.

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Análises de Risco" alt="Typing SVG" /></a>
1. **Atrasos no Desenvolvimento:** O tempo limitado pode levar a atrasos na entrega das funcionalidades, impactando o cronograma geral do projeto.
2. **Desafios de Integração:** A integração entre o backend e frontend pode apresentar dificuldades, especialmente na implementação do sistema de autenticação.
3. **Segurança dos Dados:** Existe o risco de vulnerabilidades relacionadas à autenticação e proteção de dados, o que requer medidas de segurança rigorosas.

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Recursos" alt="Typing SVG"/></a>
**Equipe:**
- 1 Gerente de Projetos
- 2 Desenvolvedores Full-Stack (Node.js e React)
- 1 Designer UI/UX
- 1 Administrador de Banco de Dados
- 1 Especialista em Segurança

**Tecnologias:**
- **Node.js** (Backend)
- **React** (Frontend)
- **MongoDB** (Banco de Dados)
- **JWT** (Autenticação)
- **Git/GitHub** (Controle de Versão)

**Ferramentas de Gestão:**
- Trello para gerenciamento de tarefas
- Slack para comunicação interna
- Figma para design de interfaces

<br><br><br><br><br>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=440&size=22&pause=1000&color=38F77CFF&center=false&vCenter=false&repeat=false&width=435&lines=Diagrama de Classe" alt="Typing SVG" /></a>

```mermaid
classDiagram
    class Usuario {
        +String nome
        +String email
        +String senha
        +login()
        +cadastro()
    }

    class Tarefa {
        +String titulo
        +String descricao
        +Date prazoMaximo
        +Boolean tarefaFeita
        +marcarComoCompletada()
    }

    class Auth {
        +String token
        +String generateToken()
        +Boolean verifyToken()
    }

    class TarefaController {
        +criarTarefa()
        +deletarTarefa()
        +atualizarTarefa()
        +visualizarTarefas()
    }

    class UsuarioController {
        +criarUsuario()
        +loginUsuario()
        +visualizarTarefasUsuario()
    }

    class Database {
        +connect()
        +disconnect()
        +query()
    }

    Usuario "1" --> "muitas" Tarefa : possui
    UsuarioController --> Usuario : gerencia
    TarefaController --> Tarefa : controla
    Auth --> Usuario : autenticação
    TarefaController --> Database : interage com
    UsuarioController --> Database : interage com
    Database --> MongoDB : usa
