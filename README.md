# Cofrinho de Moedas

Este projeto é uma aplicação Java que simula um cofrinho de moedas. Ele permite adicionar, remover e listar diferentes tipos de moedas, além de calcular o total convertido para a moeda Real.

## Funcionalidades
- Adicionar moedas ao cofrinho (Real, Dólar e Euro)
- Remover moedas do cofrinho
- Listar todas as moedas armazenadas
- Calcular o total convertido para Real

## Tecnologias Utilizadas
- Java
- Programação Orientada a Objetos (POO)
- Estruturas de controle e listas
- Scanner para entrada de dados

## Como Executar o Projeto
1. Clone ou baixe este repositório.
2. Compile e execute o código Java no seu ambiente preferido.
3. No menu interativo, escolha uma das opções disponíveis para interagir com o cofrinho.

## Estrutura do Código
- `Moeda` (Classe Abstrata): Representa uma moeda genérica.
- `Real`, `Dolar`, `Euro`: Classes que representam diferentes moedas e implementam a conversão para Real.
- `Cofrinho`: Gerencia a coleção de moedas.
- `Main`: Classe principal que contém o menu de interação com o usuário.

## Exemplo de Uso
```
--- Menu do Cofrinho ---
1. Adicionar moeda
2. Remover moeda
3. Listar moedas
4. Calcular total convertido
0. Sair
Escolha uma opção: 1

Escolha o tipo de moeda:
1. Real
2. Dólar
3. Euro
Opção: 2
Digite o valor: 10
Moeda adicionada.
```

## Melhorias Futuras
- Implementação de persistência de dados
- Interface gráfica
- Atualização dinâmica da taxa de câmbio

## Autor
Desenvolvido por [FelipeALP13]
