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
	JButton newGraph, newKante, newKnoten, print, deleteKante, deleteKnoten;
	JComboBox<Integer> graphselector, graphselector2, knotenselector, knotenselector2;
	public static int drawpointx, drawpointy;
	public static int rand = 20;
	graph[] graphen = new graph[19];
	JTabbedPane tabs;
	JComponent panel;
	public JTextArea knotenanzahl, kantenanzahl, bezeichnung;
	
	JScrollPane JSP;
	public JTextArea jTextArea, kantenwert;
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
//        nslide.addActionListener(this.nslide);
        tabpane1.add(nslide);
        
        kantenanzahl = new JTextArea();
        kantenanzahl.setText("Kantenanzahl");
        kantenanzahl.setEditable(false);
        kantenanzahl.setBackground(null);
        kantenanzahl.setBounds(5,90, tabs.getWidth()-onePx, 20);	
        tabpane1.add(kantenanzahl);
        
        nslide2 = new JSlider(JSlider.HORIZONTAL, 1 , 20 , 1);
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
    	
    	 graphselector2 = new JComboBox<Integer>();
         graphselector2.setBounds( onePx/2, onePy , tabs.getWidth()- onePx, 50);
         graphselector2.setBackground(null);
         graphselector2.addActionListener(this);
         tabpane2.add(graphselector2);
    	
    	newKnoten = new JButton("neuen Knoten erzeugen");
    	newKnoten.setBounds(onePx/2, 60 , tabs.getWidth()- onePx, 50);
        newKnoten.setBackground(null);
        newKnoten.addActionListener(this);
        tabpane2.add(newKnoten);
        
        knotenselector = new JComboBox<Integer>();
        knotenselector.setBounds(onePx/2, 130, tabs.getWidth()- onePx, 50);
        knotenselector.setBackground(null);
        tabpane2.add(knotenselector);
        
        knotenselector2 = new JComboBox<Integer>();
        knotenselector2.setBounds(onePx/2, 190, tabs.getWidth()- onePx, 50);
        knotenselector2.setBackground(null);
        tabpane2.add(knotenselector2);
        
        kantenwert = new JTextArea();
        kantenwert.setBounds(onePx/2,250, tabs.getWidth()-onePx, 20);	
        tabpane2.add(kantenwert);
        
        newKante = new JButton("neue Kante erzeugen");
        newKante.setBounds(onePx/2, 280 , tabs.getWidth()-onePx, 50);
        newKante.setBackground(null);
        newKante.addActionListener(this);
        tabpane2.add(newKante);
        
        deleteKante = new JButton("Kante löschen");
        deleteKante.setBounds(onePx/2, 330 , tabs.getWidth()-onePx, 50);
        deleteKante.setBackground(null);
        deleteKante.addActionListener(this);
        tabpane2.add(deleteKante);
        
        tabpane3 = new JPanel();
    	tabpane3.setLayout(null);
    	tabs.addTab("Graph zeichnen", tabpane3);
        
        print = new JButton("ausgewählten Graph zeichnen");
        print.setBounds(20, 200 , 330, 50);
        print.setBackground(null);
        print.addActionListener(this);
        tabpane3.add(print);
        
        graphselector = new JComboBox<Integer>();
        graphselector.setBounds(20, 150 , 330, 50);
        graphselector.setBackground(null);
        tabpane3.add(graphselector);
        
        
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);
        jTextArea.setWrapStyleWord(true);
        jTextArea.setBounds(10, 780, onePx * 19, 280);
        add(jTextArea);
        
        JSP = new JScrollPane(jTextArea);
        JSP.setBounds(10, 780, onePx * 19, 280);
        add(JSP);
        
        setVisible(true);
       
	}
	
	
	
	 public void actionPerformed (ActionEvent ae){
 
	        if(ae.getSource() == this.newGraph){
	           int knoten = nslide.getValue();
	        	if (nslide2.getValue() > ((knoten*knoten)-knoten)/2) {
	        		jTextArea.append("Es ist nicht mölich einen gerichteten Graphen mit " 
	        						+ knoten + " Knoten und " + nslide2.getValue() + " Kanten"
	        						+ " zu erzeugen");
	        	}else{
	        	graphen[gc] = new graph(nslide.getValue(),nslide2.getValue(),name.getText());
	            graphselector.addItem(gc);
	            graphselector2.addItem(gc);
	        	if (name.getText().length() == 0){
	            jTextArea.append("Graph " + gc + " wurde erstellt\n" );
	        	}else{
	        		jTextArea.append(name.getText() + " wurde erstellt\n");
	        		name.setText("");
	        	}
	        	gc ++;	
	        	}
	        }else if(ae.getSource() == this.newKnoten){
	        	graphen[graphselector.getSelectedIndex()].neuknoten();
	        	jTextArea.append("neuer Knoten zu Graph " + graphselector.getSelectedIndex() + " hinzugefügt.\n");
	        }else if(ae.getSource() == this.newKante){
	        	graphen[graphselector.getSelectedIndex()].kanteneu(knotenselector.getSelectedIndex(), knotenselector2.getSelectedIndex(), Integer.parseInt(kantenwert.getText()));
	        }else if(ae.getSource() == this.print){
	        	repaint();
	        }else if(ae.getSource() == this.deleteKante){
	        	graphen[graphselector.getSelectedIndex()].kanteloeschen(knotenselector.getSelectedIndex(), knotenselector2.getSelectedIndex());
	        }else if(ae.getSource() == this.deleteKnoten){
	        	
	        }else if(ae.getSource() == this.graphselector2){
	        	for (int i = 0; i < graphen[graphselector2.getSelectedIndex()].knot.length; i++){
	        		knotenselector.addItem(graphen[graphselector2.getSelectedIndex()].knot[i].getname());
	        		knotenselector2.addItem(graphen[graphselector2.getSelectedIndex()].knot[i].getname());
	        	}
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
			deg = ((deg * i)/180)*Math.PI;
			
			
			
			
		
			g.setColor(Color.GREEN);
			double posx =Math.cos(deg)*zr+zx;
			double posy =Math.sin(deg)*zr+zy;
			graphen[graphselector.getSelectedIndex()].knot[i].setX((int) posx);
			graphen[graphselector.getSelectedIndex()].knot[i].setY((int) posy);
			g.fillArc((int)posx,(int)posy, 50, 50, 360, 360); 
			g.setColor(Color.BLACK);
			g.drawString("Knoten" + graphen[graphselector.getSelectedIndex()].knot[i].getname()
					,(int)posx , (int)posy);
			if (i > 0){
				int xcorrect;
				int ycorrect;
				
				g.setColor(Color.BLUE);
				
				for (int o = 0; o < graphen[graphselector.getSelectedIndex()].knot.length; o++ ){
					if (graphen[graphselector.getSelectedIndex()].knot[o].getX() <=
						graphen[graphselector.getSelectedIndex()].knot[i].getX()){
					xcorrect = 25;
				}else{
					xcorrect = -25;
				}
				
				if (graphen[graphselector.getSelectedIndex()].knot[o].getY() <= 
						graphen[graphselector.getSelectedIndex()].knot[i].getY()){
					ycorrect = 25;
				}else{
					ycorrect = -25;
				}
					
					if (graphen[graphselector.getSelectedIndex()].adj[o][i] != 0){
						g.drawLine(graphen[graphselector.getSelectedIndex()].knot[i].getX()+25
								,graphen[graphselector.getSelectedIndex()].knot[i].getY()+25
								, graphen[graphselector.getSelectedIndex()].knot[o].getX()+25 + xcorrect
								, graphen[graphselector.getSelectedIndex()].knot[o].getY()+25 + ycorrect);
					
					g.setColor(Color.RED);
				g.drawString(""+ graphen[graphselector.getSelectedIndex()].adj[o][i],
						(graphen[graphselector.getSelectedIndex()].knot[o].getX()+25 
						- graphen[graphselector.getSelectedIndex()].knot[i].getX()+25)/2 
						+ graphen[graphselector.getSelectedIndex()].knot[i].getX()+25
						+ xcorrect,(graphen[graphselector.getSelectedIndex()].knot[o].getY()+25 
								- graphen[graphselector.getSelectedIndex()].knot[i].getY()+25)/2 
								+ graphen[graphselector.getSelectedIndex()].knot[i].getY()+25 + ycorrect );
			
					}
				}
				
				}
       }
		g.setColor(Color.DARK_GRAY);
		g.setFont(new Font("Impact", Font.BOLD, 50));
		g.drawString(graphen[graphselector.getSelectedIndex()].getname(), onePx * 21, 50);
    }
	}
}
