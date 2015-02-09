/**
This class makes a graph that goes from -5 to 5 on the x and y axes. It displays an expression that the user inputs in a text field.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graph extends JPanel implements ActionListener{
	
	private JTextField expField = new JTextField("Enter Expression", 30);
	private final int SIZE = 400;
	private Double[] expGraph = new Double[101];
	private Expr expression;
	
	public static void main(String[] args){
		
		JFrame window = new JFrame("Graph");
		Graph content = new Graph();
		window.setResizable(false);
		window.setContentPane(content);
		window.pack();
		window.setVisible(true);
		
	}
	
	public Graph(){
		
		setLayout(new BorderLayout());
		add(new GraphPanel(), BorderLayout.CENTER);
		expField.addActionListener(this);
		add(expField, BorderLayout.SOUTH);
		
	}
	
	private class GraphPanel extends JPanel{
		
		public GraphPanel(){
			setPreferredSize(new Dimension(SIZE, SIZE));
		}
	
		public void paintComponent(Graphics g){
		
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("font", Font.PLAIN, 10));
			
			g.setColor(Color.BLACK);
			for(int i = 1; i < 10; i++){//tick marks for both axes and red grid lines.
				
				g.drawString(Integer.toString(-5 + i), SIZE/10 * i + 1, SIZE/2 - 1);
				g.drawString(Integer.toString(-5 + i), SIZE/2 + 1, SIZE/10 * i - 1);
				
				g.setColor(Color.RED);
				g.drawLine(SIZE/10 * i, 0, SIZE/10 * i, SIZE);
				g.drawLine(0, SIZE/10 * i, SIZE, SIZE/10 * i);
				
				g.setColor(Color.BLACK);
				g.drawLine(SIZE/10 * i, SIZE/2 + 3, SIZE/10 * i, SIZE/2 - 3);//tick mark through x axis
				g.drawLine(SIZE/2 + 3, SIZE/10 * i, SIZE/2 - 3, SIZE/10 * i);//tick mark through y axis
				
			}
			
			g.setColor(Color.BLACK);
			g.drawLine(0, SIZE/2, SIZE, SIZE/2);//x axis
			g.drawLine(SIZE/2, 0, SIZE/2, SIZE);//y axis
			
			for(int i = 0; i < expGraph.length - 1; i++){//graph expression
			
				if(expGraph[i] != null){
					g.drawLine(SIZE/100 * i, SIZE/2 - (int)(expGraph[i] * SIZE/10), SIZE/100 * (i + 1), SIZE/2 - (int)(expGraph[i + 1] * SIZE/10));
				}
			
			}
			
			if(expression != null){
				g.setColor(Color.RED);
				g.setFont(new Font("font", Font.PLAIN, 24));
				g.drawString(expression.toString(), 5, 40);
			}
		
		}
		
	}
	
	public void actionPerformed(ActionEvent evt){
		
		try{
			expression = new Expr(expField.getText());
			expField.setText("Enter Expression");
		}
		catch(IllegalArgumentException e){
			expField.setText(e.getMessage());
		}
		finally{
			expField.selectAll();
		}
		
		for(int i = 0; i < expGraph.length; i++){
			expGraph[i] = expression.value(-5 + (0.1 * i));
			if(expGraph[i].isNaN()){
				expGraph = new Double[101];
				expField.setText("The expression is undefined at the given value of x.");
				expField.selectAll();
				break;
			}
		}
		
		repaint();
		
	}
	
}