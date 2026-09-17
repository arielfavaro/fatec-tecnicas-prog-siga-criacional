package siga;

/**
 * Fábrica concreta para a família de acesso a dados do fornecedor PostgreSQL.
 */
public class FabricaPostgreSQL implements FabricaBanco {

    @Override
    public Conexao criarConexao() {
        return new ConexaoPostgreSQL();
    }

    @Override
    public Comando criarComando() {
        return new ComandoPostgreSQL();
    }
}
