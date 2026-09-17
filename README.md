# GHAS Secure Payments Hands-on

Exercício introdutório de **GitHub Advanced Security (GHAS)** em português brasileiro. A aplicação `Secure Payments Demo` é uma API Java/Spring Boot pequena, fictícia e sem integração com bancos, gateways ou provedores externos. Os pagamentos ficam somente na memória do processo.

> Este exercício é demonstrado pelo instrutor durante o treinamento. Os participantes podem repetir as fases posteriormente em uma cópia pública do repositório, utilizando a gravação, o conteúdo das fases e a documentação oficial.

## Público e duração

- Público misto, principalmente desenvolvedores, nível básico.
- Demonstração de 90 minutos; o participante pode repetir no próprio ritmo.
- Ambiente recomendado: GitHub Codespaces e GitHub.com.

## Pré-requisitos e Copy Exercise

1. Use **Copy Exercise** no repositório de treinamento para criar uma cópia pública.

   [![Copy Exercise](https://img.shields.io/badge/Copy%20Exercise-%E2%86%92-1f883d?style=for-the-badge&logo=github&labelColor=197935)](https://github.com/new?template_owner=org-study-bts&template_name=ghas-secure-payments-hands-on&owner=%40me&name=ghas-secure-payments-hands-on&description=Exercise%3A%20GHAS%20Secure%20Payments%20Hands-on&visibility=public)

   O botão é um link estático: sua validade pode ser conferida pelo formato e
   pelos parâmetros, mas a criação da cópia é uma operação do GitHub.com.
   Conta, permissões, template público e políticas precisam ser validados
   operacionalmente na própria conta; se isso não for testado, registre
   **Pendente**, nunca **Validado**.
2. Abra **Code > Codespaces > Create codespace on main**. Alternativamente, use Java 17 e Maven localmente.
3. Aguarde a criação do Codespace e siga as fases em `.github/steps/`.

O repositório público facilita a demonstração, mas não concede automaticamente todos os recursos. CodeQL, Dependabot, Dependency Review, Secret Scanning, Push Protection, Codespaces e Security Overview podem depender do plano, da organização, de políticas, de permissões e da configuração do repositório. O instrutor possui um ambiente Enterprise para mostrar recursos que podem não aparecer na cópia do participante. Nenhuma fase depende exclusivamente de um resultado assíncrono ou de um recurso pago.

## Objetivos de aprendizagem

Ao concluir, você deverá conseguir:

- explicar shift-left e o papel do GHAS no ciclo de desenvolvimento;
- distinguir Code Scanning/CodeQL, Secret Scanning/Push Protection e Dependabot;
- revisar dependências diretas e transitivas e uma alteração em pull request;
- analisar origem, fluxo, impacto e causa raiz de um alerta;
- priorizar risco, corrigir, testar, reanalisar e registrar a decisão;
- usar o Copilot como apoio, sem substituir CodeQL, testes ou revisão humana.

## A aplicação

```text
GET  /health
GET  /payments
GET  /payments/{id}
POST /payments
POST /payments/{id}/authorize
```

Não use dados reais. O corpo de criação é, por exemplo, `{"amount":12.50,"currency":"BRL","description":"Demo payment"}`. A validação rejeita valor não positivo, moeda fora de três letras e descrição vazia ou longa demais.

```bash
./mvnw test
./mvnw spring-boot:run
```

No Windows use `mvnw.cmd test`. `mvn test` é somente fallback documentado.
Com a aplicação em execução, teste `http://localhost:8080/health`. No Codespaces, use a porta encaminhada 8080. Os testes cobrem inicialização, saúde, criação, consulta, autorização, validação e o comportamento seguro tratado na fase de CodeQL.

## Fases

1. **Baseline e Codespaces** — estrutura, branch, testes, Actions e limites do ambiente.
2. **Code Scanning e CodeQL** — alerta didático controlado, análise de fluxo, correção e validação.
3. **Dependabot e Dependency Review** — dependency graph, alertas, atualizações e revisão de pull request.
4. **Triagem e validação** — risco contextual, correção, reanálise, encerramento e prevenção.

As instruções estão em `.github/steps/`. O workflow de progressão inicial usa
`skills/exercise-toolkit` (ref imutável confirmada); CodeQL, testes e Dependency
Review permanecem em workflows separados. Os workflows são determinísticos
quando possível e validam arquivos e testes; a análise do GitHub pode continuar
após o workflow terminar.

## Segurança demonstrada

O fixture em `.github/codeql/unsafe-demo/` é código fictício, isolado e não é usado como serviço. Ele serve para discutir uma construção insegura sem fornecer um exploit contra terceiros. Remova-o ou substitua-o por uma implementação segura na fase 2.

Secret Scanning procura padrões que se parecem com credenciais; Push Protection tenta impedir que cheguem ao repositório. Este exercício **não contém segredo real, token funcional, chave privada, dado pessoal ou dado financeiro**. Nunca crie um segredo real para testar: uma exposição real deve ser revogada/rotacionada junto ao provedor, removida do histórico quando necessário e substituída por credencial de menor privilégio. A detecção de um marcador fictício não é garantida e não libera nenhuma fase.

## Limitações importantes

- **CodeQL/Code Scanning:** a análise é assíncrona, tem cobertura e precisão limitadas e requer permissões de `security-events`; advanced setup é opcional e default setup pode não estar disponível em toda conta.
- **Dependabot:** alertas dependem do dependency graph e dos advisories conhecidos; security updates corrigem vulnerabilidades conhecidas, enquanto version updates mantêm versões atualizadas. Nenhum deles prova que não há risco.
- **Dependency Review:** normalmente roda em pull requests e pode ser bloqueada por políticas ou permissões; o workflow deste exercício usa severidade alta como exemplo e não substitui revisão.
- **Secret Scanning/Push Protection:** disponibilidade, padrões, alertas de parceiros e bypasses variam por plano e configuração. Um bypass precisa de justificativa.
- **Actions e Codespaces:** organizações podem restringir actions, runners, consumo ou criação de Codespaces.
- **Security Overview:** é uma visão organizacional, depende de permissões e plano Enterprise e não substitui a leitura de cada alerta. A conclusão do exercício não depende dela.
- **Copilot:** pode errar ou inventar contexto; toda sugestão deve ser confrontada com o código, testes e revisão humana.

## Troubleshooting

- Se `mvn` não for encontrado localmente, reabra o Codespace ou instale Java 17/Maven; o `devcontainer.json` já prepara ambos.
- Se CodeQL ainda estiver processando, aguarde a análise e use `./mvnw test` como validação local.
- Se Dependabot não abrir PR, confirme que o dependency graph está habilitado e trate a configuração como material demonstrativo.
- Se Secret Scanning ou Security Overview não aparecer, registre a limitação do plano/permissão e siga com os artefatos locais.
- Se uma Action for bloqueada por política, leia o log e execute os testes localmente; não afrouxe permissões sem revisão.

## Próximos passos e referências

Leia o `INSTRUCTOR-GUIDE.md` e `SLIDES.md`, depois pratique em um repositório de laboratório separado. Referências oficiais:

- [GitHub Advanced Security](https://docs.github.com/en/get-started/learning-about-github/about-github-advanced-security)
- [Code scanning com CodeQL](https://docs.github.com/en/code-security/code-scanning/introduction-to-code-scanning/about-code-scanning-with-codeql)
- [Secret scanning e push protection](https://docs.github.com/en/code-security/secret-scanning/introduction/about-secret-scanning)
- [Dependabot](https://docs.github.com/en/code-security/dependabot)
- [Dependency review](https://docs.github.com/en/code-security/dependabot/working-with-dependabot/dependency-review)
- [GitHub Skills](https://skills.github.com/)

Consulte `SECURITY.md` antes de relatar qualquer problema.
