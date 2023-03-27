---
title: Modelo para o artigo do Módulo 5
author: Professores do Módulo 5 - Inteli
date: Janeiro de 2023
abstract: Como parte das atividades do módulo 5, cada grupo deverá redigir um texto descrevendo os resultados do projeto no formato de um artigo científico. Este arquivo no formato markdown contém a estrutura básica deste artigo. Cada grupo deverá editar este arquivo com a descrição do projeto que desenvolveu.
---

# Introdução

O processo de realização de voos em baixa altitude de modo a aumentar a cobertura oferece variados tipos de riscos, os quais englobam: colisão com o solo (CFIT); exposição ao inimigo; áreas propensas a interceptação de radares, além de regiões densamente povoadas. Para Dorsett e Wyskida (1985), "a capacidade dos modernos sistemas de defesa aérea forçou as aeronaves militares a utilizar voos de baixa altitude para evitar a detecção e aumentar a capacidade de sobrevivência". Conforme o avanço tecnológico, novas táticas e estratégias são cada vez mais demandadas por parte da aviação militar. Desse modo, "a forma da trajetória deve conseguir garantir um voo seguro em condições mínimas de tempo e consumo de energia considerando as limitações de colisão do terreno" (KOSARI et al., 2018).

A construção de uma trajetória de voo de referência é a etapa mais importante e, "à medida que as missões requerem voos em baixa altitude, sobrevoar principalmente em terrenos acidentados é consideravelmente mais desafiador e requer conhecimento prévio de elevação do terreno" (CAMPOS et al., 2016). Esses aspectos aumentam a necessidade da implementação de ferramentas de controle que assegurem a segurança e eficiência para esse tipo de voo, englobando o planejamento de condução da aeronave em devidas localidades a serem percorridas e o seu potencial de voo.

Tendo em vista essa necessidade, enquanto houver a implementação de tecnologias auxiliares que contornam trajetos que evadam restrições, o levantamento próximo ao solo coleta detalhes que não são visíveis ao sobrevoar em altitudes mais elevadas (MELITA et al., 2020). No entanto, a sua ausência reforça as ameaças presentes em voos de baixa altitude, de modo que represente resultados abaixo do desejado e não aproveite feições geográficas vantajosas para a otimização do percurso. A seleção de uma rota de voo baixo que uma aeronave adere pode ser usada a favor da penetração na cobertura de defesa aérea, enquanto, ao mesmo tempo minimiza a exposição e abate (DORSETT; WYSKIDA, 1985). Visto que essa seleção, com o auxílio de uma ferramenta específica de controle de voo, possibilita uma missão finalizada com segurança.

Os bancos de dados orientados a grafos se configuram como uma solução promissora para lidar com os desafios de planejamento e controle de voos em baixa altitude. Tais bancos de dados possuem grande potencial para lidar com informações espaciais, como a elevação do terreno e outras características geográficas que são relevantes para o planejamento de rotas de voo. A utilização desses bancos de dados é capaz de representar, de maneira eficiente e intuitiva, dados geoespaciais complexos, permitindo que informações críticas sejam integradas e utilizadas para apoiar a tomada de decisões no processo de planejamento de rotas de voo (MELITA et al. 2020).

Além disso, os bancos de dados orientados a grafos podem ser utilizados para modelar as redes de defesa aérea, permitindo que informações sobre as áreas que são propensas a interceptação de radares e outros riscos sejam integradas ao processo de planejamento de rotas. A utilização de bancos de dados orientados a grafos é capaz de permitir o fácil acesso e integração das informações relativas à rede de defesa aérea com as informações geoespaciais pertinentes ao planejamento de rotas de voo (KOSARI et al. 2018).

De acordo com Campos et al. (2016), a utilização de tecnologias de banco de dados capazes de lidar com informações geoespaciais é fundamental para assegurar um voo seguro e eficiente em condições mínimas de tempo e consumo de energia, considerando as limitações de colisão do terreno e outros riscos associados aos voos de baixa altitude. Destarte, a utilização de bancos de dados orientados a grafos pode contribuir de maneira significativa para o planejamento e controle de voos em baixa altitude, permitindo que as informações espaciais e de rede sejam integradas de forma eficiente e utilizadas para apoiar a tomada de decisões no processo de planejamento de rotas.

Para a resolução do problema de planejamento de trajetórias em voos de baixa altitude, o artigo científico utiliza o banco de dados Neo4J com Java, com o objetivo de construir uma aplicação que recebe dois pares de coordenadas e cria uma área com pontos igualmente distribuídos em uma resolução x, priorizando menores altitudes nos trajetos e menores distâncias.

A escolha por um banco de dados orientado a grafos é uma solução promissora para lidar com informações espaciais, como a elevação do terreno e outras características geográficas relevantes. Esses bancos de dados são capazes de representar, de maneira eficiente e intuitiva, dados geoespaciais complexos, permitindo que informações críticas sejam integradas e utilizadas para apoiar a tomada de decisões no processo de planejamento de rotas de voo.

MELITA et al. (2020) afirmam que a utilização de bancos de dados orientados a grafos tem se mostrado eficiente para lidar com informações espaciais, permitindo que informações críticas sejam integradas e utilizadas para apoiar a tomada de decisões no processo de planejamento de rotas de voo. KOSARI et al. (2018) também apontam que bancos de dados orientados a grafos são úteis na modelagem de informações geoespaciais, uma vez que permitem a representação de informações geográficas complexas de maneira intuitiva.

De mesmo modo, Campos et al. (2016) destacam que o Neo4J é uma opção promissora para a modelagem de informações geográficas, pois é capaz de lidar com dados geográficos de grande volume e complexidade, tornando-se uma ferramenta viável para o planejamento de rotas de voo. Dessa forma, a escolha do banco de dados Neo4J para a resolução do problema de planejamento de trajetórias em voos de baixa altitude parece ser uma opção adequada e eficiente, em consonância com as recomendações apresentadas na literatura científica.

# Descrição do problema

# Trabalhos relacionados

# Descrição da estratégia adotada para resolver o problema

# Análise da corretude da solução proposta

Para encontrar o caminho menos custoso partindo de um vértice A a um vértice B em um determinado grafo, o algortimo de processamento escolhido foi o A* pathfinding. Ele é construído a partir uma lógica baseada na análise dos nós desse grafo usando uma lista de prioridade de vértices a serem analisado (aberta), uma lista daqueles que já foram analisados (fechada) e, seu principal diferencial, uma estimativa de custo da adição de um determinado nó ao caminho (heurística).

## Heurística

Com o intuito de reduzir processamento desnecessário, o algoritmo A* se baseia em uma estratégia de tomada de decisão sempre que um nó está sendo analisado. Nesse sentido, cada vértice respeita a seguinte fórmula

$f(v) = g(v) + h(v)$

Sendo: $g(v)$ o custo de chegar ao vértice atual partindo do início da trajetória, $h(v)$ o custo estimado de chegar ao fim da trajetória partindo do vértice atual, e $f(v)$ o custo total relacionado ao vértice em questão.

O fator $g(v)$ é calculado através da soma dos pesos de cada aresta pertencente ao caminho encontrado que liga o nó de início da trajetória ao vértice atual.

Já $h(v)$ é a heurística em si: usando essa estratégia, o algortimo deixa de analisar vértices que, muito provavelmente, não entrariam no caminho com o menor custo possível. Com isso, os vértices são organizados na fila aberta de acordo com seu custo. Essa heurística deve ser admissível e consistente - nunca estimando um valor superior ao real custo de chagar ao nó de destino.

Na aplicação, a heurística adotada é calculada através da soma entre a distância em linha reta e a variação de altitude relativao do nó em análise ao nó final da trajetória - o mesmo cálculo usado para dar peso às arestas.

## Consistência

No que tange à funcionalidade, o que garante a eficiência e a corretude do algoritmo A* é, além da adoção de uma heurística eficaz, a lógica de troca dos nós entre as filas abertas e fechadas. Sendo assim, pode-se dizer que a invariante do laço do A* é que, a cada iteração, o nó alcançado com o menor valor de f(n) está no topo da fila de prioridade e, por conseguinte, é escolhido para expansão. Com isso, o algoritmo sempre explora primeiro o caminho mais promissor dentre os possíveis Além disso, a lógica também assegura que, após ser expandido, um nó sai da fila aberta e vai para a lista fechada. Nesse sentido, também há uma checgem que avalia cada nó alcançado e garante que nenhum nó dentro da fila fechada será explorado novamente.

# Análise da complexidade da solução proposta

Como citado anteriormente, o algoritmo A* é um algoritmo de busca de caminho que encontra o caminho mais curto de um nó inicial a um nó objetivo em um grafo ponderado. O que o diferencia de outros algoritmos é o fato dele usar uma heurística para orientar a busca na direção do objetivo. O funcionamento do algoritmo A* é baseado em uma função de custo f(n) = g(n) + h(n), onde g(n) é o custo acumulado do nó inicial até o nó atual n e h(n) é uma estimativa heurística do custo do nó atual n até o nó objetivo. A função heurística adotada neste trabalho, como citado na seção anterior, é a distância do ponto atual até o ponto final acrescida da variação de altitude entre o ponto atual e o ponto final.

No pior caso, quando a heurística não é admissível e não orienta adequadamente a busca na direção do objetivo, o algoritmo terá de verificar todos os nós e arestas do grafo até encontrar o menor caminho. No entanto, no melhor caso, o algoritmo A* pode encontrar o caminho mais curto em tempo constante, se o objetivo for alcançado imediatamente a partir do nó inicial.

Para determinar a complexidade de tempo do algoritmo, podemos olhar para cada parte dele e analisá-la isoladamente. No fim, somamos essas complexidades e obtemos a complexidade geral do algoritmo. Considere o número de nós no grafo sendo V e o número de arestas sendo E. Além disso, considere também que a estrutura de dados utilizada é uma fila de prioridade.

1. Inserir o nó de início na fila de prioridade: independentemente do tamanho do grafo, o tempo para isso será constante, O(1).
2. Remover o menor elemento da fila de prioridade: como cada nó será extraído no máximo uma vez e a complexidade de tempo para isso é O(log V), temos que essa operação é O(V x log V).
3. Verificar se o caminho mais curto para um nó já foi encontrado: para cada nó adjacente ao nó que está sendo analisado, o algoritmo verifica se já foi calculado o menor caminho até esse nó. Essa tarefa é O(E), ou seja, é linearmente proporcional ao número de arestas do grafo.
4. Calcular g(n) e h(n): para calcular o custo e a heurística o tempo é constante, O(1). Para o custo, faremos isso no máximo E vezes, portanto O(E) e a heurística será calculado no máximo V vezes, O(V).
5. Inserir um nó na fila de prioridade: como cada nó será inserido no máximo uma vez e a complexidade de tempo dessa operação é O(log V), temos que essa tarefa é O(V x log V).
6. Atualizar os custos totais na fila de prioridade: o custo dessa operação é linear ao número de nós. Como iremos fazer isso E vezes, pois essa tarefa é executada no máximo a mesma quantidade de vezes que calculamos o custo total, a complexidade é O(V x log E).
   
Somando todas essas complexidades obtemos: O(1) + O(V x log V) + O(E) + O(E) + O(V) + O(V x log V) + O (E x V). Simplificando essa expressão chegamos em: O(V x (log V + log V) + E x V) --> O(V x log V + E x V) Como no grafo utilizado nesse trabalho o número de arestas é um múltiplo do número de nós, podemos simplificar a fórmula para: O(V x log V + V^2) Mantendo o termo de maior peso, obtemos, por fim, que a complexidade do algoritmo A* para o pior caso no grafo utilizado nesse trabalho é: O(V^2). Ou seja, se dobrarmos o número de nós no grafo, quadruplicaremos o número de passos necessários para calcular o melhor caminho.

Como explicado anteriormente, no melhor caso, o algoritmo A* encontra o caminho mais curto em tempo constante, independente do tamanho do grafo, o que em termos da notação Omega pode ser expresso como: [latex] \Omega (1)[/latex].

Para avaliar o caso médio, fizemos testes empíricos em que consideramos o nó inicial estando na primeira coluna da malha de nós gerada e o nó final estando na última coluna da malha. Utilizando uma heurística admissível, realizamos testes para calcular o menor caminho para diferentes tamanhos de grafos. Podemos visualizar esses testes por meio de um gráfico em que no eixo Y temos o tempo, em millisegundos, para gerar o caminho mínimo e no eixo X temos o número de nós do grafo.

![PathTime](../docs/img/size_x_pathtime.png)

Analisando os resultados, podemos concluir que para o caso médio a complexidade é linear, proporcional ao número de nós. Ou seja, se dobrarmos o número de nós, o tempo para calcular o melhor caminho deve dobrar também. (editado) 

# Resultados obtidos

# Conclusão

# Referências Bibliográficas

KIRBY, C. E. et al. Sample Records Low-Altitude Helicopter Fligh. Disponível em: https://www.science.gov/topicpages/l/low-altitude+helicopter+fligh. Acesso em: 16 fev. 2023.

MARCHETTI, M. et al. An Integrated GIS and Remote Sensing Approach for Coastal Zone Management Using Low-Altitude Helicopter Imagery. ISPRS International Journal of Geo-Information, v. 8, n. 6, p. 289, 2019. Disponível em: https://www.mdpi.com/2220-9964/8/6/289. Acesso em: 16 fev. 2023.

NORSWORTHY, G. D. Low altitude helicopter electromagnetic surveying. Journal of Geochemical Exploration, v. 25, n. 1-3, p. 543-553, 1986. Disponível em: https://www.sciencedirect.com/science/article/pii/0307904X85901258. Acesso em: 16 fev. 2023.

CARRERA, P. M. et al. Comparative Study of Forest Attributes Estimation from Low-Altitude Aerial Photography and Unmanned Aerial Vehicle Data. Revista Brasileira de Cartografia, v. 73, n. 1, p. 329-339, 2021. Disponível em: http://old.scielo.br/scielo.php?pid=S2175-91462021000100329&script=sci_arttext. Acesso em: 16 fev. 2023.

MCLEOD, R. et al. Low-Altitude Helicopter Flights Over the Kilauea Volcano During the 2008–2018 Eruptions: A Decade of Observations. Frontiers in Earth Science, v. 5, p. 117, 2017. Disponível em: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5191052/. Acesso em: 16 fev. 2023.

QIAN, Y. et al. Low-Altitude Helicopter-Based Mobile Mapping System. In: 2018 IEEE/RSJ International Conference on Intelligent Robots and Systems (IROS). 2018. p. 3291-3296. Disponível em: https://ieeexplore.ieee.org/document/8581149. Acesso em: 16 fev. 2023.

DASGUPTA, S.; Papadimitriou, C.; Vazirani, U. **Algoritmos.** Porto Alegre: AMGH, 2011. 1 recurso online. ISBN 9788563308535. Disponível em: https://integrada.minhabiblioteca.com.br/books/9788563308535. Acesso em: 17 jan. 2023.

KRISHNA, S. Time Complexity of the A* Algorithm. HappyCoders.eu. Disponível em: https://www.happycoders.eu/algorithms/a-star-algorithm-java/#Time_Complexity_of_the_A_Algorithm. Acesso em: 23 mar. 2023.
WENGROW, J. A Common-Sense Guide to Algorithms and Data Structures. Raleigh: The Pragmatic Bookshelf, 2018. ISBN 9781680502445. Acesso em: 21 mar. 2023.