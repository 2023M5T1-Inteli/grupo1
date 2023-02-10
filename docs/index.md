<table>
<tr>
<td>
<a href= "https://ael.com.br/"><img src="https://www.ael.com.br/images/ael.png" alt="AEL Sistemas" border="0" width="70%"></a>
</td>
<td><a href= "https://www.inteli.edu.br/"><img src="https://www.inteli.edu.br/wp-content/uploads/2021/08/20172028/marca_1-2.png" alt="Inteli - Instituto de Tecnologia e Liderança" border="0" width="30%"></a>
</td>
</tr>
</table>

<font size="+12"><center>
Planejador de trajetórias para voos em baixa altitude
</center></font>

>*Observação 1: A estrutura inicial deste documento é só um exemplo. O seu grupo deverá alterar esta estrutura de acordo com o que está sendo solicitado nos artefatos.*

>*Observação 2: O índice abaixo não precisa ser editado se você utilizar o Visual Studio Code com a extensão **Markdown All in One**. Essa extensão atualiza o índice automaticamente quando o arquivo é salvo.*

**Conteúdo**

- [Autores](#autores)
- [Visão Geral do Projeto](#visão-geral-do-projeto)
  - [Empresa](#empresa)
  - [O Problema](#o-problema)
  - [Objetivos](#objetivos)
    - [Objetivos gerais](#objetivos-gerais)
    - [Objetivos específicos](#objetivos-específicos)
  - [Partes interessadas](#partes-interessadas)
- [Análise do Problema](#análise-do-problema)
  - [Análise do cenário: Matriz SWOT](#análise-do-cenário-matriz-swot)
  - [Proposta de Valor: Value Proposition Canvas](#proposta-de-valor-value-proposition-canvas)
  - [Matriz de Risco](#matriz-de-risco)
- [Requisitos do Sistema](#requisitos-do-sistema)
  - [Personas](#personas)
  - [Histórias dos usuários (user stories)](#histórias-dos-usuários-user-stories)
- [Arquitetura do Sistema](#arquitetura-do-sistema)
  - [Módulos do Sistema e Visão Geral (Big Picture)](#módulos-do-sistema-e-visão-geral-big-picture)
  - [Descrição dos Subsistemas](#descrição-dos-subsistemas)
    - [Requisitos de software](#requisitos-de-software)
  - [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [UX e UI Design](#ux-e-ui-design)
  - [Wireframe + Storyboard](#wireframe--storyboard)
  - [Design de Interface - Guia de Estilos](#design-de-interface---guia-de-estilos)
- [Projeto de Banco de Dados](#projeto-de-banco-de-dados)
  - [Modelo Conceitual](#modelo-conceitual)
  - [Modelo Lógico](#modelo-lógico)
- [Teste de Software](#teste-de-software)
  - [Testes Unitários](#testes-unitários)
  - [Teste de Usabilidade](#teste-de-usabilidade)
- [Análise de Dados](#análise-de-dados)
- [Manuais](#manuais)
  - [Manual de Implantação](#manual-de-implantação)
  - [Manual do Usuário](#manual-do-usuário)
  - [Manual do Administrador](#manual-do-administrador)
- [Referências](#referências)


# Autores

* Allan Casado
* Moises Cazé
* Aluno 3
* Aluno 4
* Aluno 5
* Aluno 6
* Aluno 7
* Aluno 8


# Visão Geral do Projeto

## Empresa

*Descrição_da_empresa*

## O Problema

*Descrição_do_problema*

## Objetivos

### Objetivos gerais

*Lista_de_objetivos_gerais*

### Objetivos específicos

*Lista_de_objetivos específicos*

## Partes interessadas

*Lista_e_apresentação_das_partes_interessadas*

# Análise do Problema

*Descrição_da_análise_do_problema*

## Análise do cenário: Matriz SWOT

A Análise SWOT é um framework utilizado para ajudar a avaliar a situação atual de uma empresa, identificando seus pontos fortes (Strengths), fraquezas (Weaknesses), oportunidades (Opportunities) e ameaças (Threats). É uma ferramenta de avaliação de ambiente interno e externo da companhia que permite visualizar as forças e fraquezas internas da empresa, bem como as oportunidades e ameaças externas. O objetivo principal é ajudar a identificar oportunidades de melhoria e a desenvolver estratégias para maximizar as vantagens e minimizar as desvantagens. Além disso, como consequência do uso dessa técnica, acaba-se adquirindo um grande conhecimento da empresa e do mercado que ela atua.

[IMAGEM]

## Proposta de Valor: Value Proposition Canvas

O Value Proposition Canvas é uma ferramenta que ajuda as empresas a entender e criar propostas de valor para seus clientes. Esse framework é composto por dois elementos principais: a seção dos clientes,  que descreve as necessidades, desejos, preocupações e contextos dos clientes-alvo, e a seção do produto, que descreve as soluções oferecidas para atender às necessidades dos clientes, exibindo como, então, a solução gera valor. O objetivo principal do Value Proposition Canvas é ajudar as empresas a compreender melhor os clientes e a criar propostas de valor que sejam mais eficazes.

[IMAGEM]
 
## Matriz de Risco

A Matriz de Risco é uma ferramenta utilizada para avaliar e gerenciar os riscos em um projeto. A ideia dessa técnica é representar graficamente os riscos mapeados para determinado projeto e classificá-los de acordo com a sua probabilidade de ocorrência e impacto ao desenvolvimento. É uma ferramenta importante para ajudar as empresas a identificar e gerenciar os riscos de forma eficaz, o que é fundamental para o sucesso dos produtos e da realização de projetos de maneira segura e bem-sucedida, trazendo a possibilidade de identificar e priorizar os riscos mais críticos e, por consequência, desenvolver estratégias para minimizar seu impacto..

[IMAGEM]

# Requisitos do Sistema

*Descrição_dos_requisitos*

## Personas

A Persona é uma representação fictícia do cliente-alvo de uma empresa ou produto. Essa representação descreve as características demográficas, comportamentais, sociais desse grupo específico clientes. Ela permite que as empresas tenham uma visão mais clara e detalhada das necessidades, desejos, preocupações e contextos dos clientes-alvo, o que é fundamental para  a criação de produtos, serviços e soluções que sejam mais atraentes e eficazes, especificamente para esse grupo.

[IMAGEM]


## Histórias dos usuários (user stories)

| User Story | Prioridade | Status |
|--- |--- |--- |
| 1. Eu como piloto quero que o sistema evite rotas cruzadas, para garantir a segurança da
viagem e evitar possíveis colisões. | Alta | A fazer |
| 2. Como piloto, quero que o programa mantenha a altitude o mais baixo possível e dê o
melhor trecho a ser percorrido, para minimizar o tempo de viagem. | Alta | A fazer |
| 3. Como piloto, quero que o programa contribua para minimizar o consumo de
combustível, para reduzir custos e ao mesmo tempo proteger o meio ambiente. | Alta | A fazer |
| 4. Como piloto, quero que a trajetória de voo evite sistemas de monitoramento (SAMs) e
áreas conhecidas de patrulha, para garantir a segurança da operação. | Alta | A fazer |
| 5. Como piloto, quero que a trajetória de voo evite regiões muito povoadas, para minimizar
riscos de segurança pública. | Alta | A fazer |
| 6. Como piloto, quero que a trajetória aproveite também feições geográficas elevadas para
evitar restrições, arrastos e condições adversas. | Alta | A fazer |
| 7. Como piloto, quero ter uma interface intuitiva e objetiva, para que possa me concentrar
na missão sem me preocupar com dificuldades técnicas. | Alta | A fazer |
| 8. Como piloto quero um sistema que reduza a carga horária de trabalho para torná-la
menos desgastante e ter maior foco na missão. | Alta | A fazer |
| 9. Como operador, quero que o sistema ajude a diminuir o risco de exposição do piloto
para garantir sua segurança. | Alta | A fazer |
| 10. Como operador, quero definir zonas de exclusão, restrições e outras informações em
parâmetros de entrada para manter um sistema de planejamento eficiente. | Alta | A fazer |
| 11. Como piloto quero capturar dados e informações com facilidade para gerar valor à
missão. | Alta | A fazer |

# Arquitetura do Sistema

## Módulos do Sistema e Visão Geral (Big Picture)

## Descrição dos Subsistemas

### Requisitos de software


## Tecnologias Utilizadas


# UX e UI Design

## Wireframe + Storyboard

## Design de Interface - Guia de Estilos


# Projeto de Banco de Dados

## Modelo Conceitual

## Modelo Lógico


# Teste de Software

## Testes Unitários

## Teste de Usabilidade


# Análise de Dados


# Manuais

## Manual de Implantação

## Manual do Usuário

## Manual do Administrador


# Referências
