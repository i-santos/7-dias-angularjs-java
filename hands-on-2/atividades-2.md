## Hands-on #2

#### Atividade 1 - Vários Objetos JavaScript guardados em uma só variável

-   [ ] Criar outra partida da maneira "burra" (fazer isso pra praticar e pra **sentir a burrice na pele**)

-   [ ] Salvar a `index.html` burra pra poder estudar depois

- [ ] Refatorar o código: identificar o padrão e eliminar a repetição

  -   [ ] Criar uma só variável pra guardar todas as partidas (um array)

  ```javascript
  app.controller("MainController", function ($scope) {
      
      $scope.matches = [];
  });
  ```

  -   [ ] Adicionar algumas partidas no array

  ```javascript
  app.controller("MainController", function ($scope) {
      
      var match1 = {
          scoreA: 0,
          scoreB: 0,
          teamA: 'Amigos do Cérebro',
          teamB: 'Amigos do Binário',
          status: 'Jogando',
          done: false,
      };
      var match2 = {
          scoreA: 0,
          scoreB: 0,
          teamA: 'Amigos do Cérebro',
          teamB: 'Amigos do Binário',
          status: 'Jogando',
          done: false,
      };
      
      $scope.matches = [match1, match2];
  });
  ```

  -   [ ] Ao invés de guardar os JSON das partidas em variáveis, substituir o código pra guardá-los diretamento no array (importante para acostumar a ler JSON).

  ```javascript
  app.controller("MainController", function ($scope) {   
      $scope.matches = [{
          scoreA: 0,
          scoreB: 0,
          teamA: 'Amigos do Cérebro',
          teamB: 'Amigos do Binário',
          status: 'Jogando',
          done: false,
      }, {
          scoreA: 0,
          scoreB: 0,
          teamA: 'Amigos do Cérebro',
          teamB: 'Amigos do Binário',
          status: 'Jogando',
          done: false,
      }];
  });
  ```

-   [ ] Agora, puxar todas as partidas do array para o HTML usando o `ng-repeat`

```html
<div ng-controller="MainController">
    <div ng-repeat="match in matches">
        <!-- HTML da partida, puxando todos os dados -->
    </div>
</div>
```

​	O `ng-repeat` faz com que não precisemos saber a quantidade de partidas previamente (se tiver 2 ou 150 partidas, o código continua funcionando).





#### Atividade 2 - Avançando com o projeto: botão para adicionar partida dinamicamente

-   [ ] Adicione um botão para criar uma nova partida

-   [ ] Crie uma função na controladora para adicionar uma nova partida ao array (e conecte essa função ao botão)

-   [ ] Veja a "mágica" a acontecer na tela: uma nova partida aparece no site. Nesse momento,  a página está **reativa**. As coisas simplesmente vão acontecendo porque o angularJs nos ajudou a construir uma lógica para mostrar e manipular os dados no site.

-   [ ] Refaça o código todo do zero para praticar e assimilar melhor o conteúdo

    
