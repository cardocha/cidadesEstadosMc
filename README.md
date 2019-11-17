# Service Monitor
Este repositório contém uma possível solução para o desafio técnico abaixo: 

O desafio consiste em criar um microservice que consulte 2 APIs externas, gerar um
CSV e um JSON e fazer o download.
a. Deve ser usado a API para consultar os estados do Brasil:
https://servicodados.ibge.gov.br/api/v1/localidades/estados
b. Deve ser usado a API para consultar as cidades:
https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios
c. A documentação completa das APIs está no site:
https://servicodados.ibge.gov.br/api/docs/localidades
d. Os campos do CSV/JSON deverá ser:
i.
idEstado
ii.
siglaEstado
iii.
regiaoNome
iv.
nomeCidade
v.
nomeMesorregiao
vi.
nomeFormatado {cidade/UF}

Abaixo seguem os requisitos da biblioteca a ser desenvolvida.
a. NO CSV, a primeira linha (cabeçalho) deve conter o nome de cada campo e
a(s) linha(s) subsequente(s) deve(m) conter os valores resultante da consulta
a API.
b. Deverá ter um endpoint que retorna um json com todos os dados.
c. Deverá ter um endpoint que retorna um CSV com todos os dados.
d. Deverá ter um endpoint que envia um parâmetro, ​ nomeCidade​ , e retorna
somente o ID da cidade.
e. Usar um cache no item (d), para que quando o nome de uma cidade for
enviado mais de uma vez, evite a chamada do serviço externo.
f. No endpoint do CSV deverá retornar um objeto do tipo ​ java.io.OutputStream
como saída da transformação.

Diagrama de classes para a solução .
![alt text](https://raw.githubusercontent.com/cardocha/ServiceMonitor/master/src/main/resources/classDiagram.png)

## Considerações sobre a solução
1 - 


## Getting Started
O código fonte é um projeto Maven.  

### Prerequisites

JAVA 8+ / Maven 3.6.1+ / Spring boot  

### Dependencies
Spring boot starter: https://search.maven.org/search?q=a:spring-boot-starter

## Authors

Luciano Cardoso https://github.com/cardocha

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

