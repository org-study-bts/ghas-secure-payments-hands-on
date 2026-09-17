# Slides — GHAS Secure Payments (90 minutos)

Cada slide contém objetivo, mensagem principal e demonstração.

| # | Tempo | Título | Objetivo e conteúdo | Ênfase / demonstração |
|---|---:|---|---|---|
| 1 | 3 min | Abertura | API fictícia, escopo e regra de não usar dados reais. | Segurança é processo, não promessa. |
| 2 | 5 min | Shift-left | Encontrar risco perto do commit e do pull request. | Feedback cedo reduz custo. |
| 3 | 5 min | Visão GHAS | Code Scanning, Secret Protection, Dependabot e triagem. | Ferramentas complementares. |
| 4 | 5 min | Codespaces e baseline | Estrutura, `./mvnw test`, Actions e permissões mínimas. | Demo: `/health` e workflow. |
| 5 | 10 min | Code Scanning | Alertas, severidade, security severity e fluxo de dados. | Demo: abrir alerta CodeQL. |
| 6 | 10 min | Corrigir a causa raiz | Fixture controlado, testes e nova análise. | Copilot explica; humano decide. |
| 7 | 8 min | Dependências | Diretas, transitivas, advisories e dependency graph. | Pergunta: o que está instalado? |
| 8 | 7 min | Dependabot | Security updates versus version updates. | Demo: configuração e PR possível. |
| 9 | 7 min | Dependency Review | Evitar introduzir risco em pull request. | Demo: check e impacto da mudança. |
| 10 | 7 min | Segredos | Secret Scanning e Push Protection. | Nunca inserir segredo real; bypass exige justificativa. |
| 11 | 8 min | Triagem | Detecção, análise, risco, priorização e decisão. | Severidade não é risco contextual. |
| 12 | 5 min | Security Overview | Visão organizacional, permissões e Enterprise. | Não substitui alerta detalhado. |
| 13 | 5 min | Limitações | Cobertura, falso positivo, processamento assíncrono e políticas. | Ausência de alerta não prova segurança. |
| 14 | 5 min | Encerramento | Validação, prevenção e próximos passos. | Testes, revisão e documentação fecham o ciclo. |
