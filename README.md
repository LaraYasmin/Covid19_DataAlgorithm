# Covid19_DataAlgorithm
Análise comparativa de algoritmos de ordenação aplicado a dados da COVID-19

Esse projeto foi desenvolvido com a finalidade de ordenar um arquivo base CSV com dados de todas as cidades do brasil para para gerar novos arquivos ordenados em ordem ascendente por Nomes de Cidades, Mortes Acumuladas e Quantidade de Casos usando vários algoritmos de ordenação conhecidos, o projeto também conta com uma análise de quantidade de tempo e consumo de memória de cada algoritmo que é mostrado no terminal durante a execução.

# Run
1) Esse projeto foi desenvolvido com a linguagem de programação java, antes de prosseguir, garanta que o java está corretamente instalado e configurado na sua máquina.

2) Clone esse projeto na sua máquina local ou vá até releases e baixe o código fonte do projeto

3) Vá até o site https://brasil.io/dataset/covid19/caso_full/ e gere um novo arquivo de dados para todas as cidades do Brasil com os seguintes filtros
![image](https://user-images.githubusercontent.com/42149534/132133606-590b6ea7-8d3f-4194-b765-09a13934bf51.png)

Então clique em FILTRAR e BAIXAR RESULTADOS EM CSV*
![image](https://user-images.githubusercontent.com/42149534/132133653-f4fa574f-a42a-497e-8dc1-a5bbcbd6b521.png)

4) Com o projeto aberto no seu editor de código, cole o arquivo de dados dentro da pasta database
![image](https://user-images.githubusercontent.com/42149534/132132635-6cef7856-1b1c-401a-a44a-56cb0ba5e163.png)

5) Copie o nome do arquivo e cole dentro da variável CSV_PATH presente na classe Main.java
![image](https://user-images.githubusercontent.com/42149534/132132676-9b0b1dbe-6cec-4ce0-af40-72e45b850aeb.png)

6) No terminal, com o projeto aberto, execute os comandos:
  	  <p>javac Main.java</p>
      <p>java Main</p>

Os arquivos ordenados por cada um os algoritmos de ordenação serão gerados dentro da pasta arquivos-csv e você também receberá um log completo de tempo e execução e consumo de memória no terminal.
