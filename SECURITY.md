# Segurança

Este projeto é material didático, não um sistema de pagamentos. Não armazena dados fora da memória, não autentica usuários e não deve receber dados reais.

## Práticas do exercício

- Workflows têm permissões mínimas e versões de actions fixadas.
- O fixture CodeQL é explicitamente fictício e isolado; remova-o na fase 2.
- Não há segredos reais. Secret Scanning/Push Protection podem não alertar em todos os planos ou execuções; essa nondeterminism é esperada.
- Relate problemas sem anexar tokens, chaves, PII ou informações financeiras.

CodeQL, Dependabot e Secret Scanning não garantem cobertura completa. Sempre faça revisão humana, testes e triagem.
