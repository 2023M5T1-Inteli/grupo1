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

A partir dos principais pontos referentes ao problema expostos na seção "Descrição do Problema" - a saber, as consequências decorrentes de uma missão de voo baixo, como colisão com o solo ou exposição a aeronaves oponentes, que comprometem não apenas a missão, mas também a integridade da aeronave e a segurança de seus ocupantes - esta seção do artigo tem por objetivo apresentar soluções que abordam problemáticas semelhantes àquela introduzida no contexto do texto, além de retomar os principais problemas que motivaram a criação da solução proposta no artigo.

Ao focarmos no cerne da questão - ou seja, o voo em baixa altitude levando em consideração a segurança - podemos citar o artigo "Planejamento de voo de acompanhamento de terreno de baixa altitude para multirotores" como uma referência, uma vez que ele trata de um veículo aéreo capaz de intervir em uma região ampla (desconhecida) e/ou em um cenário modificado por um evento catastrófico (como terremoto, deslizamento de terra, erupção vulcânica, etc.), em que a coleta de dados do solo não é simples nem segura (MELITA et al., 2020). Esse artigo enfatiza a importância da realização desse tipo de missão, mas também destaca os impactos negativos decorrentes dessa ação.

Além disso, para mitigar esses problemas, propõe-se que a trajetória seja gerada levando em consideração a morfologia da área de interesse, representada como um Modelo Digital de Superfície (DSM) georreferenciado, garantindo ao mesmo tempo uma separação segura de quaisquer obstáculos (MELITA et al., 2020). A eficácia da solução é comprovada por meio de testes tanto em simulação quanto em cenários reais (MELITA et al., 2020).

Em suma, a proposta apresentada no artigo supracitado é um exemplo que se relaciona com alguns pontos mencionados neste artigo. Embora a solução proposta não possua muitas semelhanças com a implementada aqui, é importante ressaltar alguns pontos relevantes, como a utilização das feições geográficas para a geração de uma orientação ao piloto.

Outro artigo que aborda o cerne do problema é "Novo planejamento de trajetória de tempo mínimo no terreno seguindo voos", que aprimora as aplicações da dinâmica inversa no processo de planejamento e otimização de trajetória em voos de seguimento de terreno (TFFs) (KOSARI et al., 2018). Seguindo essa linha de raciocínio, a implementação proposta neste artigo converge com a aplicação desse artigo, uma vez que ambos visam à geração de trajetórias otimizadas.


# Descrição da estratégia adotada para resolver o problema

# Análise da complexidade da solução proposta

Neste artigo, cada grupo precisará fazer a análise de complexidade da solução proposta, utilizando as notações $O(.)$, $\Omega(.)$ e $\Theta(.)$.

A seguir temos a citação de alguns trechos de DASGUPTA et. al. (2011) para mostrar como estas notações são em \LaTeX. 

> Sejam $f(n)$ e $g(n)$ duas funções de inteiros positivos em reais positivos. Dizemos que $f = O(g)$ (que significa que "$f$ não cresce mais rápido do que $g$") se existe uma constante $c > 0$ tal que $f(n) \leq c \cdot g(n)$.

Ainda em outro trecho de DASGUPTA et. al. (2011), temos:

> Assim como $O(.)$ é análogo a $\leq$, podemos definir análogos de $\geq$ e $=$ como se segue:

> $f = \Omega(g)$ significa $g = O(f)$

# Análise da corretude da solução proposta

# Resultados obtidos

A partir das citações e análises de complexidade e corretude, levando em consideração que o algoritmo A* é o melhor e mais conhecido algoritmo para mapeamento utilizando grafos, pode-se concluir que o algoritmo possui um bom desempenho, porém com algumas ressalvas que serão discutidas a seguir.

Em primeiro lugar, é importante destacar que seu desempenho é inversamente proporcional à quantidade de nós a serem percorridos, o que resulta em um aumento no tempo necessário para escolher o melhor caminho. Essa análise pode ser visualizada, por exemplo, em trajetos que percorrem uma grande quantidade de nós, como um trajeto que tem início em uma das pontas da malha e término na outra ponta que se encontra no lado oposto da diagonal entre essas duas pontas.

Além disso, a heurística é outro ponto importante a ser considerado. Ela é formada pela correlação das variáveis de altitude e distância, bem como do custo entre o nó de origem e o de destino. Dependendo do resultado do custo, pode haver um aumento na complexidade e, consequentemente, no tempo necessário para a conclusão do algoritmo.

Portanto, apesar das observações e explicações simplificadas das análises obtidas, é necessário demonstrar a efetividade do algoritmo na prática em relação à sua atuação.

![Resultados dos testes](../docs/img/Grid.PNG)

O conteúdo apresentado anteriormente está de acordo com a linha de raciocínio adotada, pois à medida que a área aumenta, a performance da criação da malha de pontos (grafo) e da trajetória gerada diminui. No entanto, mesmo em grandes quantidades, como 14.400 quilômetros quadrados, o tempo de geração ainda se mantém na casa dos milissegundos, o que se repete na criação do caminho.

Diante dos resultados obtidos nos testes realizados, pode-se concluir que o algoritmo A* é eficiente e eficaz na geração de caminhos otimizados para uso na tecnologia de terrain following.


# Conclusão

Considerando os resultados apresentados na seção anterior e retomando o objetivo principal deste estudo, que é a criação de rotas otimizadas para voos de baixa altitude com o intuito de minimizar os impactos inerentes a essa modalidade de voo, como por exemplo, colisões com o solo ou detecção por inimigos, e ainda, aumentar a segurança e a integridade da aeronave, foi desenvolvido um programa que implementa o algoritmo A* em uma interface gráfica de usuário por meio de uma aplicação web, direcionada tanto para planejadores de missões quanto para pilotos.

Além disso, em relação à aplicação desenvolvida, o software permite que o usuário insira dados de coordenadas nas regiões do estado do Rio de Janeiro e de São Paulo, gerando trajetórias baseadas em restrições de altitude e critérios de distância.

Na perspectiva do usuário, os passos percorridos são restritos à visualização gráfica, enquanto na camada do planejador de trajetórias, o algoritmo A* atua com alta performance, mesmo em áreas extensas, conforme apresentado na seção anterior.

Além de atender ao objetivo proposto neste artigo, o software desenvolvido é categorizado como de código aberto, o que permite a abertura para desenvolvedores interessados no projeto, que tenham o objetivo de otimizar ou até mesmo usufruir de suas funcionalidades, como a mudança da escolha de variáveis que fazem parte da heurística, conscientes da potencialidade do programa.


# Referências Bibliográficas

KIRBY, C. E. et al. Sample Records Low-Altitude Helicopter Fligh. Disponível em: https://www.science.gov/topicpages/l/low-altitude+helicopter+fligh. Acesso em: 16 fev. 2023.

MARCHETTI, M. et al. An Integrated GIS and Remote Sensing Approach for Coastal Zone Management Using Low-Altitude Helicopter Imagery. ISPRS International Journal of Geo-Information, v. 8, n. 6, p. 289, 2019. Disponível em: https://www.mdpi.com/2220-9964/8/6/289. Acesso em: 16 fev. 2023.

NORSWORTHY, G. D. Low altitude helicopter electromagnetic surveying. Journal of Geochemical Exploration, v. 25, n. 1-3, p. 543-553, 1986. Disponível em: https://www.sciencedirect.com/science/article/pii/0307904X85901258. Acesso em: 16 fev. 2023.

CARRERA, P. M. et al. Comparative Study of Forest Attributes Estimation from Low-Altitude Aerial Photography and Unmanned Aerial Vehicle Data. Revista Brasileira de Cartografia, v. 73, n. 1, p. 329-339, 2021. Disponível em: http://old.scielo.br/scielo.php?pid=S2175-91462021000100329&script=sci_arttext. Acesso em: 16 fev. 2023.

MCLEOD, R. et al. Low-Altitude Helicopter Flights Over the Kilauea Volcano During the 2008–2018 Eruptions: A Decade of Observations. Frontiers in Earth Science, v. 5, p. 117, 2017. Disponível em: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC5191052/. Acesso em: 16 fev. 2023.

QIAN, Y. et al. Low-Altitude Helicopter-Based Mobile Mapping System. In: 2018 IEEE/RSJ International Conference on Intelligent Robots and Systems (IROS). 2018. p. 3291-3296. Disponível em: https://ieeexplore.ieee.org/document/8581149. Acesso em: 16 fev. 2023.

DASGUPTA, S.; Papadimitriou, C.; Vazirani, U. **Algoritmos.** Porto Alegre: AMGH, 2011. 1 recurso online. ISBN 9788563308535. Disponível em: https://integrada.minhabiblioteca.com.br/books/9788563308535. Acesso em: 17 jan. 2023.