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
- 🧮 Cálculo de dano baseado no tipo de ataque do Pokémon e nas regras específicas do jogo.
- 🏆 A batalha é conduzida em turnos com ataques, defesas e cálculo de dano.
- 📤 Um histórico das batalhas é registrado localmente.

---

## 🧱 Arquitetura - MVC (Model-View-Controller)

A aplicação segue o padrão arquitetural **MVC**:

- **Model**:  
  Representa os dados do domínio, como `Pokemon`, `Ataque`, `Tipo`, `Rodada`, entre outros.

- **Controller**:  
  Responsável por receber as requisições da aplicação cliente, como iniciar uma batalha, registrar uma ação, etc.

- **View (Regras de Jogo)**:  
 Como o projeto é console-based no momento, a interação ocorre via terminal.

---

## 🧩 Integração com SOA

Este projeto segue os princípios de **Arquitetura Orientada a Serviços (SOA)**, onde a aplicação atua como **consumidora de serviços externos** e também fornece **dados para outros módulos** do sistema.

✅ 1. Serviço Externo Consumido:
📡 Consulta à Pokédex:
- Ao escolher um Pokémon, o sistema consulta a API da Pokédex e adapta os dados recebidos para a classe interna Pokemon através da PokedexAdapter.

✅ 2. Exposição de Serviço Interno: Histórico de Batalhas
- Ao final de cada batalha, o resultado é salvo localmente (atualmente em arquivo .json e planejado para ser armazenado no banco de dados PostgreSQL).

- Esse histórico será futuramente acessível por outros módulos do sistema ou clientes externos por meio de uma API REST.

> Isso promove um sistema desacoplado e reutilizável, onde cada aplicação desempenha um papel específico e se comunica através de **APIs bem definidas**.

---

## 🛠️ Design Patterns Aplicados

| Padrão         | Onde foi aplicado                                          | Finalidade                                                                       |
| -------------- | ---------------------------------------------------------- | -------------------------------------------------------------------------------- |
| Strategy       | Classes de ataque: AtaqueForte, AtaqueNormal, AtaqueRapido | Permite definir diferentes comportamentos de ataque de forma dinâmica            |
| Factory Method | Classe PokemonFactory                                      | Facilita a criação de Pokémons com configurações pré-definidas                   |
| Adapter        | Classe PokedexAdapter (simulada)                           | Adapta dados de uma fonte externa (ex: Pokédex) para o modelo interno do sistema |

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
