package agenda.controle;

import agenda.exception.AgendaException;
import agenda.modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
1. Esta classe deve implementar apenas recursos relacionados ao acesso ao banco de dados.
2. Não deve ser utilizado nenhum recurso da camada de apresentação, como por exemplo JOptionPane. 
   Para apresentar mensagens para os usuário utilize a exception AgendaException que deve ser
   tratada na classe AgendaContados
4. Esta classe deve utilizar o objeto agenda.controle.Conexao para obter acesso ao banco de dados.
DAO = Data Access Object
 */
public class AgendaContatosDao {

    /**
     * Implementar a funcionalidade para inserir uma pessoa no banco de dados
     */
    public void insert(Pessoa p) throws AgendaException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "insert into agenda_contatos (nome, endereco, telefone) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEndereco());
            ps.setString(3, p.getTelefone());
            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            new AgendaException("ERRO: " + e.getMessage());
            // PERGUNTAR COMO RESOLVER ESSE PROBLEMA - MAIS DE UM THROW

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Implementar a funcionalidade para atualizar uma pessoa no banco de dados
     */
    public void update(Pessoa p) throws AgendaException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "update agenda_contatos set endereco = ?, telefone = ? where nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(3, p.getNome());
            ps.setString(1, p.getEndereco());
            ps.setString(2, p.getTelefone());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            new AgendaException("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Implementar a funcionalidade para excluir uma pessoa no banco de dados
     */
    public void delete(Pessoa p) throws AgendaException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "delete from agenda_contatos where nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.execute();

            conn.commit();
        } catch (SQLException e) {
            new AgendaException("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * Implementar a funcionalidade para verificar se a pessoa informada existe
     * no banco de dados
     */
    public boolean exists(Pessoa p) throws AgendaException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select nome from agenda_contatos where nome = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            throw new AgendaException("ERRO: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        }
        return false;
    }

    /**
     * Implementar a funcionalidade para retornar todas as pessoas do banco de dados
     */
    public ArrayList<Pessoa> getAll() throws AgendaException {
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexao.getConnection();
            String sql = "select nome, endereco, telefone from agenda_contatos";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString(1);
                String endereco = rs.getString(2);
                String telefone = rs.getString(3);
                Pessoa p = new Pessoa();
                p.setNome(nome);
                p.setEndereco(endereco);
                p.setTelefone(telefone);
                lista.add(p);
            }
        } catch (SQLException ex) {
            throw new AgendaException("ERRO: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new AgendaException("ERRO: " + ex.getMessage());
                }
            }
        }
        return lista;
    }
}
