# Biblioteca

## INTEGRANTES
- Arthur Alves de Sousa - UC22102156 
- Cauã Nunes de Lima Sales - UC22100876
- Eraim de Jesus Farias Costa - UC22102451 
- Mariana de Sousa Guarino - UC22101714

## Descrição do Projeto
Este projeto implementa um servidor de biblioteca em Java utilizando sockets para comunicação cliente-servidor para manipulação de JSON.

## Execução do Programa
Para executar o servidor, rode a classe `Server`. O servidor estará pronto para aceitar conexões na porta 1010 e processar requisições de clientes, em seguida rode a classe `Cliente`.

## Funcionalidade da Classe `Server`
A classe Server possui a função de iniciar e gerenciar o servidor de biblioteca, sendo responsável por carregar o catálogo de livros a partir de um arquivo JSON, aceitar conexões de clientes e iniciar threads para gerenciar essas conexões.

Aqui está uma descrição detalhada das principais responsabilidades da classe Server:

### Principais Responsabilidades
1. **Carregamento do Catálogo de Livros**:
   - O construtor chama `carregarCatalogo` para ler o arquivo JSON (`livros.json`) e carregar o catálogo de livros usando Gson.

2. **Inicialização do Servidor**:
   - O método `iniciarServidor` cria um `ServerSocket` na porta 1010, aceita conexões de clientes e inicia uma nova thread para cada cliente conectado.

3. **Gestão de Conexões de Clientes**:
   - Cada cliente conectado é gerenciado por uma thread `ControleCliente`, permitindo múltiplas conexões simultâneas e independentes.

### Métodos
- **`carregarCatalogo`**: Lê o arquivo JSON e retorna um objeto `CatalogoLivros`.
- **`lerJson`**: Lê o conteúdo do arquivo JSON e converte para `CatalogoLivros` usando Gson.
- **`iniciarServidor`**: Inicializa o `ServerSocket` e gerencia conexões de clientes.

