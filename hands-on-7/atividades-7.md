## Hands-on #7 - Usando o Spring para criar o servidor

#### Atividade 1 - Instale todas as extensões do VSCode

- [ ] Instalar as extensões:
- [ ] Java Extension Pack
  - [ ] Spring Initializr Java Support (Microsoft)




#### Atividade 2 - Criar um projeto Spring (usando o Spring Initializr)

- [ ] Aperte CTRL + SHIFT + P para abrir o painel de comandos do VSCode

- [ ] Digite "Java" e selecione a opção "Java: Create Java Project..."

- [ ] Agora, selecione a opção "Spring Boot". Preste atenção na descrição dessa opção: "Provided by Spring Initializr Java Support" (a extensão que instalamos antes)

- [ ]  Selecione "Maven project"

- [ ] Escolha a primeira versão que aparecer. No meu caso, é a 2.3.4

- [ ] Seleciona a linguagem a ser utilizada: Java

- [ ] Digite o domínio da empresa de trás pra frente (pode ser qualquer coisa)

  Exemplo: com.cerebrobinario

  Pode ser: com.meuservidorjava, enfim, qualquer coisa

- [ ] Agora escreva o nome do projeto: matches, por exemplo

- [ ] Selecione JAR

- [ ] E especifique a versão do Java instalado no seu PC. No meu caso, é o Java 11

- [ ] Agora, é a hora de escolher as dependências do projeto (vamos usar apenas uma)

  - [ ] Selecione Spring Web e aperte 'Enter' para continuar. Essa dependência vai baixar várias bibliotecas que geram o nosso servidor.

    São essas bibliotecas que vão fazer nosso servidor rodar e entender HTTP (e vai ajeitar tudo pra gente pra ficar **muito mais fácil programar**).

    Não vamos mais precisar ficar processando os dados de entrada/saída e ficar fazendo lógica pra decifrar o HTTP.

- [ ] Selecione a pasta na qual o projeto será criado.

- [ ] Abra a pasta do projeto no VSCode.

- [ ] Veja que dentro do projeto existe a pasta 'src' (onde ficam nossas Classes Java) e o programa 'mvnw' que vai compilar nosso projeto.

  Obs.: mvnw é uma abreviação de Maven Wrapper.

- [ ] Rode o projeto pra ver se funcionou



#### Atividade 3 - Cria a classe Match e a classe MatchController e configure para conseguir salvar e devolver as partidas

- [ ] Criar a classe `Match`

  ```java
  class Match {
      private int scoreA;
      private int scoreB;
      private String teamA;
      private String teamB;
      private String status;
      private boolean done;
      
      // Adicionar os getters e setters (Java básico)
  }
  ```

- [ ] Criar a classe MatchController

  ```java
  package com.example.matches;
  
  import java.util.ArrayList;
  import java.util.List;
  
  public class MatchController {
      
      private List<Match> matches = new ArrayList<>();
  
      public List<Match> getMatches() {
          return this.matches;
      }
  
      public void setMatches(List<Match> matches) {
          this.matches = matches;
      }
  }
  
  ```

- [ ] Configure a classe MatchController para receber requisições GET e POST

  ```java
  @RestController
  public class MatchController {
      
      private List<Match> matches = new ArrayList<>();
  
      @GetMapping
      public List<Match> getMatches() {
          return this.matches;
      }
  
      @PostMapping
      public void setMatches(@RequestBody List<Match> matches) {
          this.matches = matches;
      }
  }
  ```

  

### Atividade 4 - Modificar o front-end pra funcionar com o servidor Spring