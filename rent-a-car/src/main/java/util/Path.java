package util;
/*
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 */

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 * Establece comunicacion con google maps, para obtener un mapa con el recorrido de un vehiculo.
 * @author Luis
 * @version v19.4.10
 */
public class Path implements IMapConstants{
  
  /**
   * Construye un  mapa a partir de coordenadas de inicio y fin de un recorrido.
   * @param startLong Logitud inicial.
   * @param startLat Latitud inicial.
   * @param endLong Longitud final.
   * @param endLat Latitud final.
   */
    public static void map(String startLong, String startLat, String endLong, String endLat) {
      String url = HOST + startLong + "," + startLat + "/" + endLong+ "," 
          + endLat + "/@" + startLong + "," + startLat + HOST_END;
      
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        browser.loadURL(url);
    }
}
