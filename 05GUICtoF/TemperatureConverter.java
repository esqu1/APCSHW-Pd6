import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureConverter extends JFrame implements ActionListener{

    private Container pane,texty,buttons;
    private JButton CF,FC;
    private JTextField text, output;
    private JLabel l;

    public TemperatureConverter(){
	this.setTitle("Celsius to Fahrenheit");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	CF = new JButton("Convert to Fahrenheit!");
	CF.addActionListener(this);
	CF.setActionCommand("CtoF");
	FC = new JButton("Convert to Celsius!");
	FC.addActionListener(this);
	FC.setActionCommand("FtoC");
	l = new JLabel("Enter temperature:",null,JLabel.LEFT);
	text = new JTextField(12);
	output = new JTextField(12);
	output.setEditable(false);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	texty = new Container();
	texty.setLayout(new FlowLayout());

	buttons.add(CF);
	buttons.add(FC);
	texty.add(l);
	texty.add(text);
	texty.add(output);

	pane.add(texty);
	pane.add(buttons);
	
    }

    public void actionPerformed(ActionEvent e){
	if(text.getText().equals("")){
	    System.out.println("Please enter a number.");
	}else if(e.getActionCommand().equals("CtoF")){
	    double k = Double.parseDouble(text.getText());
	    output.setText("" + ((double)(9 * k) / 5 + 32));
	}else if(e.getActionCommand().equals("FtoC")){
	    double k = Double.parseDouble(text.getText());
	    output.setText("" + (double)(5 * (k - 32)) / 9);
	}
    }
    
    public static void main(String[] args){
	TemperatureConverter T = new TemperatureConverter();
	T.setVisible(true);
    }
}
