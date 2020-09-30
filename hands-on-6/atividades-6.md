## Hands-on #6 - Transferindo Partidas entre Cliente e Servidor

#### Atividade 1 - Enviar uma requisição HTTP POST para o servidor com as partidas; servidor vai devolver as partidas (mesma da última atividade do hands-on #5)

- [ ] Utilizando a variável `$http` que o Angular nos fornece, envie uma requisição HTTP POST para o servidor (inclua as partidas na requisição)

  ```javascript
  $scope.save = function() {
      $http.post("http://localhost:5555", $scope.matches)
      	.then(
          	function(response) {
                  console.log(response.data);
              },
          	function(error) {}
      );
  }
  ```

  

- [ ] Envie a própria requisição como resposta de volta para o cliente

  - [ ] Ler os dados da requisição POST
  - [ ] Construir uma resposta HTTP
  - [ ] Enviar a resposta de volta no formato em bytes

- [ ] No cliente, Mostre essa resposta tanto no console, quanto na página




#### Atividade 2 - Enviar uma requisição HTTP GET para o servidor **através de código** e buscar algumas partidas que estavam salvas no servidor (adicione partidas manualmente)

- [ ] No servidor, criar a classe `Match`, que vai representar as partidas

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

  

- [ ] No servidor, criar um `ArrayList<Match>` para armazenar algumas partidas de forma manual.

  ```java
  public static void main() {
      // Criar Lista de Partidas
      ArrayList<Match> matches = new ArrayList();
      
      // Criar algumas partidas
      Match m1 = new Match();
      m1.setScoreA(1);
      m1.setScoreB(1);
      m1.setTeamA("Time A");
      m1.setTeamA("Time B");
      m1.setStatus("Encerrada");
      m1.setDone(true);
      
      Match m2 = new Match();
      m2.setScoreA(2);
      m2.setScoreB(2);
      m2.setTeamA("Time C");
      m2.setTeamA("Time D");
      m2.setStatus("Jogando");
      m2.setDone(false);
      
      // Adicionar partidas à lista    
      matches.add(m1);
      matches.add(m2);   
      
      // .... resto do código
      
  }
  ```

  

- [ ] No servidor, escreva o código para resolver uma requisição GET

  - [ ] Construa uma resposta HTTP que inclua o JSON do array de partidas

  - [ ] Para isso, precisa usar as bibliotecas `Jackson`: jackson-annotations, jackson-core, jackson-databind (essas bibliotecas transformam um `ArrayList` em um JSON e vice-versa)

    Core: https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.11.2/jackson-core-2.11.2.jar

    Annotations: https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.11.2/jackson-annotations-2.11.2.jar

    Databind: https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.11.2/jackson-databind-2.11.2.jar

  - [ ] Faça o código para transformar o `ArrayList<Match>` para JSON e envie de volta como resposta HTTP

    ```java
    ObjectMapper mapper = new ObjectMapper();
    String response = mapper.writeValueAsString(matches);
    dados.write(response.getBytes());
    ```

  - [ ] Veja a resposta no console do cliente (front-end)

  

#### Atividade 3 - Enviar uma requisição POST + partidas para o servidor através de código e salvá-las no ArrayList

- [ ] Utilizando a variável `$http` que o Angular nos fornece, envie uma requisição HTTP POST para o servidor (inclua as partidas na requisição)

  ```javascript
  $scope.save = function () {
      // Fazer uma requisição HTTP GET
      $http.post("http://localhost:5555", $scope.matches).then(
          function (response) {
              console.log(response.data);
          },
          function (error) {}
      );
  };
  ```

  

- [ ] Transforme o JSON que chegou em `ArrayList<Match>` 

  ```java
  ObjectMapper mapper = new ObjectMapper();
  
  // ArrayList<Match>
  String dadosString = dados.toString();
  Match[] matchesAux = mapper.readValue(dadosString, Match[].class);
  matches = Arrays.asList(matchesAux);
  ```

- [ ] As partidas já estão salvas no servidor. Faça um loop  `for`  mostrando (System.out.print) cada uma das partidas (só pra ver se funcionou)

  ```java
  for(Match m : matches) {
  
      System.out.println(
          "Status da Partida: " + m.getStatus() + "\n"
          + m.getTeamA() + " " + m.getScoreA() + " - " + m.getScoreB() + " " + m.getTeamB()
          + "\n\n"
      );
  }
  ```



#### Atividade 4: Dê um F5 no front-end, mas, dessa vez, puxe as partidas salvas no servidor

- [ ] Usando a variável `$http` do AngularJS, faça uma requisição GET HTTP e guarde as partidas no `$scope`

  ```javascript
  // Guardar todas as partidas em um Array
  $scope.matches = [];
  
  $http.get("http://localhost:5555").then(
      function (response) {
      $scope.matches = response.data;
      },
      function (error) {
      console.log("Deu erro");
      }
  );
  ```

- [ ] Pronto! O sistema deve estar funcionado



---

OBS.: Se o servidor reiniciar, os dados são perdidos. É pra resolver esse problema que existem os Bancos de Dados.

----

