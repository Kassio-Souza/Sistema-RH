## UNIVERSIDADE DE BRASÍLIA

## CAMPUS DARCY RIBEIRO

```
Departamento: Ciência da Computação
Disciplina: Técnicas de Programação 1 CIC
Professora: Roberta Barbosa Oliveira
```
# TEMA DE PROJETO

### SISTEMA DE GESTÃO DE RECURSOS HUMANOS (RH)

O objetivo geral deste projeto é desenvolver uma solução computacional que apoie e automatize
os principais processos relacionados aos colaboradores em uma organização de recursos humanos.
O sistema deve oferecer funcionalidades que abrangem o recrutamento e seleção de candidatos,
admissões e contratações, gerenciamento de funcionários, rotinas de folha de pagamento, e
eventualmente, a gestão de prestadores de serviço. A proposta deve integrar, em uma única
ferramenta, os aspectos de cadastro, controle e processamento de dados de RH, proporcionando
maior eficiência, confiabilidade e transparência às atividades. Além disso, devem ser aplicados
conceitos de programação orientada a objetos e técnicas de design de software, garantindo uma
aplicação modular, extensível e robusta, capaz de atender às necessidades operacionais e
estratégicas da gestão de pessoas.

Requisitos Funcionais

Administração/Gestão:

```
 Cadastrar, editar, excluir e listar contas de usuário do sistema (administradores, gestores,
recrutadores, funcionários).
 Restringir funcionalidades de acordo com o perfil de acesso.
 Permitir pesquisa para todos os usuários por múltiplos critérios combinados (por exemplo:
nome, CPF/CNPJ, status, departamento).
 Validar dados de usuários (por exemplo: CPF, email).
 Gerar relatórios consolidados de gestão.
```
Candidatura:

```
 Cadastrar, editar, excluir e listar candidatos (por exemplo: dados pessoais, formação,
experiência, pretensão salarial, disponibilidade de horário, documentos adicionais, data de
cadastro).
 Validar CPF no cadastro de candidatos.
 Associar candidatos a vagas (candidatura).
 Registrar candidaturas com status (pendente, em análise, aprovado, reprovado).
 Consultar candidatos (por exemplo: por vaga, nível de experiência, formação ou status da
candidatura (pendente, em análise, aprovado, reprovado)).
```

Recrutamento

```
 Cadastrar, editar, excluir e listar vagas (por exemplo: cargo, salário base, requisitos).
 Permitir filtrar vagas por cargo, departamento, status (aberta/fechada), regime de
contratação, faixa salarial e data de abertura.
 Agendar entrevistas vinculadas a uma candidatura (por exemplo: data, avaliador, nota).
 Permitir a solicitar do recrutador para contratação de candidatos aprovados, com registro
de data e regime (por exemplo: CLT, Estágio ou PJ).
 Permitir a autorização do gestor para a contratação de candidatos aprovados.
 Cadastrar funcionários aprovados no recrutamento de acordo com a definição no
Financeiro.
```
Financeiro

```
 Configurar regras salariais adicionais (por exemplo: vale-transporte, vale-alimentação,
impostos).
 Calcular automaticamente o salário do funcionário com base no regime (por exemplo:
CLT, Estágio, PJ).
 Gerar a folha de pagamento mensal com todos os funcionários ativos.
 Exportar relatórios da folha em formato visual (tela) e arquivo (por exemplo: PDF/CSV).
 Filtrar funcionários por cargo, tipo de contratação (CLT, Estágio, PJ), status (ativo/inativo)
e departamento.
```
Prestação de Serviço (para grupos de 5 integrantes):

```
 Cadastrar, editar, excluir e listar prestadores de serviço (por exemplo: dados
pessoais/jurídicos, CPF/CNPJ, contato, endereço).
 Validar CPF/CNPJ no cadastro de prestadores de serviço.
 Listar prestadores de serviço por tipo de serviço, contrato (ativo/inativo) ou categoria do
prestador.
 Associar prestadores a contratos de serviço, registrando informações como tipo de serviço
(limpeza, manutenção, consultoria), valor, data de início e término.
 Registrar e acompanhar o status dos contratos (ativo, encerrado, pendente de renovação).
 Gerar relatórios de prestadores por tipo de serviço, contrato (ativo/inativo) ou categoria.
 Emitir alertas de contratos próximos do vencimento.
```
Requisitos Não Funcionais

O sistema deve conter os seguintes requisitos não funcionais:

```
 Ter interface amigável para interação (por exemplo: Swing, JavaFX ou menu de opções
em prompt).
 Oferecer usabilidade adequada (botões e menus claros, feedback ao usuário, alertas antes
de exclusão definitiva).
 Exibir mensagens claras para erros de regra de negócio, usando exceções personalizadas.
```

```
 Deve ser implementado de forma orientada a objetos, garantindo modularidade e
permitindo a extensão de funcionalidades sem impactar de forma significativa as classes já
existentes.
 A modelagem deve priorizar herança e composição para reaproveitamento de código e
redução de duplicidade.
 Deve respeitar princípios de encapsulamento, expondo apenas os métodos necessários ao
uso externo.
 Deve adotar boas práticas de POO, como responsabilidade única (altamente coesa) e baixo
acoplamento entre módulo, para facilitar manutenção e evolução do sistema.
 Empregar pelo menos dois padrões de projeto (por exemplo: Builder).
 Ser implementado em camadas bem definidas (por exemplo: apresentação, aplicação,
domínio, persistência, infraestrutura).
 Armazenar dados em arquivos (por exemplo: texto, binário ou serialização de objetos).
 Ser executável em qualquer sistema operacional com Java instalado.
 Garantir autenticação obrigatória via login e senha.
 (Opcional) Considerar execução concorrente para a geração da folha de pagamento.
```
Regras de Negócio

Administração/Gestão:

```
 Perfis de acesso são hierárquicos: administrador (acesso total), gestor (relatórios
estratégicos e supervisão), recrutador (acesso a vagas, candidaturas, entrevistas e
contratações), funcionário (acesso a folha de pagamento, dados pessoais, contracheques).
 Um usuário pode ter um ou mais perfis atribuídos, desde que cada perfil corresponda às
funções autorizadas.
 O sistema deve permitir o cadastro de múltiplos usuários para cada perfil.
 Administradores podem acessar todas as categorias, enquanto recrutadores e funcionários
têm acesso restrito conforme perfil.
 Apenas administradores podem criar, editar ou remover contas de outros usuários.
 Senhas devem respeitar políticas mínimas (por exemplo: 8 caracteres, letras e números).
```
Candidatura:

```
 Candidatos podem se candidatar a várias vagas diferentes.
 Um candidato não pode se candidatar à mesma vaga mais de uma vez.
 Toda candidatura deve estar vinculada a uma vaga existente.
 Cada candidatura deve possuir um status: Pendente, Em análise, Aprovado, Reprovado.
 O status da candidatura deve ser atualizado pelo Recrutador conforme avaliação do
processo seletivo.
 Somente candidaturas pendentes podem ser excluídas.
 Gestores podem visualizar candidaturas com status “Em análise” ou “Aprovado”, para fins
de supervisão e decisão estratégica.
```

Recrutamento:

```
 Somente Gestores podem criar vagas.
 Somente Gestores podem atribuir recrutadores responsáveis a uma vaga.
 O recrutador pode gerenciar o processo seletivo de candidaturas somente das vagas sob sua
responsabilidade.
 Nenhum candidato pode ser contratado sem ao menos uma entrevista registrada.
 Apenas candidatos aprovados podem ser contratados.
 Somente Gestores podem autorizar contratações.
 Apenas o recrutador pode cadastrar candidatos aprovados no sistema, vinculando-os à vaga
e registrando a data de contratação.
```
Financeiro

```
 A folha de pagamento deve incluir apenas funcionários ativos.
 Funcionários inativos não aparecem em relatórios financeiros.
 O salário deve ser calculado conforme o regime. Por exemplo: CLT (salário base +
benefícios – descontos), Estágio (bolsa fixa + auxílio transporte) ou PJ (valor negociado
sem benefícios).
 Apenas Administradores podem alterar regras salariais.
```
Prestação de Serviço (para grupos de 5 integrantes):

```
 Contratos de prestadores de serviço devem ter data de início e fim obrigatórias.
 Prestadores só aparecem como ativos dentro da vigência do contrato.
 Todo prestador deve estar associado a uma categoria (por exemplo: limpeza, manutenção,
TI, consultoria).
 Um mesmo prestador pode ser contratado para diferentes serviços ou períodos distintos,
mas não pode ter dois contratos ativos sobre o mesmo serviço simultaneamente.
 Prestadores sem contrato ativo não devem constar em relatórios de acompanhamento.
 Prestadores não possuem login no sistema, e todas as atualizações de dados devem ser
feitas por Administradores ou Gestores.
 Somente Administradores e Gestores podem alterar dados de prestadores.
```
Atores

```
 Administrador: É responsável por gerenciar contas de usuários (criar, editar, excluir),
controlar perfis (Gestores, Funcionários, Recrutadores) e permissões de acesso,
supervisionar as operações gerais do sistema.
 Gestor do RH: É responsável por criar e gerenciar vagas de emprego, atribuir recrutadores
responsáveis às vagas, avaliar os pedidos de contratação submetidos pelo recrutadores e
gerar relatórios estratégicos para apoio à tomada de decisão (por exemplo: contratação por
vaga, folha de pagamento por regime de trabalho).
 Recrutador do RH: É responsável por cadastrar e gerenciar candidatos e suas
candidaturas, registrar e organizar entrevistas (data e nota), atualizar o status do processo
```

```
seletivo, solicitar autorização para contratações de candidatos aprovados, realizar a
admissão dos candidatos.
 Funcionário Geral: É responsável por consultar e atualizar algumas informações pessoais
(como endereço, telefone e senha de acesso), visualizar contracheques, benefícios e
histórico financeiros individual.
 Candidato: Não tem acesso direto ao sistema. Seus dados são registrados pelo Recrutador
e o acompanhamento do processo seletivo deve ocorrer por meio de canais externos (como
e-mail, telefone ou portal da empresa).
 Prestador de Serviço (apenas para grupos de cinco integrantes): Não tem acesso direto ao
sistema. Suas informações cadastrais e contratuais são registradas por administradores e
gestores.
```
Divisão das tarefas

Para organizar o desenvolvimento do Sistema, a equipe deve dividir as tarefas com base em

módulos funcionais, garantindo que cada integrante tenha responsabilidade clara sobre um

conjunto de funcionalidades. Cada módulo deve ser estruturado para contemplar todas as camadas

da arquitetura do sistema, assegurando que cada aluno possa implementar, testar e integrar seu
módulo de maneira independente, mas mantendo a comunicação necessária com os demais

módulos. Além disso, as telas e funcionalidades de cada módulo devem ser definidas considerando

os perfis de acesso dos diferentes atores do sistema (Administrador, Gestor, Recrutador,

Funcionário), garantindo que cada usuário possa interagir apenas com as funcionalidades

compatíveis com seu papel. A divisão das tarefas sugeridas a seguir detalha uma distribuição de

classes de domínio e telas, facilitando o planejamento, execução e integração do projeto:

```
 Aluno 1 - Administração e Gestão: gestão de contas de usuário, supervisão de
recrutadores e contratações, e criação de relatórios de gestão. Classes: Usuario,
Administrador, Gestor. Telas: Login, Administrar Usuários, Relatórios Gestão.
 Aluno 2 - Candidatura: gestão de candidaturas. Classes: Pessoa, Candidato, Candidatura.
Telas: Cadastro de Candidato, Candidatura à Vaga, Status da Candidatura.
 Aluno 3 - Recrutamento: gestão de vagas e contratações. Classes: Recrutador, Vaga,
Entrevista, Contratação. Telas: Menu do Recrutamento, Cadastro de Candidatos, Realizar
Candidaturas, Marcar Entrevista, Solicitar Contratações, Consultar Contratações.
 Aluno 4 - Financeiro: controle de regras salariais, folha de pagamento e relatórios
financeiros. Classes: Funcionario, RegraSalario, FolhaPagamento. Telas: Menu do
Financeiro, Cadastro de Funcionário, Configurar Regras Salariais, Gerar Folha de
Pagamento, Relatório Financeiro, Contracheques.
 Aluno 5 - Prestação de Serviço: gestão de prestadores de serviço e contratos. Classes:
PrestadorServico, ContratoServico. Telas: Menu da Prestação de Serviço, Cadastro de
Prestadores de Serviço, Gestão de Contratos, Relatório de Prestadores.
```

