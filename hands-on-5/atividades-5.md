## Hands-on #5 - Ping-Pong Cliente x Servidor

#### Atividade 1 - Enviar uma requisição HTTP para o servidor; servidor vai devolver exatamente a requisição para o cliente

- [ ] Provoque uma conexão entre cliente e servidor através do navegador: acesse http://localhost:5555 (ou seja, faça uma requisição ao servidor)

- [ ] No servidor, envie uma resposta de volta para o cliente mostrando **exatamente** a mensagem da requisição HTTP.

  - [ ] Após receber a conexão, construa uma String contendo a requisição que chegou, mostre-a no console do servidor e envie de volta para o cliente

    ```java
    // Aguardando conexão...
    Socket connection = server.accept();
    
    // Pegar os dados que estão chegando
    InputStream dadosChegando = connection.getInputStream();
    
    // Colocar os dados que estão chegando em um objeto que consegue ler os bytes
    InputStreamReader leitorBytes = new InputStreamReader(dadosChegando);
    
    // Colocar os bytes lidos em um objeto que consegue transformá-los para String
    BufferedReader leitorString = new BufferedReader(leitorBytes);
    
    String response = "";
    
    while (true) {
        String line = leitorString.readLine();
        
        if (line.isEmpty()) {
        	break; // sair do loop    
        } 
        
        response += line + "\n";
        
    }
    
    System.out.println(response);
    
    // Transformar a resposta para bytes
    byte[] bytesResponse = response.getBytes();
    
    // Enviar a resposta
    connection.getOutputStream().write(bytesResponse);
    
    // fechar o servidor
    server.close();
    
    
    ```

    

- [ ] Analise a mensagem de requisição para entender o protocolo HTTP (verifique que é uma requisição GET)




#### Atividade 2 - Enviar uma requisição HTTP GET para o servidor **através de código**

- [ ] Utilizando a variável `$http` que o Angular nos fornece, envie uma requisição HTTP GET para o servidor

- [ ] No servidor, envie a própria requisição como resposta de volta para o cliente

- [ ] No cliente, mostre essa resposta tanto no console, quanto na página

- [ ] Analise como a requisição GET HTTP é montada

  

#### Atividade 3 - Enviar uma requisição POST + dados para o servidor através de código

- [ ] Utilizando a variável `$http` que o Angular nos fornece, envie uma requisição HTTP POST para o servidor (inclua as partidas na requisição)

- [ ] Envie a própria requisição como resposta de volta para o cliente
- [ ] No cliente, Mostre essa resposta tanto no console, quanto na página
- [ ] Analise como a requisição POST HTTP é montada (e compare com a requisição GET de antes).


