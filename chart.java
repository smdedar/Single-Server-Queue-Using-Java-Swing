package testChart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.Color;  
  
public class chart extends JFrame {  
	showintable asd = new showintable();
	int s[] = asd.testas();
	//System.out.println(s);
  //private static final long serialVersionUID = 1L;  
  
  public chart(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Single Server Queue Chart", //Chart Title  
        "Time", // Category axis  
        "No of Customer", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    panel.setBackground(Color.WHITE);
    setContentPane(panel);
    panel.setLayout(null);
  }  
  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
    // Population in 2005  
    dataset.addValue(s[0], "Time", "3"); 
    dataset.addValue(s[1], "Time", "6"); 
    dataset.addValue(s[2], "Time", "9"); 
    dataset.addValue(s[3], "Time", "12"); 
    dataset.addValue(s[4], "Time", "15");
  
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      chart example=new chart("Bar Chart Window");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    }); 
    
   
  }  
}  