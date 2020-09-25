## Hands-on #1

#### Atividade 1 - Criando o projeto e conectando as peças

-   [x] Criar index.html

-   [x] Incluir biblioteca do AngularJS

    ```html
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
    ```

-   [x] Criar módulo (dar o gerenciamento dos dados da página HTML para o Angular)

    ```javascript
    var app = angular.module("app", []);
    ```

-   [x] Criar função controladora (criar uma função para controlar o acesso e a modificação dos dados e adicionar no módulo do Angular)

    ```javascript
    app.controller("MainController", function ($scope) {
        /**
         * Aqui vem o código da função controladora (MainController)
         */
    });
    ```

-   [x] Adicionar as variáveis e as funções ao escopo da controladora

    ```javascript
    // Essa é a função controladora
    function($scope){
        // criar variáveis dentro do escopo da função controladora
        $scope.score = 0;

        $scope.add = function() {
            this.score++;
        }
    }
    ```

-   [x] Usar as variáveis e as funções de forma reativa e descritiva no HTML

    ```html
    <div ng-controller="MainController">
        <p>Pontuação: {{ score }}</p>
        <button ng-click="add()">Adicionar ponto</button>
    </div>
    ```

#### Atividade 2 - Avançando com o projeto

-   [ ] Adicione o css à vontade para estilizar a página

-   [ ] Adicione mais variáveis/funções para controlar mais dados (use o JSON)

    ```javascript
    // Essa é a função controladora
    function($scope){
        // criar variáveis dentro do escopo da função controladora

        // variável match é um Objeto JavaScript
        $scope.match = {
            scoreA: 0,
            scoreB: 0,
            teamA: 'Amigos do Cérebro',
            teamB: 'Amigos do Binário',
            status: 'Jogando',
            done: false,
            result: ''
        };

        $scope.addA = function() {
            this.match.scoreA++;
        }
        $scope.decreaseA = function() {
            this.match.scoreA--;
        }

        $scope.addB = function() {
            this.match.scoreB++;
        }
        $scope.decreaseB = function() {
            this.match.scoreB--;
        }

        $scope.finish = function() {
            this.match.done = true;
            this.match.status = 'Encerrada';

            const { scoreA, scoreB, teamA, teamB } = this.match;

            if(scoreA > scoreB) {
                this.result = `${teamA} venceu`;
            } else if (scoreB > scoreA) {
                this.result = `${teamB} venceu`
            } else {
                this.result = 'Empatou';
            }
        }

        $scope.save = function() {
            alert('TODO: enviar para o Java (server) para salvar no BD:\n\n' + this.match);
        }
    }
    ```
