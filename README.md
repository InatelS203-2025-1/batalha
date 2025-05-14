# ⚔️ Sistema de Batalha 

Bem-vindo ao **Sistema de Batalha**! Este projeto é responsável por gerenciar as batalhas entre os Pokémons dos jogadores, utilizando regras específicas de combate, turnos e probabilidades com base nos tipos dos Pokémons.  
Desenvolvido com **Java + Spring Boot** utilizando a arquitetura **MVC**.  
Este projeto **consome APIs** externas para autenticação, distribuição de cartas e gestão de partidas.

---

## 📦 Tecnologias Utilizadas

- ☕ Java 17+
- 🌱 Spring Boot
- 🧪 JUnit (para testes)
- 🔗 Consumo de APIs REST
- 🧰 Maven (gerenciamento de dependências)

---

## 🧠 Funcionalidades

- 🎮 Realiza batalhas entre dois jogadores com até 5 rodadas.
- 🔁 Alternância entre jogadores por rodada.
- 🧮 Cálculo de dano baseado no tipo do Pokémon e nas regras específicas do jogo.
- 🏆 Determina o vencedor com base no maior número de rodadas ganhas.
- 📤 Retorna o resultado da partida para o sistema de gestão de partidas.

---

## 🧱 Arquitetura - MVC

A aplicação segue o padrão arquitetural **MVC**:

- **Model**:  
  Representa os dados do domínio, como `Pokemon`, `Ataque`, `Tipo`, `Rodada`, entre outros.

- **Controller**:  
  Responsável por receber as requisições da aplicação cliente, como iniciar uma batalha, registrar uma ação, etc.

- **View (Regras de Jogo)**:  
  Implementa a lógica da batalha, como cálculo de dano, verificação de tipos, regras por rodada, entre outros.

---

## 🚀 Como executar o projeto localmente

### Pré-requisitos

- Java 17+
- Maven 3.8+
- IDE de sua preferência (IntelliJ, Eclipse, VS Code...)

### Passos para rodar o projeto:

```bash
# 1. Clone o repositório
git clone

# 2. Navegue até o diretório do projeto
cd nome-do-repositorio

# 3. Compile o projeto
mvn clean install

# 4. Rode a aplicação
mvn spring-boot:run
