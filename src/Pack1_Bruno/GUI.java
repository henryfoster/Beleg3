package Pack1_Bruno;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{

	Integer[] gl = new Integer[1]; 
	
	ArrayList<String> graphlist;
	
	JSlider nslide, nslide2;
	public static JPanel table, pane, tabpane1, tabpane2, tabpane3;
	TitledBorder border;
	JButton newGraph, newKante, newKnoten, print;
	JComboBox<Integer> graphselector;
	public static int drawpointx, drawpointy;
	public static int rand = 20;
	graph[] graphen = new graph[19];
	JTabbedPane tabs;
	JComponent panel;
	JTextArea knotenanzahl, kantenanzahl, bezeichnung;
	
	JScrollPane JSP;
	public JTextArea jTextArea;
	public JTextField name;
	
	int start = 0;
	int maxgraphen = 19;
	int gc = 0;
	int zx,zy,zr,onePx, onePy;
	
	GUI(){
	
		setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
        setBackground(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	onePx = (Toolkit.getDefaultToolkit()
                .getScreenSize().width/100);
    	onePy = (Toolkit.getDefaultToolkit()
                .getScreenSize().height/100);
    	
        border = new TitledBorder(" ");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleFont(new Font("Impact", Font.BOLD, 0));
        border.setTitleColor(Color.blue);
        border.setBorder(null);
        
        table = new JPanel();
        table.setBorder(border);
        table.setBackground(Color.BLACK);
        table.setLayout(new BorderLayout());
        getContentPane().add(table);
        table.setBounds(onePx * 20,0, onePx * 81, Toolkit.getDefaultToolkit()
                .getScreenSize().height ); 
        
        zx =table.getWidth()/2+ table.getX();
        zy =table.getHeight()/2;
        zr = table.getHeight()/2 - 70;
    	drawpointx = (int)table.getX() + rand;
        drawpointy = (int)table.getY() + rand;
        
        pane = new JPanel();
        pane.setBorder(null);
        pane.setBackground(Color.WHITE);
        pane.setLayout(new BorderLayout());
        pane.setBounds(table.getX(), table.getY(), table.getWidth(), table.getHeight());
        pane.setVisible(true);
        table.add(pane);
        
        tabs = new JTabbedPane();
    	tabs.setBounds(onePx/2,onePy/2 ,onePx * 19 , onePy * 60 );
    	add(tabs);
       
    	tabpane1 = new JPanel();
    	tabpane1.setLayout(null);
    	tabs.addTab("Graph erstellen", tabpane1);
    	
        knotenanzahl = new JTextArea();
        knotenanzahl.setText("Knotenanzahl");
        knotenanzahl.setEditable(false);
        knotenanzahl.setBackground(null);
        knotenanzahl.setBounds(5,onePy, tabs.getWidth()-onePx, 20);	
        tabpane1.add(knotenanzahl);
        
        nslide = new JSlider(JSlider.HORIZONTAL, 2 , 20 , 2);
        nslide.setBorder(border);
        nslide.setMajorTickSpacing(1);
        nslide.setPaintTicks(true);
        nslide.setMajorTickSpacing(2);
        nslide.setMinorTickSpacing(1);
        nslide.setPaintTicks(true);
        nslide.setPaintLabels(true);
        nslide.setBackground(null);
        nslide.setBounds(0, 28,tabs.getWidth()-5,60);
//        nslide.addAncestorListener(action);
        tabpane1.add(nslide);
        
        kantenanzahl = new JTextArea();
        kantenanzahl.setText("Kantenanzahl");
        kantenanzahl.setEditable(false);
        kantenanzahl.setBackground(null);
        kantenanzahl.setBounds(5,90, tabs.getWidth()-onePx, 20);	
        tabpane1.add(kantenanzahl);
        
        nslide2 = new JSlider(JSlider.HORIZONTAL, 2 , 20 , 2);
        nslide2.setBorder(border);
        nslide2.setMajorTickSpacing(1);
        nslide2.setPaintTicks(true);
        nslide2.setMajorTickSpacing(2);
        nslide2.setMinorTickSpacing(1);
        nslide2.setPaintTicks(true);
        nslide2.setPaintLabels(true);
        nslide2.setBackground(null);
        nslide2.setBounds(0, 108,tabs.getWidth()-5,60);
        tabpane1.add(nslide2);
        
        bezeichnung = new JTextArea();
        bezeichnung.setText("Name");
        bezeichnung.setEditable(false);
        bezeichnung.setBackground(null);
        bezeichnung.setBounds(5,170, tabs.getWidth()-onePx, 20);	
        tabpane1.add(bezeichnung);
        
        name = new JTextField();
        name.setBounds(5, 190, tabs.getWidth()- 12, 30);
        tabpane1.add(name);
        
        newGraph = new JButton("neuen Graphen erzeugen");
        newGraph.setBounds(onePx/2, 250, tabs.getWidth()- onePx, 50);
        newGraph.setBackground(null);
        newGraph.addActionListener(this);
        tabpane1.add(newGraph);
        
        tabpane2 = new JPanel();
    	tabpane2.setLayout(null);
    	tabs.addTab("Graph bearbeiten", tabpane2);
    	
    	
        
        newKante = new JButton("neue Kante erzeugen");
        newKante.setBounds(20, 300 , 330, 50);
        newKante.setBackground(null);
        newKante.addActionListener(this);
//        add(newKante);
        
        print = new JButton("ausgewählten Graph zeichnen");
        print.setBounds(20, 200 , 330, 50);
        print.setBackground(null);
        print.addActionListener(this);
//        add(print);
        
        graphselector = new JComboBox<Integer>();
        graphselector.setBounds(20, 150 , 330, 50);
        graphselector.setBackground(null);
//        add(graphselector);
        
        
        
        
        
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setBounds(10, 780, onePx * 19, 280);
     
        JSP = new JScrollPane(jTextArea);
        JSP.setBounds(10, 780, onePx * 19, 280);
        add(JSP);
        
        setVisible(true);
        
	}
	
	 public void actionPerformed (ActionEvent ae){
 
	        if(ae.getSource() == this.newGraph){
	            graphen[gc] = new graph(nslide.getValue(),name.getText());
	            graphselector.addItem(gc);
	        	if (name.getText().length() == 0){
	            jTextArea.append("Graph " + gc + " wurde erstellt\n" );
	        	}else{
	        		jTextArea.append(name.getText() + " wurde erstellt\n");
	        		name.setText("");
	        	}
	        	gc ++;		
	        }
	        else if(ae.getSource() == this.newKante){
	        	
	        }
	        else if(ae.getSource() == this.print){
	        	repaint();
	        	
	        }
	        else if(ae.getSource() == this.nslide){
	        	
	        }
	    }
	
	public void paint(Graphics g) {	
	
	if (start == 0){
		super.paint(g);
		start = 1;
	}else{
		super.paint(g);
		
		
		for (int i = 0; i < graphen[graphselector.getSelectedIndex()].knot.length; i++){
			double deg = 360 / graphen[graphselector.getSelectedIndex()].knot.length;
			deg = deg * i;
			if (i+1 % 2 == 0){
				deg = deg + 180;
			}
			g.setColor(Color.GREEN);
			double posx =(Math.cos(deg))*zr+zx;
			double posy =(Math.sin(deg))*zr+zy;
			g.fillArc((int)posx,(int)posy, 50, 50, 360, 360); 
			g.setColor(Color.BLACK);
			g.drawString(graphen[graphselector.getSelectedIndex()].knot[i].getname(),(int)posx , (int)posy);
			
       }
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Impact", Font.BOLD, 50));
		g.drawString(graphen[graphselector.getSelectedIndex()].getname(), onePx * 21, 50);
    }
	}
}
