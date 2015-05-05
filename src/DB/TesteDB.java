package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gu
 */
public class TesteDB {

    public static void main(String[] args) {
        MySQL db = new MySQL("localhost", "projeto", "root", "");
        String query;
        int result;

        if (db.connect()) {
            System.out.println("Conectado!");
            System.out.println("Rodando uma query contra o banco");

            query = "select * from usuario";
            ResultSet rs = db.executar(query);
            try {
                if (rs != null) { // Verifica se a query retornou algo
                    while (rs.next()) {
                        // Podemos referenciar a coluna pelo índice
                        System.out.println("Id: " + rs.getInt(1));

                        // Ou pelo seu nome
                        System.out.println("Nome: " + rs.getString("nome"));
                        System.out.println("Idade: " + rs.getInt("idade"));
                        System.out.println("—————————-");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Inserindo dados na tabela");
            query = "insert into usuario (nome, idade) values ('Maria',23)";
            result = db.inserir(query);
            if (result > -1) {
                System.out.println("Dado inserido com sucesso! Resutlt = " + result);
            } else {
                System.out.println("Erro inserindo dado.");
            }

            query = "update usuario set idade = 99";
            result = db.inserir(query);
            if (result > -1) {
                System.out.println("Dado inserido com sucesso! Resutlt = " + result);
            } else {
                System.out.println("Erro inserindo dado.");
            }

        };
    }

}
