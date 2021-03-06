package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ComandosSQL {

    MySQL db = new MySQL("localhost", "iescola", "root", "");
    String query;
    ResultSet rs = null;

    /**
     * *****************************************************************************************
     */
    public void add_universitario(int id, String nome, String nasc, String fone, String dia, String rua, int numero, String complemento, String bairro, int cidade, int faculdade, int escola) {
        if (db.connect()) {
            query = "INSERT INTO UNIVERSITARIOS(nome, nasc, telefone, dia, rua, numero, complemento, bairro, idcidade, idfaculdade, idescola) VALUES"
                    + "('" + nome + "','" + nasc + "','" + fone + "','" + dia + "','" + rua + "'," + numero + ",'" + complemento + "','" + bairro + "'," + cidade + ", "+ faculdade +", "+ escola +");";
            System.out.println(query);
            db.inserir(query);
        }
    }

    public void add_universitario(int id, String nome, String nasc, String fone, String dia, String rua, int numero, String complemento, String bairro, int cidade, String foto, int faculdade, int escola) {
        if (db.connect()) {
            query = "INSERT INTO UNIVERSITARIOS(nome, nasc, telefone, dia, rua, numero, complemento, bairro, idcidade, foto, idfaculdade) VALUES"
                    + "('" + nome + "','" + nasc + "','" + fone + "','" + dia + "','" + rua + "'," + numero + ",'" + complemento + "','" + bairro + "'," + cidade + ",LOAD_FILE(" + foto + "), "+ faculdade +");";
            System.out.println(query);
            db.inserir(query);
        }
    }

    public void add_projeto(int id, String nome, int idescola, int idorganizador, String inicio, String fim) {
        if (db.connect()) {
            query = "INSERT INTO PROJETOS(id,nome,id_escola,id_organizador,data_inicio,data_final) VALUES"
                    + "('" + id + "','" + nome + "','" + idescola + "','" + idorganizador + "','" + inicio + "','" + fim + "');";
            db.inserir(query);
        }
    }

    public void add_inventario(int cod, String descricao, int qntd, String medida, String modif) {
        if (db.connect()) {
            query = "INSERT INTO INVENTARIO(codigo,descricao,quantidade,medida,modificacao) VALUES"
                    + "('" + cod + "','" + descricao + "','" + qntd + "','" + medida + "','" + modif + "');";
            db.inserir(query);
        }
    }

    public void add_folga(int codigo, String nome, String data_folga, String inclusao) {
        if (db.connect()) {
            query = "INSERT INTO FOLGAS(codigo,nome,data,inclusao) VALUES"
                    + "('" + codigo + "','" + nome + "','" + data_folga + "','" + inclusao + "');";
            db.inserir(query);
        }
    }

    /**
     * *****************************************************************************************
     */
    public void update_universitario(int codigo, String nome, String login, String nasc, String dia) {
        if (db.connect()) {
            query = "UPDATE UNIVERSITARIOS set NOME = '" + nome + "', LOGIN = '" + login + "', NASCIMENTO = '" + nasc + "', DIA = '" + dia + "'"
                    + "WHERE CODIGO = '" + codigo + "';";
            db.inserir(query);
        }
    }
    
    public void update_universitario(int id, String nome, String nasc, String fone, String dia, String rua, int numero, String complemento, String bairro, int idcidade, int idfaculdade, int idescola) {
        if (db.connect()) {
            query = "UPDATE UNIVERSITARIOS SET NOME='" + nome + "', NASC='" + nasc + "', TELEFONE='" + fone + "', DIA='" + dia + "', RUA='" + rua + "', NUMERO=" + numero + ", COMPLEMENTO='" + complemento + "', BAIRRO='" + bairro + "', IDCIDADE=" + idcidade + ", IDFACULDADE=" + idfaculdade + ", IDESCOLA=" + idescola + " WHERE ID=" + id + ";";
            System.out.println(query);
            db.inserir(query);
        }
    }
    
    public void update_universitario_foto(int id, String nome, String nasc, String fone, String dia, String rua, int numero, String complemento, String bairro, int idcidade, String foto, int idfaculdade, int idescola) {
        if (db.connect()) {
            query = "UPDATE UNIVERSITARIOS SET NOME='" + nome + "', NASC='" + nasc + "', TELEFONE='" + fone + "', DIA='" + dia + "', RUA='" + rua + "', NUMERO=" + numero + ", COMPLEMENTO='" + complemento + "', BAIRRO='" + bairro + "', IDCIDADE=" + idcidade + ", IDFACULDADE=" + idfaculdade + ", IDESCOLA=" + idescola + " WHERE ID=" + id + ";";
            System.out.println(query);
            db.inserir(query);
        }
    }

    public void update_projetos(int codigo, String nome, String organizador, String inicio, String fim) {
        if (db.connect()) {
            query = "UPDATE PROJETOS set CODIGO = '" + codigo + "', NOME = '" + nome + "', ORGANIZADOR = '" + organizador + "', INICIO = '" + inicio + "', FIM  = '" + fim + "'"
                    + "WHERE CODIGO = '" + codigo + "';";
            db.inserir(query);
        }
    }

    public void update_inventario(int cod, String descricao, String quantidade, String medida, String data) {
        if (db.connect()) {
            query = "UPDATE INVENTARIO set CODIGO = '" + cod + "', DESCRICAO = '" + descricao + "', QUANTIDADE = '" + quantidade + "', MEDIDA = '" + medida + "', MODIFICACAO  = '" + data + "'"
                    + "WHERE CODIGO = '" + cod + "';";
            db.inserir(query);
        }
    }

    public void update_folga(int codigo, String nome, String data, String inclusao) {
        if (db.connect()) {
            query = "UPDATE FOLGAS set NOME = '" + nome + "', DATA = '" + data + "', INCLUSAO = '" + inclusao + "' "
                    + "WHERE CODIGO = '" + codigo + "'";
            db.inserir(query);
        }
    }

    /**
     * *****************************************************************************************
     */
    public String getMaxUniversitario() throws ClassNotFoundException, SQLException {
        String codigo = null;
        if (db.connect()) {
            query = "SELECT MAX(ID) AS COD FROM UNIVERSITARIOS";
            rs = db.executar(query);

            while (rs.next()) {
                codigo = rs.getString("COD");
            }
        }
        return codigo;
    }

    public int getMaxProjetos() throws ClassNotFoundException, SQLException {
        int codigo = 0;
        if (db.connect()) {
            query = "SELECT MAX(ID) AS COD FROM PROJETOS";
            rs = db.executar(query);

            while (rs.next()) {
                codigo = rs.getInt("COD");
            }
        }
        return codigo;

    }

    public String getMaxInventario() throws ClassNotFoundException, SQLException {
        String codigo = null;
        if (db.connect()) {
            query = "SELECT MAX(ID_INVENTARIO) AS COD FROM INVENTARIO";
            rs = db.executar(query);

            while (rs.next()) {
                codigo = rs.getString("COD");
            }
        }
        return codigo;

    }

    public String getMaxFolga() throws ClassNotFoundException, SQLException {
        String codigo = null;
        if (db.connect()) {
            query = "SELECT MAX(ID_FOLGAS) AS COD FROM UNIVERSITARIOS";
            rs = db.executar(query);

            while (rs.next()) {
                codigo = rs.getString("COD");
            }
        }

        if (codigo == null) {
            codigo = "0";
            return codigo;
        } else {
            return codigo;
        }

    }

    /**
     * *****************************************************************************************
     */
    public void insert_adm(String user, int pass) {
        try {
            String usuario = user;
            int senha = pass;
            Class.forName("org.hsqldb.jdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:C:/Users/Gu/Documents/Banco de Dados/db", "sa", "");
            java.sql.Statement stm = con.createStatement();

            stm.executeQuery("INSERT INTO LOGIN(user,password) VALUES('" + usuario + "','" + senha + "');");

            System.out.println("OK");

            stm.execute("SHUTDOWN");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver JDBC. ");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e);
            e.printStackTrace();
        }
    }

    /**
     * *****************************************************************************************
     */
    public JTable search_uni(String texto, JTable tabela) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM UNIVERSITARIOS WHERE NOME LIKE '%" + texto + "%'";
            rs = db.executar(query);

            String cod, nome, login, nascimento, dia;
            int linha = 0;
            while (rs.next()) {
                cod = rs.getString("CODIGO");
                nome = rs.getString("NOME");
                login = rs.getString("LOGIN");
                nascimento = rs.getString("NASCIMENTO");
                dia = rs.getString("DIA");

                tabela.setValueAt(cod, linha, 0);
                tabela.setValueAt(nome, linha, 1);
                tabela.setValueAt(login, linha, 2);
                tabela.setValueAt(nascimento, linha, 3);
                tabela.setValueAt(dia, linha, 4);

                linha++;

            }
        }
        return tabela;
    }
    
    public ResultSet search_id_uni(String id) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM UNIVERSITARIOS WHERE ID = " + id + "";
            System.out.println(query);
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet search_id_proj(String id) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM PROJETOS WHERE ID = " + id + "";
            System.out.println(query);
            rs = db.executar(query);
        }
        return rs;
    }

    public JTable search_proj(String texto, JTable tabela) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM PROJETOS WHERE NOME LIKE '%" + texto + "%'";
            rs = db.executar(query);

            String cod, nome, organizador, inicio, fim;
            int linha = 0;
            while (rs.next()) {
                cod = rs.getString("CODIGO");
                nome = rs.getString("NOME");
                organizador = rs.getString("ORGANIZADOR");
                inicio = rs.getString("INICIO");
                fim = rs.getString("FIM");

                tabela.setValueAt(cod, linha, 0);
                tabela.setValueAt(nome, linha, 1);
                tabela.setValueAt(organizador, linha, 2);
                tabela.setValueAt(inicio, linha, 3);
                tabela.setValueAt(fim, linha, 4);

                linha++;

            }
        }
        return tabela;
    }

    public JTable search_inv(String texto, JTable tabela) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM INVENTARIO WHERE DESCRICAO LIKE '%" + texto + "%'";
            rs = db.executar(query);

            String cod, descricao, quantidade, medida, modificacao;
            int linha = 0;
            while (rs.next()) {
                cod = rs.getString("CODIGO");
                descricao = rs.getString("DESCRICAO");
                quantidade = rs.getString("QUANTIDADE");
                medida = rs.getString("MEDIDA");
                modificacao = rs.getString("MODIFICACAO");

                tabela.setValueAt(cod, linha, 0);
                tabela.setValueAt(descricao, linha, 1);
                tabela.setValueAt(quantidade, linha, 2);
                tabela.setValueAt(medida, linha, 3);
                tabela.setValueAt(modificacao, linha, 4);

                linha++;

            }
        }
        return tabela;
    }

    public JTable search_fol(String texto, JTable tabela) throws ClassNotFoundException, SQLException {
        if (db.connect()) {
            query = "SELECT * FROM FOLGAS WHERE NOME LIKE '%" + texto + "%'";
            rs = db.executar(query);

            String id, nome, data, inclusao;
            int linha = 0;
            while (rs.next()) {
                id = rs.getString("ID");
                nome = rs.getString("NOME");
                data = rs.getString("DATA");
                inclusao = rs.getString("INCLUSAO");

                tabela.setValueAt(id, linha, 0);
                tabela.setValueAt(nome, linha, 1);
                tabela.setValueAt(data, linha, 2);
                tabela.setValueAt(inclusao, linha, 3);

                linha++;

            }
        }
        return tabela;
    }

    /**
     * *****************************************************************************************
     */
    public void delete_line_uni(int cod) {
        if (db.connect()) {
            query = "DELETE FROM FOLGAS WHERE ID_UNIVERSITARIO = " + cod + "";
            db.Deletar(query);
            query = "DELETE FROM UNIVERSITARIOS WHERE ID = " + cod + "";
            db.Deletar(query);
        }
    }

    public void delete_line_proj(int cod) {
        if (db.connect()) {
            query = "DELETE FROM PROJETOS WHERE ID = " + cod + "";
            db.Deletar(query);
        }
    }

    public void delete_line_inv(int cod) {
        if (db.connect()) {
            query = "DELETE FROM INVENTARIO WHERE CODIGO = " + cod + "";
            db.executar(query);
        }
    }

    public void delete_line_folga(int cod) {
        if (db.connect()) {
            query = "DELETE FROM FOLGAS WHERE CODIGO = " + cod + "";
            db.executar(query);
        }
    }

    public void delete_all_uni() {
        if (db.connect()) {
            query = "DELETE FROM UNIVERSITARIOS;";
            rs = db.executar(query);
        }
    }

    /**
     * *****************************************************************************************
     * @return 
     */
    public ResultSet getUniv() {
        if (db.connect()) {
            query = "SELECT U.ID ID, U.NOME UNI, U.DIA DIA, E.NOME ESCOLA, F.NOME FACULDADE FROM UNIVERSITARIOS U JOIN ESCOLAS E ON U.IDESCOLA = E.ID JOIN FACULDADES F ON U.IDFACULDADE = F.ID;";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getProj() {
        if (db.connect()) {
            query = "SELECT P.ID ID, P.NOME NOME, E.NOME ESCOLA, U.NOME UNI, P.DATA_INICIO INI, P.DATA_FINAL FIM FROM PROJETOS P JOIN UNIVERSITARIOS U ON P.ID_ORGANIZADOR = U.ID JOIN ESCOLAS E ON P.ID_ESCOLA = E.ID";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getEscola() {
        if (db.connect()) {
            query = "SELECT * FROM ESCOLAS";
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet getFacul() {
        if (db.connect()) {
            query = "SELECT * FROM FACULDADES";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getFol() {
        if (db.connect()) {
            query = "SELECT F.ID_FOLGAS ID, U.NOME UNI, E.NOME ESCOLA, F.DATA_FOLGA FOLGA, F.DATA_INCLUSAO INCLUSAO FROM FOLGAS F JOIN UNIVERSITARIOS U ON F.ID_UNIVERSITARIO = U.ID JOIN ESCOLAS E ON U.IDESCOLA = E.ID";
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet getCoord() {
        if (db.connect()) {
            query = "SELECT * FROM COORDENADORES";
            rs = db.executar(query);
        }
        return rs;
    }
    
    /**
     * *****************************************************************************************
     */

    public ResultSet getUniv_search(String texto) {
        if (db.connect()) {
            query = "SELECT * FROM UNIVERSITARIOS WHERE NOME = '" + texto + "'";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getProj_search(String texto) {
        if (db.connect()) {
            query = "SELECT * FROM UNIVERSITARIOS WHERE NOME = '" + texto + "'";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getFol_search(String texto) {
        if (db.connect()) {
            query = "SELECT * FROM FOLGAS WHERE NOME = '" + texto + "'";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet getInv_search(String texto) {
        if (db.connect()) {
            query = "SELECT * FROM INVENTARIO WHERE NOME = '" + texto + "'";
            rs = db.executar(query);
        }
        return rs;
    }
    
    /**
     * *****************************************************************************************
     */
    
    public ResultSet listar_universitarios_query(int idescola) {
        if (db.connect()) {
            query = "SELECT * FROM `UNIVERSITARIOS` WHERE IDESCOLA = "+ idescola +"";
            rs = db.executar(query);
        }
        return rs;
    }
    
    /**
     * *****************************************************************************************
     */

    public ResultSet listar_estados() {
        if (db.connect()) {
            query = "SELECT * FROM `ESTADOS`";
            rs = db.executar(query);
        }
        return rs;
    }

    public ResultSet listar_cidades() {
        if (db.connect()) {
            query = "SELECT * FROM `CIDADES` ORDER BY NOME";
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet listar_faculdades() {
        if (db.connect()) {
            query = "SELECT NOME FROM FACULDADES ORDER BY NOME ASC";
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet listar_escolas() throws SQLException {
        if (db.connect()) {
            query = "SELECT NOME FROM ESCOLAS ORDER BY NOME ASC";
            rs = db.executar(query);
        }
        return rs;
    }
    
    public ResultSet listar_cursos() {
        if (db.connect()) {
            query = "SELECT NOME FROM CURSOS ORDER BY NOME ASC";
            rs = db.executar(query);
        }
        return rs;
    }
    
    /**
     * *****************************************************************************************
     */
    
    public ResultSet popular_combo_universitarios(String nome_escola) {
        if (db.connect()) {
            query = "SELECT U.NOME FROM UNIVERSITARIOS U JOIN ESCOLAS E ON U.IDESCOLA = E.ID WHERE E.NOME='"+ nome_escola +"'";
            rs = db.executar(query);
        }
        return rs;
    }
    
    /**
     * *****************************************************************************************
     */
    
    public int busca_iduniversitario(String universitario) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM `universitarios` WHERE NOME = '" + universitario + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    public int busca_idprojeto(String projeto) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM `cursos` WHERE NOME = '" + projeto + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    public int busca_idcurso(String escola) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM `cursos` WHERE NOME = '" + escola + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    public int busca_idcidade(String cidade) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM `cidades` WHERE NOME = '" + cidade + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    public int busca_idfaculdade(String faculdade) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM FACULDADES WHERE NOME = '" + faculdade + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    public int busca_idescola(String escola) throws SQLException {
        int id = 0;
        if (db.connect()) {
            query = "SELECT ID FROM `escolas` WHERE NOME = '" + escola + "'";
            rs = db.executar(query);

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        }
        return id;
    }
    
    /**
     * *****************************************************************************************
     */
    
    public String busca_nomeuniversitario(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM `universitarios` WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }
    
    public String busca_nomeprojeto(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM `projetos` WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }

    public String busca_nomecidade(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM `cidades` WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }
    
    public String busca_nomefaculdade(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM FACULDADES WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }
    
    public String busca_nomecurso(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM `cursos` WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }
    
    public String busca_nomeescola(int id) throws SQLException {
        String nome = null;
        if (db.connect()) {
            query = "SELECT NOME FROM `escolas` WHERE ID = " + id + "";
            rs = db.executar(query);

            while (rs.next()) {
                nome = rs.getString("NOME");
            }
        }
        return nome;
    }
    
    /**
     * *****************************************************************************************
     */
    
    public void imagem(String dir) throws FileNotFoundException {
        if (db.connect()) {
            //query = "SELECT ID FROM `cidades` WHERE NOME = '" + cidade + "'";
            rs = db.executar(query);
            
            File file = new File(dir);
            FileInputStream inputStream = new FileInputStream(file);

            //PreparedStatement statement = connection.prepareStatement("INSERT INTO yourTable (yourBlob) VALUES (?)");
            //statement.setBlob(1, inputStream);
        }
    }
    
    public void insert_foto() {
        if (db.connect()) {
            String dir = "C:\\Users\\Gu\\Desktop\\foto.jpg";
            query = "INSERT INTO UNIVERSITARIOS (id,foto) VALUES (1,LOAD_FILE(" + dir + "))";
            rs = db.executar(query);
        }
    }
}
