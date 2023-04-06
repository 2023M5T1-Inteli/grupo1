<table>
<tr>
<td>
<a href= "https://ael.com.br/"><img src="https://www.ael.com.br/images/ael.png" alt="AEL Sistemas" border="0" width="70%"></a>
</td>
<td><a href= "https://www.inteli.edu.br/"><img src="https://www.inteli.edu.br/wp-content/uploads/2021/08/20172028/marca_1-2.png" alt="Inteli - Instituto de Tecnologia e Liderança" border="0" width="30%"></a>
</td>
</tr>
</table>

# Projeto: *Power Routes Generator*

# Grupo: *AeroGuys*

# Descrição

  Uma aplicação web geradora de rotas visando a baixa altitude, e pra esse fim, contém um algoritmo planejador. Para a criação do algoritmo planejador, utilizasse o A-star com o objetivo de encontrar o menor caminho dentre um grafo, este algoritmo de menor caminho usufrui de uma heurísitca que correlaciona nossas principais variáveis (distância e altitude).


# Documentação

Os arquivos da documentação deste projeto estão na pasta [/docs](/docs), e o seu conteúdo é publicado em https://2023m5t1-inteli.github.io/grupo1.


# Artigo

Os arquivos do artigo estão na pasta [/artigo](/artigo). Um arquivo gerado no formato PDF deverá ser anexado a cada *release* do projeto.

# Guia de Instalação

Nesta seção irá conter o passo a passo para rodar nossa aplicação:

**Primeiro passo:**

Para a utilização da aplicação é necessário baixar o docker, vá na página oficial do Docker neste [link](https://www.docker.com/products/docker-desktop/) e clique para dar download no seu sistema operacional específico, como mostra a imagem abaixo com o sistema operacional Windows:

![imagem do download do Docker](../grupo1/docs/img/docker_download.png)

**Segundo passo:**

Vá até o terminal em qualquer pasta e rode o comando, que irá acionar a imagem no Docker:

```
docker run --publish=7474:7474 --publish=7687:7687 -e NEO4J_AUTH=neo4j/12341234 neo4j:latest
```

**Terceiro passo:**

Com o projeto aberto no vscode, vá até o arquivo MainApplication.java e no próprio arquivo clique em "Run":

![imagem de arquivo](../grupo1/docs/img/roda_aplicacao.png)

# Releases

Deverá ser publicado um release ao término de cada *sprint* do projeto.
