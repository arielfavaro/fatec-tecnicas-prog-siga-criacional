package siga;

/**
 * Fábrica concreta para a família de acesso a dados do fornecedor MySQL.
 */
public class FabricaMySQL implements FabricaBanco {

    @Override
    public Conexao criarConexao() {
        return new ConexaoMySQL();
    }

    @Override
    public Comando criarComando() {
        return new ComandoMySQL();
    }
}
