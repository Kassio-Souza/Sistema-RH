# Trabalho-TP1
Trabalho TP1 2025.2 em Java

Olá, mundo.

## Execução
- A tentativa de rodar `mvn test` falhou porque o Maven não conseguiu baixar o plugin padrão `maven-resources-plugin` do Maven Central (resposta HTTP 403), impedindo que os testes sejam executados neste ambiente sem cache prévio dos artefatos.
- Para conseguir executar o projeto localmente, use um ambiente com acesso ao Maven Central ou configure um repositório/mirror interno que disponibilize o plugin e demais dependências.
