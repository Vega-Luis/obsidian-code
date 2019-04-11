package gui;

import java.text.SimpleDateFormat;

import java.util.Date;
import bussineslogic.Branch;

public class DestinyDelivery {
  private Branch sedeRecogida;
  private Branch sedeEntrega;
  private Date fechaEntrega;
  private Date fechaRecogida;
  
  public DestinyDelivery(Branch sedeRecogida, Branch sedeEntrega, Date fechaEntrega, Date fechaRecogida) {
    this.sedeEntrega = sedeEntrega;
    this.sedeRecogida = sedeRecogida;
    this.fechaEntrega = fechaEntrega;
    this.fechaRecogida = fechaRecogida;
  }
  
  public Branch getSedeRecogida() {
    return sedeRecogida;
  }
  public void setSedeRecogida(Branch sedeRecogida) {
    this.sedeRecogida = sedeRecogida;
  }
  public Branch getSedeEntrega() {
    return sedeEntrega;
  }
  public void setSedeEntrega(Branch sedeEntrega) {
    this.sedeEntrega = sedeEntrega;
  }
  public Date getFechaEntrega() {
    return fechaEntrega;
  }
  public void setFechaEntrega(Date fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }
  public Date getFechaRecogida() {
    return fechaRecogida;
  }
  public void setFechaRecogida(Date fechaRecogida) {
    this.fechaRecogida = fechaRecogida;
  }
  
  public String toStringFechaEntrega() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaEntrega);
  }
  
  public String toStringFechaRecogida() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaRecogida);
  }
}
