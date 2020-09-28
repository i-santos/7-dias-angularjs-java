## Hands-on #4

#### Atividade 1 - Fazer o Java funcionar

- [ ] Instalar o JDK (pode ser em qualquer versão, mas vou usar a versão 11).

  Link para instalação: https://adoptopenjdk.net/

  Siga as instruções: adicionar variável de ambiente e adicionar "java.home" no VSCode. Qualquer dúvida, pode entrar em contato comigo

- [ ] Instalar a extensão para Java no VSCode

  Nome da extensão: Java Extension Pack (um pacote com várias extensões)

- [ ] Apertar CTRL + SHIFT + P no VSCode e procurar `Java: Create Java Project...`

  - [ ] Escolha uma pasta para criar um novo projeto Java

- [ ] Apertar F5 para rodar o `Hello World` e ver se tudo está funcionando




#### Atividade 2 - Criar o mais simples dos servidores

- [ ] Instancie um `ServerSocket` (pode ser na porta 5555 mesmo)

  ```java
  // Instanciar socket
  ServerSocket server = new ServerSocket(5555);
  ```
  
- [ ] Coloque o servidor para esperar uma conexão

  ```java
  // Escutar (esperar) uma nova conexão
  Socket connection = server.accept();
  ```
  
- [ ] Ao receber uma nova conexão, Printar no console uma nova conexão foi recebida e encerrar o servidor

  ```java
  System.out.println("New connection!");
  // Fechar o servidor
  server.close();
  ```

- [ ] Abrir uma conexão com o servidor a partir do navegador (http://localhost:5555)

- [ ] Verificar o console do servidor.

- [ ] Verificar que o navegador informa que não recebeu nenhuma resposta do servidor (afinal, o servidor **realmente não respondeu nada**)

---

OBS.: Esse servidor não responde nada. Ou seja, não envia nenhum dado de resposta.

Esse servidor é apenas para efeitos didáticos (para ver como um servidor funciona).

Ele apenas recebe uma nova conexão e depois encerra a execução do programa.

----



#### Atividade 3 - Enviar uma resposta ao receber uma requisição (continuação da atividade 2)

- [ ] Montar uma resposta informando a quantidade de bytes que o servidor recebeu na requisição.

  ```java
  // Iniciar servidor
  ServerSocket server = new ServerSocket(5555);
  
  // Aguardar conexão...
  System.out.println("Waiting for connection...");
  Socket connection = server.accept();
  
  // Ler a quantidade de bytes do fluxo de entrada da requisição
  int nBytes = connection.getInputStream().read();
  
  // Montar uma resposta
  String response = "Bytes recebidos: " + nBytes;
  // Transformar a resposta para bytes
  bytes[] bytesResponse = response.getBytes();
  
   // Enviar a resposta
  connection.getOutputStream().write(bytesResponse);
  
  // Fechar o servidor
  server.close();
  ```
  
- [ ] Abrir uma conexão com o servidor a partir do navegador (http://localhost:5555)

- [ ] Verificar o console do servidor.

- [ ] Verificar que o navegador informa que recebeu uma resposta em um formato inválido (afinal o servidor **não** enviou uma resposta no formato HTTP)



#### Atividade 4 - Enviar uma resposta HTTP (continuação da atividade 3)

- [ ] Ao invés de simplesmente devolver uma `String` qualquer como resposta, envie uma `String` seguindo o protocolo HTTP

  ```java
  // Iniciar servidor
  ServerSocket server = new ServerSocket(5555);
  
  // Aguardar conexão...
  Socket connection = server.accept();
  
  // Ler quantos bytes chegaram
  int nBytes = connection.getInputStream().read();
  
  // Resposta em formato HTTP Response:
  //	1ª linha: Versão do HTTP + código de resposta
  //	2ª linha: Definir o tipo de conteúdo de resposta "Content-Type"
  //	Pular DUAS linhas para construir o corpo: o corpo é a própria resposta
  String response = 
      "HTTP/1.1 200 OK\n" 
      + "Content-Type: text/html\n\n"
      + "<h6>Bytes recebidos: " + nBytes + "</h6>";
  
  // Enviar a resposta
  connection.getOutputStream().write(response.getBytes());
  
  // Fechar o servidor
  server.close();
  ```

  

#### Desafio - Enviar uma resposta no formato JSON