package siga;

/**
 * Fábrica Abstrata (Abstract Factory) para criação de famílias de objetos
 * de acesso a dados (Conexao e Comando).
 *
 * Garante que qualquer cliente instancie apenas conexões e comandos
 * compatíveis entre si, eliminando a possibilidade de misturar fornecedores.
 */
public interface FabricaBanco {
    Conexao criarConexao();
    Comando criarComando();
}
