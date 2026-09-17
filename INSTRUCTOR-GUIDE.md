# Guia do instrutor

## Roteiro de 90 minutos

| Tempo | Bloco | Resultado esperado |
|---|---|---|
| 5 min | Abertura | Objetivo, aplicação fictícia e regras: nenhum dado real. |
| 10 min | Visão geral GHAS | Shift-left, Code Scanning, dependências e segredos. |
| 5 min | Projeto e Codespaces | Codespace aberto, estrutura explicada, `/health` acessível. |
| 10 min | Fase 1: baseline | `mvn test`, branch, commit e Actions. |
| 20 min | Fase 2: CodeQL | Fixture, alerta, fluxo, correção, prompt do Copilot e teste. |
| 15 min | Fase 3: Dependabot | Dependency graph, alertas, updates e dependency review. |
| 10 min | Fase 4: triagem | Risco contextual, decisão, correção e reanálise. |
| 7 min | Segredos e Overview | Secret Scanning, Push Protection e visão Enterprise. |
| 3 min | Encerramento | Recapitulação, limitações e próximos passos. |

## Preparação e sequência

Antes da aula, crie uma cópia pública, confirme Java 17/Maven, abra um Codespace, execute `mvn test` e confirme que Actions pode executar actions externas. Deixe uma branch e um pull request de demonstração preparados, sem dados reais. Verifique no GitHub.com quais recursos estão disponíveis no plano do instrutor e prepare capturas da tela apenas como plano alternativo.

Mostre primeiro a baseline. Na fase CodeQL, explique que o fixture é controlado e não é uma instrução para explorar sistemas: o objetivo é reconhecer origem, fluxo e causa raiz. Mostre o alerta, peça ao Copilot somente explicação, revise a sugestão e remova o fixture. Na fase de dependências, mostre como o dependency graph, Dependabot e dependency review respondem a perguntas diferentes. Finalize com a sequência de triagem: detecção, análise, risco, priorização, correção, validação, encerramento e prevenção.

## Perguntas frequentes e alternativas

- **“Por que não apareceu o alerta?”** A análise é assíncrona, a cobertura varia e o plano/permissão pode não habilitar o recurso. Use o diff, `mvn test` e a discussão do fixture como evidência didática.
- **“Posso testar com meu token?”** Não. Use apenas a explicação do controle e um marcador inválido; um segredo real deve ser revogado/rotacionado no provedor.
- **“Dependabot garante segurança?”** Não. Ele depende de advisories conhecidos e não substitui atualização, revisão e threat modeling.
- **“Posso aceitar um alerta?”** Sim, apenas com contexto, justificativa, responsável e prazo documentados; falso positivo também precisa de justificativa.
- **“Por que não vejo Security Overview?”** É uma visão organizacional dependente de plano e permissões; mostre-a pelo ambiente Enterprise do instrutor.

Se CodeQL, Dependabot, Actions ou Codespaces estiverem indisponíveis ou lentos, use logs/capturas previamente preparadas e continue com as verificações locais. Não afrouxe permissões para contornar uma política organizacional. Copilot é assistivo: toda sugestão precisa de revisão humana e testes.
