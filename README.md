**ÁRVORE BINÁRIA DE PESQUISA**

_Sobre o projeto:_
 - Lê números de um arquivo (entrada.txt)
 - Constrói a árvore
 - Busca o último número da entrada
 - Gera arquivos com diferentes caminhamentos e o resultado da busca

_Como Funciona:_
 - Lê os valores do entrada.txt
 - Insere os valores na árvore
 - Usa o último valor como chave de busca
 - Gera caminhamentos da árvore
 - Realiza busca e salva o caminho percorrido

 - Exemplo de entrada:
   50
   30
   70
   20
   40
   80
   60
   
 - Chave de busca: 60
   - Pré-Ordem: Raiz → Esquerda → Direita (resposta: 50 30 20 40 70 60 80)
   - Pós-Ordem: Esquerda → Direita → Raiz (resposta: 20 40 30 60 80 70 50)
   - Central (In-Order): Esquerda → Raiz → Direita (resposta: 20 30 40 50 60 70 80)
   - Largura: Por nível, da esquerda para a direita (resposta: 50 30 70 20 40 60 80)
   - Resultado: chave, nodos visitados, total, achou/não achou (resposta: chave a ser localizada: 60; nodos visitados: 50 70 60; quantidade de nodos visitados: 3; achou)

_Informações importantes para rodar o projeto:_
 - Ter Java instalado (preferencialmente a versão mais recente, Java 24) e ter uma IDEA que rode programas em Java (ex: Intellij-recomendado-, Visual Studio Code, ...).
 - Compilar classe App após inserir os valores no arquivo entrada.txt


_**Realizaado por Carolina de Souza Gonçalves e Ana Clara Purper**_
