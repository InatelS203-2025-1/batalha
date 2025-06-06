# ⚔️ Sistema de Batalha

Bem-vindo ao **Sistema de Batalha**! Este projeto é responsável por gerenciar as batalhas entre os Pokémons dos jogadores, utilizando regras específicas de combate, turnos e probabilidades com base nos tipos dos Pokémons.  
Desenvolvido com **Java + Spring Boot** utilizando a arquitetura **MVC** e **SOA**.

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

## 🧩 Integração com SOA

Este projeto segue os princípios de **Arquitetura Orientada a Serviços (SOA)**, onde a aplicação atua como **consumidora de serviços externos** e também fornece **dados para outros módulos** do sistema.

- 🔐 **Autenticação**: Consome o serviço de autenticação para validar os jogadores.
- 🎴 **Distribuição de cartas**: Obtém os Pokémons disponíveis de outro serviço.
- 🎯 **Criação e gestão de partidas**: Se comunica com o sistema de gerenciamento de partidas.
- 🗂️ **Histórico de batalhas**:  
  Ao final de cada partida, os dados do confronto (vencedor, rodadas, pokémons usados, etc.) são armazenados e expostos para **outros serviços** consumirem (ex: estatísticas, ranking, perfil do jogador).

> Isso promove um sistema desacoplado e reutilizável, onde cada aplicação desempenha um papel específico e se comunica através de **APIs bem definidas**.

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
cd batalha

# 3. Compile o projeto
mvn clean install

# 4. Rode a aplicação
mvn spring-boot:run
