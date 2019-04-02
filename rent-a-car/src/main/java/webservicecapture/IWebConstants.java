package webservicecapture;

public interface IWebConstants {
  public final short BUY = 317;
  public final short SELL = 318;
  public final String VALUE_TAG = "NUM_VALOR";
  public final String TC_INDICATOR = "tcIndicador=";
  public final String BEGIN_DATE = "&tcFechaInicio=";
  public final String FINISH_DATE = "&tcFechaFinal=";
  public final String TC_NAME = "&tcNombre=Obsidian-code";
  public final String TC_SUBLEVELS = "&tnSubNiveles=N";
  public final String TAG = "NUM_VALOR";
  public final String HOST = "http://indicadoreseconomicos"
      + ".bccr.fi.cr/indicadoreseconomicos/WebServices"
          + "/wsindicadoreseconomicos.asmx/"
              + "ObtenerIndicadoresEconomicosXML?";

}
