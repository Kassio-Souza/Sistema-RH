# Trabalho-TP1
Trabalho TP1 2025.2 em Java

Olá, mundo.

## Execução
- O acesso ao Maven Central está bloqueado neste ambiente, por isso `mvn test` não consegue baixar os plugins padrão e falha.
- Para compilar e executar sem internet, use o script offline:

```bash
./scripts/build.sh
java -cp out Main
```

O script usa apenas a JDK e implementações mínimas das dependências em `src/main/java/org/apache`, permitindo gerar os relatórios em CSV e um PDF em texto (útil para validação e testes automatizados offline).

### Demo do módulo de Recrutamento
Para ver o fluxo de Recrutamento rodando sem precisar abrir a UI Swing, execute:

```bash
./scripts/demo_recrutamento.sh
```

O script recompila o projeto e roda `recrutamento.demo.RecrutamentoDemo`, que cria uma vaga, agenda entrevista para um candidato aprovado e efetiva a contratação enviando o funcionário gerado para o módulo Financeiro fake usado na demo.
