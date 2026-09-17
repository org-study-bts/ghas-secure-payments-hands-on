# Fase 2 — Code Scanning e CodeQL

Ative Code Scanning com default setup quando a conta oferecer essa opção. O workflow `Phase 2 - code scanning` também ilustra advanced setup com configuração versionada em `.github/codeql/`. O fixture `UnsafeCodeqlDemo.java` é controlado, fictício e não é usado pela API; remova-o ou substitua-o por código seguro depois de observar o alerta.

Ao abrir um alerta, identifique arquivo, linha, consulta, severidade, security severity, origem do dado, fluxo e ponto vulnerável. CodeQL encontra padrões, mas a pessoa deve confirmar impacto e contexto.

Use no Copilot:

> Explique este alerta de CodeQL em linguagem simples. Identifique a origem do dado, o ponto vulnerável, o impacto potencial, a causa raiz e os testes necessários para validar uma correção. Não altere arquivos e não invente informações que não estejam presentes no código.

Depois da correção, use:

> Analise a correção proposta para este alerta. Verifique se ela elimina a causa raiz, preserva o comportamento esperado e possui testes suficientes. Não considere o alerta resolvido sem validação por testes e revisão humana.

Execute `mvn test`, faça push e confira a nova análise. Copilot pode errar; sua sugestão não substitui CodeQL, testes ou revisão humana. Ausência de alertas não prova que o sistema está completamente seguro, e falsos positivos e limitações são possíveis. Se a análise assíncrona ou o recurso não estiver disponível, use os testes e a revisão do diff como evidência; a progressão não depende do alerta aparecer.
