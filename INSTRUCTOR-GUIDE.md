# Guia do instrutor

> PR #2 é a implementação deste material. Ele não é o PR do participante:
> nunca o aprove, feche ou faça merge durante a aula. O PR do participante deve
> usar o título `fix: update vulnerable payment dependency`.

## Roteiro de 90 minutos

| Tempo | Bloco | Resultado esperado |
|---|---|---|
| 5 min | Abertura | Objetivo, aplicação fictícia e regras: nenhum dado real. |
| 10 min | Visão geral GHAS | Shift-left, Code Scanning, dependências e segredos. |
| 5 min | Projeto e Codespaces | Codespace aberto, estrutura explicada, `/health` acessível. |
| 10 min | Fase 1: baseline | `./mvnw test`, branch, commit e Actions. |
| 20 min | Fase 2: CodeQL | Fixture, alerta, fluxo, correção, prompt do Copilot e teste. |
| 15 min | Fase 3: Dependabot | Dependency graph, alertas, updates e dependency review. |
| 10 min | Fase 4: triagem | Risco contextual, decisão, correção e reanálise. |
| 7 min | Segredos e Overview | Secret Scanning, Push Protection e visão Enterprise. |
| 3 min | Encerramento | Recapitulação, limitações e próximos passos. |

## Preparação e sequência

Antes da aula, crie uma cópia pública, confirme Java 17 e execute `./mvnw test`.
Deixe uma branch e um pull request de demonstração preparados, sem dados reais.
O toolkit usado pelo workflow inicial é `skills/exercise-toolkit` na ref
`2bed354b84a2633bc05cb5d6c8658bfa47345445`; a interface confirmada é
`start-exercise.yml` com `exercise-title` e `intro-message`. A tag
`actions/dependency-review-action@v5.0.0` foi confirmada no upstream.

Mostre primeiro a baseline. Na fase CodeQL, explique que o fixture é controlado e não é uma instrução para explorar sistemas: o objetivo é reconhecer origem, fluxo e causa raiz. Mostre o alerta, peça ao Copilot somente explicação, revise a sugestão e remova o fixture. Na fase de dependências, mostre como o dependency graph, Dependabot e dependency review respondem a perguntas diferentes. Finalize com a sequência de triagem: detecção, análise, risco, priorização, correção, validação, encerramento e prevenção.

## Perguntas frequentes e alternativas

- **“Por que não apareceu o alerta?”** A análise é assíncrona, a cobertura varia e o plano/permissão pode não habilitar o recurso. Use o diff, `./mvnw test` e a discussão do fixture como evidência didática.
- **“Posso testar com meu token?”** Não. Use apenas a explicação do controle e um marcador inválido; um segredo real deve ser revogado/rotacionado no provedor.
- **“Dependabot garante segurança?”** Não. Ele depende de advisories conhecidos e não substitui atualização, revisão e threat modeling.
- **“Posso aceitar um alerta?”** Sim, apenas com contexto, justificativa, responsável e prazo documentados; falso positivo também precisa de justificativa.
- **“Por que não vejo Security Overview?”** É uma visão organizacional dependente de plano e permissões; mostre-a pelo ambiente Enterprise do instrutor.

Se CodeQL, Dependabot, Actions ou Codespaces estiverem indisponíveis ou lentos, use logs/capturas previamente preparadas e continue com as verificações locais. Não afrouxe permissões para contornar uma política organizacional. Copilot é assistivo: toda sugestão precisa de revisão humana e testes.

## Ledger de validação

Use somente a data real do dia em que o check foi executado. Não transforme
um link estático, uma expectativa ou uma captura em evidência operacional.

| Categoria | Check | Evidência/data | Resultado |
|---|---|---|---|
| Validado | Arquivos YAML, wrapper e `./mvnw test` | 2026-09-16, execução local | Validado |
| Pendente | Links externos/Copy Exercise e operação no GitHub.com | 2026-09-16, validação HTTP não conclusiva neste ambiente | Pendente |
| Pendente | Copy Exercise, Codespaces, CodeQL UI, Dependabot UI, Secret Scanning e Push Protection | requer conta principal/não-admin ou GitHub.com | Pendente |
| Não determinístico | Alertas, reanálise assíncrona, advisories e Security Overview | depende de plano, fila e cobertura | Não determinístico |
| Fallback | `mvn test`, revisão do diff e testes locais | somente se wrapper/serviço não puder rodar | Fallback |

### Estados de CodeQL

Registre separadamente: **estado inicial** (fixture presente), **alerta
observado/limitação** (URL ou não disponível), **correção** (remover/substituir
o fixture inseguro), **testes** (`./mvnw test`), **reanálise** (resultado ou
pendente), **resultado final** (somente com evidência) e **fallback** (diff e
testes, se o serviço não estiver disponível).

### Estados de Dependabot

Registre separadamente: **estado inicial** (`commons-text` 1.9), **alerta
observado/limitação** (advisory ou não disponível), **correção/atualização**
(versão confirmada no `pom.xml`), **testes** (`./mvnw test`), **reanálise**
(resultado ou pendente), **resultado final** (após revisão do PR do participante)
e **fallback** (revisão do `pom.xml`, dependency tree e testes). Nunca declare
um estado do GitHub.com que não tenha sido observado.

Cada fase deve ter ação do participante, artefato e check: fase 1 branch
`ghas-baseline`, commit `chore: establish GHAS baseline`, testes e workflow;
fase 2 reprodução/observação, correção segura, teste de regressão e push; fase
3 atualização e PR com o título definido, revisão, testes e confirmação do
`pom.xml`; fase 4 `docs/alert-triage.md`, decisão, checks/testes e conclusão
somente do PR do participante.
