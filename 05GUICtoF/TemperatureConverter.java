import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureConverter extends JFrame{

    private Container pane,texty,buttons;
    private JButton CF;
    private JTextField text;
    private JLabel l;

    public TemperatureConverter(){
	this.setTitle("Celsius to Fahrenheit");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	CF = new JButton("Convert to Fahrenheit!");
	l = new JLabel("Enter temperature:",null,JLabel.LEFT);
	text = new JTextField(12);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	texty = new Container();
	texty.setLayout(new FlowLayout());

	buttons.add(CF);
	texty.add(l);
	texty.add(text);

	pane.add(texty);
	pane.add(buttons);
	
    }
    public static void main(String[] args){
	TemperatureConverter T = new TemperatureConverter();
	T.setVisible(true);
    }
}
