package calc;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.jtattoo.plaf.smart.SmartLookAndFeel;

public class calculator {

	private JFrame frame;
	private JTextField textField;

	double num1 = 0;
	double num2 = 0;
	double result = 0;
	int num3 = 0;
	int num4 = 0;
	String operations;
	String answer;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "Calculator");
					SmartLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel(UIManager.getLookAndFeel());
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calculator() {
		initialize();
	}

	static long factorial(long ops) {
		long factor = 1;
		long i = 1;
		while (i <= ops) {
			factor *= i;
			i++;
		}
		return factor;
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(450, 150, 220, 323);
		frame.setResizable(false);
		frame.setTitle("Standard Calculator");
		ImageIcon img = new ImageIcon("resources/calculator.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		textField = new JTextField(20);
		textField.setBounds(6, 24, 202, 44);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.setEditable(false);
		textField.setColumns(10);
		frame.getContentPane().add(textField);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 230, 23);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("View");
		menuBar.add(mnNewMenu);

		JMenuItem standard = new JMenuItem("Standard Calculator");
		JMenuItem scientific = new JMenuItem("Scientific Calculator");

		standard.setEnabled(false);

		standard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setBounds(450, 150, 220, 323);
				frame.setResizable(false);
				frame.setTitle("Standard Calculator");
				frame.setLocationRelativeTo(null);

				menuBar.setBounds(0, 0, 220, 23);

				standard.setEnabled(false);
				scientific.setEnabled(true);

				textField.setBounds(6, 24, 202, 45);
				textField.setHorizontalAlignment(SwingConstants.RIGHT);
				textField.setColumns(10);

				textField.setText("");
			}
		});
		mnNewMenu.add(standard);

		scientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setBounds(450, 150, 440, 327);
				frame.setResizable(false);
				frame.setTitle("Scientific Calculator");
				frame.setLocationRelativeTo(null);

				menuBar.setBounds(0, 0, 440, 23);

				scientific.setEnabled(false);
				standard.setEnabled(true);

				textField.setBounds(6, 24, 422, 45);
				textField.setHorizontalAlignment(SwingConstants.RIGHT);
				textField.setColumns(10);

				textField.setText("");
			}
		});

		mnNewMenu.add(scientific);

		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Scientific Calculator using Java Swing by Avishek Das");
			}
		});

		mnNewMenu.add(about);

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(exit);

		JButton bs = new JButton("\u232b");
		bs.setBounds(6, 90, 50, 35);
		bs.setFont(new Font("SansSerif", Font.PLAIN, 10));
		frame.getContentPane().add(bs);
		bs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String backspace = null;
				if (textField.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspace = strB.toString();
					textField.setText(backspace);

				}
			}
		});

		JButton clear = new JButton("C");
		clear.setBounds(56, 90, 50, 35);
		frame.getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText("");

			}
		});

		JButton perc = new JButton("%");
		perc.setBounds(107, 90, 50, 35);
		frame.getContentPane().add(perc);
		perc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "%";
				}
			}
		});

		JButton sum = new JButton("+");
		sum.setBounds(158, 90, 50, 35);
		frame.getContentPane().add(sum);
		sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "+";
				}
			}

		});

		JButton seven = new JButton("7");
		seven.setBounds(6, 130, 50, 35);
		frame.getContentPane().add(seven);
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + seven.getText();
				textField.setText(iNum);

			}
		});

		JButton eight = new JButton("8");
		eight.setBounds(56, 130, 50, 35);
		frame.getContentPane().add(eight);
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + eight.getText();
				textField.setText(iNum);

			}
		});

		JButton nine = new JButton("9");
		nine.setBounds(107, 130, 50, 35);
		frame.getContentPane().add(nine);
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + nine.getText();
				textField.setText(iNum);

			}
		});

		JButton sub = new JButton("-");
		sub.setBounds(158, 130, 50, 35);
		frame.getContentPane().add(sub);
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "-";
				}
			}
		});

		JButton four = new JButton("4");
		four.setBounds(6, 170, 50, 35);
		frame.getContentPane().add(four);
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + four.getText();
				textField.setText(iNum);

			}
		});

		JButton five = new JButton("5");
		five.setBounds(56, 170, 50, 35);
		frame.getContentPane().add(five);
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + five.getText();
				textField.setText(iNum);

			}
		});

		JButton six = new JButton("6");
		six.setBounds(107, 170, 50, 35);
		frame.getContentPane().add(six);
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + six.getText();
				textField.setText(iNum);

			}
		});

		JButton mul = new JButton("*");
		mul.setBounds(158, 170, 50, 35);
		frame.getContentPane().add(mul);
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "*";
				}
			}
		});

		JButton one = new JButton("1");
		one.setBounds(6, 210, 50, 35);
		frame.getContentPane().add(one);
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + one.getText();
				textField.setText(iNum);

			}
		});

		JButton two = new JButton("2");
		two.setBounds(56, 210, 50, 35);
		frame.getContentPane().add(two);
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + two.getText();
				textField.setText(iNum);

			}
		});

		JButton three = new JButton("3");
		three.setBounds(107, 210, 50, 35);
		frame.getContentPane().add(three);
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + three.getText();
				textField.setText(iNum);

			}
		});

		JButton div = new JButton("/");
		div.setBounds(158, 210, 50, 35);
		frame.getContentPane().add(div);
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "/";
				}
			}
		});

		JButton zero = new JButton("0");
		zero.setBounds(6, 250, 50, 35);
		frame.getContentPane().add(zero);
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNum = textField.getText() + zero.getText();
				textField.setText(iNum);

			}
		});

		JButton dot = new JButton(".");
		dot.setBounds(56, 250, 50, 35);
		frame.getContentPane().add(dot);
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField.getText().contains(".")) {
					String iNum = textField.getText() + dot.getText();
					textField.setText(iNum);

				}
			}
		});

		JButton pm = new JButton("\u00B1");
		pm.setBounds(107, 250, 50, 35);
		frame.getContentPane().add(pm);
		pm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					double ops = Double.parseDouble(textField.getText());
					ops = ops * (-1);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton resc = new JButton("1/x");
		resc.setBounds(224, 90, 50, 35);
		frame.getContentPane().add(resc);
		resc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double ops = Double.parseDouble(textField.getText());
				if (ops == 0) {
					JOptionPane.showMessageDialog(null, "Cannot be divided by 0");
					textField.setText("");
				} else if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					ops = 1 / ops;
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton sin = new JButton("sin");
		sin.setBounds(275, 90, 50, 35);
		frame.getContentPane().add(sin);
		sin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Math.toRadians(Double.parseDouble(textField.getText()));
					ops = Math.sin(Math.toDegrees(ops));
					textField.setText(String.valueOf(ops));
				}

			}
		});

		JButton cos = new JButton("cos");
		cos.setBounds(327, 90, 50, 35);
		frame.getContentPane().add(cos);
		cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Math.toRadians(Double.parseDouble(textField.getText()));
					ops = Math.cos(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton tan = new JButton("tan");
		tan.setBounds(379, 90, 50, 35);
		frame.getContentPane().add(tan);
		tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Math.toRadians(Double.parseDouble(textField.getText()));
					ops = Math.tan(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton square = new JButton("x^2");
		square.setBounds(224, 130, 50, 35);
		frame.getContentPane().add(square);
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.pow(ops, 2);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton sqrt = new JButton("\u221A");
		sqrt.setBounds(275, 130, 50, 35);
		frame.getContentPane().add(sqrt);
		sqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.sqrt(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton fact = new JButton("n!");
		fact.setBounds(327, 130, 50, 35);
		frame.getContentPane().add(fact);
		fact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				long ops = Integer.parseInt(textField.getText());
				if (textField.getText().equals("1") || textField.getText().equals("0")) {
					textField.setText("1");
				}
				else if(ops>=21)
				{
					JOptionPane.showMessageDialog(null, "Please enter a number from 1 to 20","Error",JOptionPane.ERROR_MESSAGE);
					textField.setText("");
				}

				else {
					long fac = factorial(ops);
					textField.setText("");
					textField.setText(String.valueOf(fac));
				}
			}
		});

		JButton mod = new JButton("Mod");
		mod.setBounds(379, 130, 50, 35);
		frame.getContentPane().add(mod);
		mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "mod";
				}
			}
		});

		JButton cube = new JButton("x^3");
		cube.setBounds(224, 170, 50, 35);
		frame.getContentPane().add(cube);
		cube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.pow(ops, 3);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton cbrt = new JButton("\u221B");
		cbrt.setBounds(275, 170, 50, 35);
		frame.getContentPane().add(cbrt);
		cbrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				if (textField.getText().length() >= 1) {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.cbrt(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton log = new JButton("log");
		log.setBounds(327, 170, 50, 35);
		frame.getContentPane().add(log);
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.log10(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton bin = new JButton("Bin");
		bin.setBounds(379, 170, 50, 35);
		frame.getContentPane().add(bin);
		bin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					int a = Integer.parseInt(textField.getText());
					textField.setText(Integer.toBinaryString(a));
					// textField.setText(Integer.toString(a,2)); //another method
				}
			}
		});

		JButton power = new JButton("x^y");
		power.setBounds(224, 210, 50, 35);
		frame.getContentPane().add(power);
		power.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "power";
				}
			}
		});

		JButton root = new JButton("y\u221Ax");
		root.setBounds(275, 210, 50, 35);
		frame.getContentPane().add(root);
		root.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				}
				if (textField.getText().length() >= 1) {
					num1 = Double.parseDouble(textField.getText());
					textField.setText("");
					operations = "root";
				}
			}
		});

		JButton ln = new JButton("ln");
		ln.setBounds(327, 210, 50, 35);
		frame.getContentPane().add(ln);
		ln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				} else {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.log(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton oct = new JButton("Oct");
		oct.setBounds(379, 210, 50, 35);
		frame.getContentPane().add(oct);
		oct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please make a operation first");
				} else {
					int a = Integer.parseInt(textField.getText());
					textField.setText("");
					textField.setText(Integer.toOctalString(a));
					// textField.setText(Integer.toString(a,8)); //another method
				}
			}

		});

		JButton tenpow = new JButton("10^x");
		tenpow.setBounds(224, 250, 50, 35);
		frame.getContentPane().add(tenpow);
		tenpow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.pow(10, ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton exp = new JButton("e^x");
		exp.setBounds(275, 250, 50, 35);
		frame.getContentPane().add(exp);
		exp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					double ops = Double.parseDouble(textField.getText());
					ops = Math.exp(ops);
					textField.setText(String.valueOf(ops));
				}
			}
		});

		JButton pi = new JButton("\u03C0");
		pi.setBounds(327, 250, 50, 35);
		frame.getContentPane().add(pi);
		pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double ops;
				ops = Math.PI;
				textField.setText(String.valueOf(ops));
			}
		});

		JButton hex = new JButton("Hex");
		hex.setBounds(379, 250, 50, 35);
		frame.getContentPane().add(hex);
		hex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a number");
				} else {
					int a = Integer.parseInt(textField.getText());
					textField.setText(Integer.toHexString(a));
					// textField.setText(Integer.toString(a,16)); //another method
				}
			}
		});

		JButton equal = new JButton("=");
		equal.setBounds(158, 250, 50, 35);
		frame.getContentPane().add(equal);

		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				num2 = Double.parseDouble(textField.getText());

				if (operations == "+") {

					result = num1 + num2;
					answer = String.format("%.2f", result);
					textField.setText(answer);

				}
				if (operations == "-") {
					result = num1 - num2;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				if (operations == "*") {
					result = num1 * num2;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				if (operations == "/") {
					if (num2 == 0) {
						JOptionPane.showMessageDialog(null, "Cannot be divided by 0");
						textField.setText("");
					} else {
						result = num1 / num2;
						answer = String.format("%.2f", result);
						textField.setText(answer);
					}
				}
				if (operations == "mod") {
					if (num2 == 0) {
						JOptionPane.showMessageDialog(null, "Cannot be divided by 0");
						textField.setText("");
					} else {
						result = num1 % num2;
						answer = String.format("%.2f", result);
						textField.setText(answer);
					}
				}
				if (operations == "power") {
					result = Math.pow(num1, num2);
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				if (operations == "root") {
					if (num1 == 0) {
						JOptionPane.showMessageDialog(null, "Cannot be divided by 0");
						textField.setText("");
					} else {
						result = Math.pow(num1, 1 / num2);
						answer = String.format("%.2f", result);
						textField.setText(answer);
					}

				}
				if (operations == "%") {
					result = num1 * (num2 / 100);
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
			}
		});
	}
}
