# Diagnóstico - Etapa 1

## 1. Mistura de Variações (Fornecedores Diferentes)

- **Onde está:** Em `AcessoDados.java`, no método `conectar`.
- **O problema:** A conexão e o comando são instanciados soltos, usando `if/else` e `new` separados. Não há nada no código que garanta que os dois pertençam ao mesmo banco. Dá para criar por engano uma `ConexaoMySQL` com um `ComandoPostgreSQL`: o Java compila sem reclamar e o erro só explode em tempo de execução.
- **Como resolver:** Aplicar o padrão **Abstract Factory** para que uma fábrica específica crie a família completa e compatível (conexão + comando) do mesmo fornecedor.

---

## 2. Construtor / Método Telescópico

- **Onde está:** Em `AcessoDados.java`, no método `montarConsulta`.
- **O problema:** O método recebe uma lista enorme de 7 parâmetros (`tabela, filtro, ordenacao, limite, offset, timeoutSegundos, somenteAtivos`).
  - **Ilegível:** Na chamada (`montarConsulta("aluno", "curso = 'DSM'", "nome", 50, 0, 30, true)`), ninguém sabe de cabeça o que cada número ou booleano significa.
  - **Fácil de errar:** Vários parâmetros são do mesmo tipo (`int`), facilitando inverter a ordem sem perceber.
  - **Inflexível:** Obriga a passar valores padrão/nulos (`0`, `null`, `false`) mesmo quando a consulta não usa esses recursos. Além disso, o parâmetro `timeoutSegundos` foi declarado e nem sequer é usado no método.
- **Como resolver:** Aplicar o padrão **Builder** para montar a consulta de forma fluente e encadeada (`.comFiltro(...)`, `.comLimite(...)`), definindo apenas o que for necessário.
