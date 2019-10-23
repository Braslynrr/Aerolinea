package aerolinea;

import aerolinea.presentacion.tipoavion.TipoAvionController;
import aerolinea.presentacion.tipoavion.TipoAvionModel;
import aerolinea.presentacion.tipoavion.TipoAvionView;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalController;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalModel;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {
    
  CardLayout windows;
  Container container;
    public Main()
  {
    windows = new CardLayout();
    container = this.getContentPane();
    container.setLayout(windows);
     
    TipoAvionModel model = new TipoAvionModel();
    TipoAvionView view = new TipoAvionView(this);
    TipoAvionController controller = new TipoAvionController(model,view);
    
    this.addWindow(view, "tipoavion");
    this.initComponents();
    
  }
    public void initComponents()
  {
    this.setTitle("prueba");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.swapWindow("tipoavion");
    
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  } 
    public static void main(String[] args) 
    {
        try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
    {
      System.err.println("error: invalid look and feel.");
    }
    
    java.awt.EventQueue.invokeLater(Main::new);
    }
    
    
    public void swapWindow(String window)
  {
    windows.show(container, window);
  }
    public void addWindow(JPanel window, String name)
  {
    container.add(window);
    windows.addLayoutComponent(window, name);
  }
}
