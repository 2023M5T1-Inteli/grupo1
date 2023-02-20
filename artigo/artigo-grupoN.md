---
title: Modelo para o artigo do Módulo 5
author: Professores do Módulo 5 - Inteli
date: Janeiro de 2023
abstract: Como parte das atividades do módulo 5, cada grupo deverá redigir um texto descrevendo os resultados do projeto no formato de um artigo científico. Este arquivo no formato markdown contém a estrutura básica deste artigo. Cada grupo deverá editar este arquivo com a descrição do projeto que desenvolveu.
---

# Introdução

O processo de realização de voos em baixa altitude de modo a aumentar a cobertura oferece variados tipos de riscos, os quais englobam: colisão com o solo (CFIT); exposição ao inimigo; áreas propensas a interceptação de radares, além de regiões densamente povoadas. Para Dorsett e Wyskida (1985), "a capacidade dos modernos sistemas de defesa aérea forçou as aeronaves militares a utilizar voos de baixa altitude para evitar a detecção e aumentar a capacidade de sobrevivência". Conforme o avanço tecnológico, novas táticas e estratégias são cada vez mais demandadas por parte da aviação militar. Desse modo, "a forma da trajetória deve conseguir garantir um voo seguro em condições mínimas de tempo e consumo de energia considerando as limitações de colisão do terreno" (KOSARI et al., 2018).

A construção de uma trajetória de voo de referência é a etapa mais importante e, "à medida que as missões requerem voos em baixa altitude, sobrevoar principalmente em terrenos acidentados é consideravelmente mais desafiador e requer conhecimento prévio de elevação do terreno" (CAMPOS et al., ano). Esses aspectos aumentam a necessidade da implementação de ferramentas de controle que assegurem a segurança e eficiência para esse tipo de voo, englobando o planejamento de condução da aeronave em devidas localidades a serem percorridas e o seu potencial de voo.

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

DASGUPTA, S.; Papadimitriou, C.; Vazirani, U. **Algoritmos.** Porto Alegre: AMGH, 2011. 1 recurso online. ISBN 9788563308535. Disponível em: https://integrada.minhabiblioteca.com.br/books/9788563308535. Acesso em: 17 jan. 2023.