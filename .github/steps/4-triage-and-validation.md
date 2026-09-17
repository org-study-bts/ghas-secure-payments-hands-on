# Fase 4 — triagem e validação

Abra ou revise o **participant exercise PR**, não o PR de implementação #2, e os checks. Crie `docs/alert-triage.md` com a decisão de triagem. Para cada alerta, registre:

1. **Detecção** — qual ferramenta encontrou o sinal?
2. **Análise** — qual arquivo, fluxo, pacote ou padrão está envolvido?
3. **Avaliação de risco** — qual impacto, exposição, explorabilidade e contexto?
4. **Priorização** — o que deve ser corrigido primeiro?
5. **Correção** — elimine a causa raiz, não apenas o sintoma.
6. **Validação** — execute testes, revise o diff e aguarde nova análise quando disponível.
7. **Encerramento** — confirme a correção ou documente falso positivo/adiamento.
8. **Prevenção de recorrência** — mantenha testes, regras, atualização e revisão.

Severidade é um sinal técnico; risco real também depende de contexto. Decisões possíveis incluem corrigir imediatamente, abrir uma issue, acompanhar, marcar falso positivo com justificativa, aceitar temporariamente o risco com prazo/documentação ou solicitar revisão da equipe responsável.

Considere um alerta resolvido somente após correção da causa raiz, testes passando, revisão humana e nova análise quando essa análise existir. Security Overview é uma visão organizacional dependente de permissões e plano; não substitui a leitura detalhada e sua ausência não prova ausência de vulnerabilidades. Copilot é apoio e precisa de revisão. Os workflows desta fase validam artefatos e testes, não resultados pagos ou assíncronos. Complete somente o PR do participante; não faça merge, close ou approve do PR de implementação #2.
