# Fase 3 — Dependabot e Dependency Review

Abra a visão de dependências e diferencie:

- **detectar** uma vulnerabilidade já presente no dependency graph;
- **corrigir** uma versão conhecida e validar a mudança;
- **manter** versões atualizadas com version updates;
- **evitar** introduzir uma dependência vulnerável em um pull request com dependency review.

Dependências diretas aparecem no `pom.xml`; transitivas são trazidas por elas. Para a demonstração, `commons-text` 1.9 está preso como dependência de teste e deve ser atualizado para uma versão corrigida pelo pull request da fase. É uma dependência controlada, não usada pela API, e não representa dados ou serviços reais. Dependabot alerts dependem de advisories conhecidos. Security updates propõem correções de segurança; version updates mantêm versões dentro das regras de `.github/dependabot.yml`. Os resultados podem atrasar ou variar, portanto não faça a fase depender da criação imediata de um alerta.

Em um pull request, observe o workflow `Phase 3 - dependencies` e o `dependency-review-action`. Ele é apropriado para repositório público, usa permissões de leitura e sinaliza severidade alta como exemplo. Revise o pacote, versão instalada, versão corrigida, impacto da atualização e testes antes de fazer merge.

Secret Scanning e Push Protection entram aqui como controles complementares: nunca use credenciais reais. Remover um valor do arquivo não desfaz exposição; um segredo real deve ser revogado/rotacionado no provedor, removido do histórico quando necessário e substituído por credencial de menor privilégio. Detecção pode ser não determinística por plano, padrão e processamento.
