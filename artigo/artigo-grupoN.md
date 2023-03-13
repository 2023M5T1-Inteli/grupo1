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

# Descrição do problema

# Trabalhos relacionados

# Descrição da estratégia adotada para resolver o problema

Desse modo, esse artigo visa apresentar uma solução que melhor auxilie os pilotos de aeronaves a traçar rotas seguras e eficientes onde a navegação em baixa altitude é necessária.

A primeira etapa da estratégia adotada para resolver esse problema consiste na modelagem matemática do problema. Além da identificação dos fatores envolvidos, como a altitude do voo, restrições do espaço geográfico, características da aeronave, quantidade de combustível gasta e outros fatores relevantes para o planejamento da rota, foi necessária a modelagem do grafo utilizado. 

As variáveis de decisão foram definadas como binárias e representam se determinada aresta faz parte da trajetória final ou não. Assim, considerando Xi_j uma aresta que conecta os nós "i" e "j" na direção de "i" para "j", tem-se que Xi_j = {1, caso o caminho seja escolhido ou 0, caso contrário }. Ademais, cada aresta tem um peso definido pela seguinte equação "alphaX + betaY", em que X é a distância entre os nós "i" e "j" e Y é a variação de altitude entre esses. Outro fator decidido na modelagem é a função objetivo. Considerando Ci_j o custo da aresta (i, j), a função objetivo é definida como: Min Somatorio_(i_j) Ci_j x Xi_j. Por fim, as restrições das arestas são as seguintes: considerando A e F o nó inicial e final, respectivamente, temos que Somatorio_i Xa_i = 1 e Somatorio_j Xj_f = 1. Além disso, para nós intermediários temos Somatorio_i Xi_k = Somatorio_j Xk_j.

Com base na modelagem matemática, a estratégia adotada envolve a definição do algoritmo a ser utilizado para encontrar a melhor rota entre dois pontos em baixa altitude. Nesse caso, optou-se por utilizar o algoritmo A*, é uma técnica de busca heurística amplamente utilizada em problemas de otimização de caminhos em grafos. A grande vantagem do A* em relação a outros algoritmos de busca de caminho mínimo, como o Dijkstra, é que ele utiliza uma função heurística para estimar o custo restante do caminho a ser percorrido, o que permite que o algoritmo possa escolher caminhos mais promissores para explorar primeiro, reduzindo assim a quantidade de nós que precisam ser examinados, o que é extremamente importante no grafo do problema abordado, que é composto por milhares de pontos. 

A função heurística utilizada pelo A* é uma estimativa do custo restante de um determinado nó até o objetivo final. Essa função é denominada função heurística admissível e é usada para orientar o algoritmo em direção à solução mais próxima do objetivo. Essa função é uma parte crítica do A* e sua precisão é fundamental para o desempenho do algoritmo. A função heurística adotada neste trabalho é a distância do ponto atual até o ponto final, utilizando a fórmula de Harvesine para calcular a distância no modelo esférico da Terra, acrescida da variação de altitude entre o ponto atual e o ponto final. 

O A* funciona da seguinte forma: inicia-se com um nó inicial e um nó objetivo, e uma lista de nós a serem explorados. A cada iteração, o algoritmo seleciona o nó mais promissor da lista de nós a serem explorados e examina todos os seus vizinhos. O custo atual para chegar a esse nó é calculado e o custo total esperado para chegar ao objetivo é estimado com base na função heurística admissível. Se o custo total esperado para chegar ao objetivo através desse nó for menor do que o custo atual de um nó vizinho, então o nó selecionado é adicionado à lista de nós a serem explorados. Esse processo se dá até que o nó objetivo seja alcançado ou até que não haja mais nós disponíveis na lista de nós a serem explorados. Para o problema em questão, os 'nós' descritos na explicação referem-se as coordenadas da malha de pontos gerada.

Uma vez definido o algoritmo, a próxima etapa da estratégia adotada envolve o desenvolvimento da aplicação em si. Essa aplicação funciona da seguinte forma: o usuário, que pode ser representado por um piloto ou pela equipe de planejadores de voos, insere um ponto de início e outro de fim, e o sistema gera uma malha de nós entre esses dois pontos em uma resolução pré-definida. Cada nó dessa malha é conectado com os seus nós vizinhos mais próximos em todas as direções (norte, sul, leste, oeste, nordeste, noroeste, sudoeste, sudeste), e o algoritmo A* é aplicado para encontrar o melhor caminho entre os dois pontos inseridos pelo usuário. Como resultado, o sistema gera uma lista de coordenadas que representam os pontos que compõem a melhor trajetória encontrada pelo algoritmo, rota essa que é exibida na tela em que o usuário interagiu. 

O desenvolvimento da aplicação foi realizado utilizando diversas ferramentas, incluindo a linguagem de programação Java e o framework Spring Boot para a criação do backend, que é uma ferramenta de desenvolvimento de aplicações web que oferece agilidade, recursos robustos e escaláveis, arquitetura modular e é altamente flexível. Além disso, foi utilizada a biblioteca GDAL para a leitura de dados geoespaciais, permitindo a leitura dos dados de elevação em formato DTED2. 

Para lidar com persistência dos dados, este trabalho utiliza um banco de dados orientado a grafos. Esses tipos de banco de dados se configuram como uma solução promissora para lidar com os desafios de planejamento e controle de voos em baixa altitude. Tais bancos de dados possuem grande potencial para lidar com informações espaciais, como a elevação do terreno e outras características geográficas que são relevantes para o planejamento de rotas de voo. A utilização desses torna possível a representação, de maneira eficiente e intuitiva, de dados geoespaciais complexos. Em específico, foi utilizado o banco de dados Neo4J, que é eficiente para a modelagem de informações geográficas, pois é capaz de lidar com dados geográficos de grande volume e complexidade, tornando-se uma ferramenta viável para o problema em questão. 

Para o frontend da aplicação, foram utilizadas a linguagem de marcação HTML, a linguagem de estilização CSS e a linguagem de programação Javascript, bem como a biblioteca D3.js. A utilização do D3.js permitiu a criação de visualizações de dados geográficos dinâmicas e interativas, possibilitando a visualização da malha
gerada e da rota ótima encontrada.

Para testar as rotas da API, foi utilizada a ferramenta Postman, que permitiu uma fácil integração com o backend da aplicação e a realização de testes automatizados. Além disso, a aplicação foi desenvolvida utilizando a tecnologia Docker, que possibilitou a criação de um ambiente isolado para a execução da aplicação, facilitando a gestão de dependências e garantindo maior segurança e estabilidade no ambiente de produção. Com o uso dessas ferramentas, foi possível criar uma aplicação eficiente e de alta qualidade, com uma interface amigável.

# Análise da complexidade da solução proposta

Neste artigo, cada grupo precisará fazer a análise de complexidade da solução proposta, utilizando as notações $O(.)$, $\Omega(.)$ e $\Theta(.)$.

A seguir temos a citação de alguns trechos de DASGUPTA et. al. (2011) para mostrar como estas notações são em \LaTeX. 

> Sejam $f(n)$ e $g(n)$ duas funções de inteiros positivos em reais positivos. Dizemos que $f = O(g)$ (que significa que "$f$ não cresce mais rápido do que $g$") se existe uma constante $c > 0$ tal que $f(n) \leq c \cdot g(n)$.

Ainda em outro trecho de DASGUPTA et. al. (2011), temos:

> Assim como $O(.)$ é análogo a $\leq$, podemos definir análogos de $\geq$ e $=$ como se segue:

> $f = \Omega(g)$ significa $g = O(f)$

# Análise da corretude da solução proposta

# Resultados obtidos

# Conclusão

# Referências Bibliográficas

Hart, P. E., Nilsson, N. J., & Raphael, B. (1968). Uma base formal para a determinação heurística de caminhos de custo mínimo. IEEE Transactions on Systems Science and Cybernetics, 4(2), 100-107. Acesso em: 7 mar. 2023.

KIRBY, C. E. et al. Sample Records Low-Altitude Helicopter Fligh. Disponível em: https://www.science.gov/topicpages/l/low-altitude+helicopter+fligh. Acesso em: 16 fev. 2023.

MARCHETTI, M. et al. An Integrated GIS and Remote Sensing Approach for Coastal Zone Management Using Low-Altitude Helicopter Imagery. ISPRS International Journal of Geo-Information, v. 8, n. 6, p. 289, 2019. Disponível em: https://www.mdpi.com/2220-9964/8/6/289. Acesso em: 16 fev. 2023.

NORSWORTHY, G. D. Low altitude helicopter electromagnetic surveying. Journal of Geochemical Exploration, v. 25, n. 1-3, p. 543-553, 1986. Disponível em: https://www.sciencedirect.com/science/article/pii/0307904X85901258. Acesso em: 16 fev. 2023.

CARRERA, P. M. et al. Comparative Study of Forest Attributes Estimation from Low-Altitude Aerial Photography and Unmanned Aerial Vehicle Data. Revista Brasileira de Cartografia, v. 73, n. 1, p. 329-339, 2021. Disponível em: http://old.scielo.br/scielo.php?pid=S2175-91462021000100329&script=sci_arttext. Acesso em: 16 fev. 2023.

MCLEOD, R. et al. Low-Altitude Helicopter Flights Over the Kilauea Volcano During the 2008–2018 Eruptions: A Decade of Observations. Frontiers in Earth Science, v. 5, p. 117, 2017. Disponível em: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5191052/. Acesso em: 16 fev. 2023.

QIAN, Y. et al. Low-Altitude Helicopter-Based Mobile Mapping System. In: 2018 IEEE/RSJ International Conference on Intelligent Robots and Systems (IROS). 2018. p. 3291-3296. Disponível em: https://ieeexplore.ieee.org/document/8581149. Acesso em: 16 fev. 2023.

DASGUPTA, S.; Papadimitriou, C.; Vazirani, U. **Algoritmos.** Porto Alegre: AMGH, 2011. 1 recurso online. ISBN 9788563308535. Disponível em: https://integrada.minhabiblioteca.com.br/books/9788563308535. Acesso em: 17 jan. 2023.