# Fase 3 — Dependabot e Dependency Review

Abra a visão de dependências e diferencie:

- **detectar** uma vulnerabilidade já presente no dependency graph;
- **corrigir** uma versão conhecida e validar a mudança;
- **manter** versões atualizadas com version updates;
- **evitar** introduzir uma dependência vulnerável em um pull request com dependency review.

Dependências diretas aparecem no `pom.xml`; transitivas são trazidas por elas. Para a demonstração, `commons-text` 1.9 está preso como dependência de teste. O pull request do participante deve ter o título **`fix: update vulnerable payment dependency`** e atualizar a versão após revisão. É uma dependência controlada, não usada pela API, e não representa dados ou serviços reais. Dependabot alerts dependem de advisories conhecidos. Security updates propõem correções de segurança; version updates mantêm versões dentro das regras de `.github/dependabot.yml`. Os resultados podem atrasar ou variar, portanto não faça a fase depender da criação imediata de um alerta.

Crie o PR do participante com o título **`fix: update vulnerable payment dependency`** somente depois de atualizar o `pom.xml` em um commit chamado **`fix: update vulnerable dependency`**. Observe o workflow `Phase 3 - dependency review` e o `dependency-review-action@v5.0.0` (tag verificada no upstream). A referência da action é válida, mas a análise funcional só é considerada disponível quando o Dependency Graph estiver habilitado; se o GitHub informar que o recurso está desabilitado, registre `Pendente/Não disponível` e use o `pom.xml`, o dependency tree e os testes como fallback. Revise o pacote, versão instalada, versão corrigida, impacto da atualização e testes antes de fazer merge do PR do participante.

Secret Scanning e Push Protection entram aqui como controles complementares: nunca use credenciais reais. Remover um valor do arquivo não desfaz exposição; um segredo real deve ser revogado/rotacionado no provedor, removido do histórico quando necessário e substituído por credencial de menor privilégio. Detecção pode ser não determinística por plano, padrão e processamento.
