package model;

import java.util.Date;

public class Modelo {

    private int codigo;
    private String usuario;
    private String setor;
    private String Serial;
    private String sistema_operacional;
    private String nome_de_maquina;
    private String processador;
    private String memoria;
    private String hd;
    private String placa_mae;
    private String cd;
    private String estabilizador;
    private String mouse;
    private String teclado;
    private String monitor;
    private Date data_montagem;
    private String obs;

    public Modelo() {
    }

    public Modelo(int aInt, String string, String string0, String string1, String string2, String string3, String string4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Modelo(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, java.sql.Date date, String string13) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Modelo(int aInt, String string, String string0, String string1, java.sql.Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Modelo(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public String getSistema_operacional() {
        return sistema_operacional;
    }

    public void setSistema_operacional(String sistema_operacional) {
        this.sistema_operacional = sistema_operacional;
    }

    public String getNome_de_maquina() {
        return nome_de_maquina;
    }

    public void setNome_de_maquina(String nome_de_maquina) {
        this.nome_de_maquina = nome_de_maquina;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getPlaca_mae() {
        return placa_mae;
    }

    public void setPlaca_mae(String placa_mae) {
        this.placa_mae = placa_mae;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getEstabilizador() {
        return estabilizador;
    }

    public void setEstabilizador(String estabilizador) {
        this.estabilizador = estabilizador;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getTeclado() {
        return teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public Date getData_montagem() {
        return data_montagem;
    }

    public void setData_montagem(Date data_montagem) {
        this.data_montagem = data_montagem;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
