## Hands-on #3

#### Atividade 1 - Componente simples

- [ ] Criar um componente `<cb-counter>`.

  ```javascript
  app.component("cbCounter", {
    template: `
  	<div>
  		<p>Contador: {{ count }}</p>
  		<button ng-click="add()">Adicionar</button>
  	</div>
  	`,
      controller: function($scope) {
          $scope.count = 0;
          
          $scope.add = function() {
              $scope.count++;
          }
      }
  });
  ```

- [ ] Usar o componente no HTML

  ```html
  <body>
      <cb-counter></cb-counter>
  </body>
  ```




#### Atividade 2 - Colocando o  template de um componente em um arquivo HTML separado

- [ ] Criar um arquivo `html` separado para guardar o código HTML do componente `<cb-counter>`

  ```html
  <!-- cb-counter.html -->
  <div>
      <p>Contador: {{ count }}</p>
      <button ng-click="add()">Adicionar</button>
  </div>
  ```

- [ ] Modificar a configuração do componente no javascript

  ```javascript
  app.component("cbCounter", {
    templateUrl: "cb-counter.html",
      controller: function($scope) {
          $scope.count = 0;
          
          $scope.add = function() {
              $scope.count++;
          }
      }
  });
  ```

  



#### Atividade 3 - Avançando com o projeto: criar um component para a lista de partidas

- [ ] Criar um arquivo separado para o código HTML da partidas

  ```html
  <h1>Partidas</h1>
  <button ng-click="save()">Salvar</button>
  <button ng-click="create()">Adicionar Partida</button>
  <div ng-repeat="match in matches" class="match">
    <div class="match">
      <!-- Time A -->
      <div class="match__team">
        <div class="match__team--bg"></div>
        <button
          class="match__team--control"
          ng-if="!match.done"
          ng-click="decreaseA(match)"
        >
          -
        </button>
        <input
          class="match__team--name"
          ng-disabled="match.done"
          type="text"
          ng-model="match.teamA"
        />
        <button
          class="match__team--control"
          ng-if="!match.done"
          ng-click="addA(match)"
        >
          +
        </button>
      </div>
      <!-- Placar -->
      <div class="match__score">
        <p>{{ match.status }}</p>
        <p>{{ match.scoreA }} - {{ match.scoreB }}</p>
        <p ng-if="!match.done">
          <a href="" ng-click="finish(match)">Finalizar</a>
        </p>
      </div>
      <!-- Time B -->
      <div class="match__team">
        <div class="match__team--bg"></div>
        <button
          class="match__team--control"
          ng-if="!match.done"
          ng-click="decreaseB(match)"
        >
          -
        </button>
        <input
          class="match__team--name"
          ng-disabled="match.done"
          type="text"
          ng-model="match.teamB"
        />
        <button
          class="match__team--control"
          ng-if="!match.done"
          ng-click="addB(match)"
        >
          +
        </button>
      </div>
    </div>
  </div>
  
  ```

- [ ] Criar um componente `<cb-match-list>`.

  ```javascript
  app.component("cbMatchList", {
      templateUrl: "cb-match-list.html",
      controller: function($scope) {
          $scope.matches = [];
          
          $scope.addA = function(match) {
              match.scoreA++;
          }
          $scope.addB = function(match) {
              match.scoreB++;
          }
          
          $scope.decreaseA = function(match) {
              match.scoreA--;
          }
          $scope.decreaseB = function(match) {
              match.scoreB--;
          }
          
          $scope.finish = function(match) {
              match.status = "Encerrada";
              match.done = true;
          }
      }
  })
  ```

  

- [ ] Modificar o HTML principal para usar o componente `<cb-match-list>`.
