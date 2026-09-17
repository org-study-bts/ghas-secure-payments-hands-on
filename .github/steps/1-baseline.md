# Fase 1 — baseline e Codespaces

Abra uma cópia pública com **Copy Exercise** e crie um Codespace em `main`. Explique que a aplicação é fictícia, não processa pagamentos reais e não deve receber dados reais.

1. Explore `pom.xml`, `src/main`, `src/test`, `.devcontainer` e `.github`.
2. Execute `./mvnw test`, depois `./mvnw spring-boot:run` e consulte `/health`.
3. Crie a branch **ghas-baseline**, faça o commit **`chore: establish GHAS baseline`** e observe o workflow **Phase 1 - baseline progression**.
4. Explique que Actions executa verificações com permissões mínimas e que o status do workflow não substitui revisão.
5. Habilite, quando disponível, Secret Scanning e Push Protection nas configurações. Não insira nenhum segredo para testar: a demonstração usa somente explicação e um marcador fictício não determinístico.

Codespaces, Actions, Secret Scanning e Push Protection dependem de plano, política e permissões. Se algum recurso não estiver disponível, registre a limitação e continue com os testes locais. `mvn test` é somente fallback documentado quando o wrapper não puder executar.
