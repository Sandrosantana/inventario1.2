/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle_banco;

import acesso_banco.DaoUtil;
import java.sql.Date;
import model.Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eu
 */
public class Control extends DaoUtil {

    public List<model.Modelo> recuperaRegistrosSimples() {
        String sql = "SELECT codigo, usuario, setor, "
                + "Serial, sistema_operacional, nome_de_maquina, processador, "
                + " memoria, hd, placa_mae, cd, estabilizador, mouse, teclado, monitor, "
                + " data_montagem, obs FROM tb_inventario";
        List<model.Modelo> lstret = new LinkedList<>();
        try {
            try (ResultSet rs = (ResultSet) getStatement()) {
                executeQuery(sql);
                while (rs.next()) {
                    lstret.add(new Modelo(rs.getInt("codigo"),
                            rs.getString("usuario"),
                            rs.getString("setor"),
                            rs.getString("Serial"),
                            rs.getString("sistema_operacional"),
                            rs.getString("nome_de_maquina"),
                            rs.getString("processador"),
                            rs.getString("memoria"),
                            rs.getString("hd"),
                            rs.getString("placa_mae"),
                            rs.getString("cd"),
                            rs.getString("estabilizador"),
                            rs.getString("mouse"),
                            rs.getString("teclado"),
                            rs.getString("monitor"),
                            rs.getDate("data_montagem"),
                            rs.getString("obs")));

                }
            }
            destroyConnection();
        } catch (SQLException e) {
            System.out.println("Erro de consulta " + e);
        }
        return lstret;
    }

    public ArrayList listaTodos() {
        String sql = "SELECT codigo, usuario, setor, "
                + "Serial, sistema_operacional, nome_de_maquina, processador, "
                + " memoria, hd, placa_mae, cd, estabilizador, mouse, teclado, monitor, "
                + " data_montagem, obs FROM tb_inventario";
        ArrayList lstret = new ArrayList();

        try (ResultSet rs = (ResultSet) getStatement()) {
            executeQuery(sql);
            {
                while (rs.next()) {
                    lstret.add(new Object[]{rs.getInt("codigo"),
                        rs.getString("usuario"),
                        rs.getString("setor"),
                        rs.getString("Serial"),
                        rs.getString("sistema_operacional"),
                        rs.getString("nome_de_maquina"),
                        rs.getString("processador"),
                        rs.getString("memoria"),
                        rs.getString("hd"),
                        rs.getString("placa_mae"),
                        rs.getString("cd"),
                        rs.getString("estabilizador"),
                        rs.getString("mouse"),
                        rs.getString("teclado"),
                        rs.getString("monitor"),
                        rs.getDate("data_montagem"),
                        rs.getString("obs")});
                }
            }
            destroyConnection();
        } catch (SQLException e) {
            System.out.println("Erro de consulta " + e);
        }
        return lstret;
    }

    public List<Modelo> recuperaRegistrosParametro(Modelo prod) {
        String sql = "SELECT codigo, usuario, setor, "
                + "Serial, sistema_operacional, nome_de_maquina, processador, "
                + " memoria, hd, placa_mae, cd, estabilizador, mouse, teclado, monitor, "
                + " data_montagem, obs FROM tb_inventario WHERE nome like ?";
        List<Modelo> lstret = new LinkedList<>();
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setString(1, "%" + prod.getUsuario() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstret.add(new Modelo(rs.getInt("codigo"),
                        rs.getString("usuario"),
                        rs.getString("setor"),
                        rs.getString("Serial"),
                        rs.getDate("data_montagem")));
            }
            rs.close();
            ps.close();
            destroyConnection();
        } catch (SQLException e) {
            System.out.println("Erro de consulta " + e);
        }
        return lstret;
    }

    public boolean inserirRegistro(Modelo prod) {
        String sql = "INSERT INTO tb_inventario "
                + "(codigo, usuario, setor, Serial, sistema_operacional, nome_de_maquina, processador, memoria, hd, placa_mae, cd, estabilizador, mouse, teclado, monitor, data_montagem, obs )) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int ret = 0;
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, prod.getCodigo());
            ps.setString(2, prod.getUsuario());
            ps.setString(3, prod.getSetor());
            ps.setString(4, prod.getSerial());
            ps.setString(5, prod.getSistema_operacional());
            ps.setString(6, prod.getNome_de_maquina());
            ps.setString(7, prod.getProcessador());
            ps.setString(8, prod.getMemoria());
            ps.setString(9, prod.getHd());
            ps.setString(10, prod.getPlaca_mae());
            ps.setString(11, prod.getCd());
            ps.setString(12, prod.getEstabilizador());
            ps.setString(13, prod.getMouse());
            ps.setString(14, prod.getTeclado());
            ps.setString(15, prod.getMonitor());
            ps.setDate(16, (Date) prod.getData_montagem());
            ps.setString(17, prod.getObs());
            ret = ps.executeUpdate();
            ps.close();
            destroyConnection();

        } catch (SQLException se) {
            System.out.println("Erro de Insert no SQL");
            System.out.println("Mensagem :" + se.getMessage());
            System.out.println("Cód.     :" + se.getErrorCode());
            System.out.println("SQL State:" + se.getSQLState());
        }
        return ret > 0;
    }

    public boolean alterarRegistro(Modelo prod) {
        String sql = "UPDATE tb_inventario SET "
                + "codigo=?, usuario=?, setor=?, serial=? "
                + " WHERE codigo=?";
        int ret = 0;
        try {
            PreparedStatement ps = getPreparedStatement(sql);
            ps.setInt(1, prod.getCodigo());
            ps.setString(2, prod.getUsuario());
            ps.setString(3, prod.getSetor());
            ps.setString(4, prod.getSerial());
            ret = ps.executeUpdate();
            ps.close();
            destroyConnection();

        } catch (SQLException se) {
            System.out.println("Erro de Insert no SQL");
            System.out.println("Mensagem :" + se.getMessage());
            System.out.println("Cód.     :" + se.getErrorCode());
            System.out.println("SQL State:" + se.getSQLState());
        }
        return ret > 0;
    }

    public boolean deletarRegistro(Modelo prod) {
        String sql = "DELETE FROM tb_inventario WHERE codigo = ?";
        int ret = 0;
        try {
            PreparedStatement pst = getPreparedStatement(sql);
            pst.setInt(1, prod.getCodigo());
            ret = pst.executeUpdate();
            pst.close();
            destroyConnection();
        } catch (SQLException e) {
            System.out.println("Erro de consulta " + e);
        }
        return ret > 0;
    }

    public Modelo recuperaRegistroPorID(Modelo prod) {
        String sql = "SELECT codigo, usuario, setor, "
                + "serial, sistema_operacional FROM tb_inventario WHERE codigo = ?";
        Modelo prodret = null;
        try {
            PreparedStatement ps = getPreparedStatement(sql);

            ps.setInt(1, prod.getCodigo());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prodret = new Modelo(rs.getInt("codigo"),
                        rs.getString("usuario"),
                        rs.getString("setor"),
                        rs.getString("serial"));

            }
            rs.close();
            ps.close();
            destroyConnection();
        } catch (SQLException e) {
            System.out.println("Erro de consulta " + e);
        }
        return prodret;
    }

    private PreparedStatement getPreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void destroyConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void executeQuery(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
