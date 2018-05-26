
package quiz;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Questions extends JFrame 
{
	
	private JPanel contentPane; 
	private JButton Next;
	private JButton Back;
	private ButtonGroup opg;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	private JLabel question;
	private JLabel username;
	private JSeparator separator;
	 String[][] a;
	 String[][] q;
	static int score=0;
	int count=0;
	int c=0;
	static String usernameq;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					Questions frame = new Questions();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public Questions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=0;
        
        Game();
      q =new String[10][5];
      
      q[0][0]="What is the programming style of the object oriented conceptual model?";
      q[0][1]="Invariant relationships";
      q[0][2]="Algorithms";
      q[0][3]="Classes and objects";
      q[0][4]="Goals, often expressed in a predicate calculus";
      
      q[1][0]="Abstraction is classified into _______ types";
      q[1][1]="4";
      q[1][2]="3";
      q[1][3]="2";
      q[1][4]="1";
      
      q[2][0]="Single inheritance, Multiple inheritance, and Aggregation comes under _______";
      q[2][1]="Modularity";
      q[2][2]="Typing";
      q[2][3]="Hierarchy";
      q[2][4]="None of the mentioned";
      
      q[3][0]="Callback is an operation provided by";
      q[3][1]="Inheritance";
      q[3][2]="Encapsulation";
      q[3][3]="Modularity";
      q[3][4]="Abstraction";
      
      q[4][0]="Dependencies among files can then be asserted using the macro";
      q[4][1]="#define";
      q[4][2]="#undef";
      q[4][3]="#include";
      q[4][4]="#endif";
      
      q[5][0]=":reader, :writer or :accessor are the slot options in";
      q[5][1]="Smalltalk";
      q[5][2]="LISP";
      q[5][3]="Object Pascal";
      q[5][4]="CLOS";
      
      q[6][0]="Inheritance is an example of which type of hierarchy";
      q[6][1]="Class Structure";
      q[6][2]="Object Structure";
      q[6][3]="Both";
      q[6][4]="None of the mentioned";
      
      q[7][0]="Superclass represents ______________ abstractions";
      q[7][1]="Generalized abstractions";
      q[7][2]="Specialization abstractions";
      q[7][3]="Both";
      q[7][4]="None of the mentioned";
      
      q[8][0]="_____________ is the property that distinguishes an active object from one that is not active.";
      q[8][1]="Persistence";
      q[8][2]="Typing";
      q[8][3]="Aggregation";
      q[8][4]="Concurrency";
      
      q[9][0]="A ________ is a special member function whose task is to initialize the objects of its class";
      q[9][1]="Constructor";
      q[9][2]="Destructor";
      q[9][3]="Selector";
      q[9][4]="Iterator";
      
      a=new String[10][5];
      a[0][1]="Classes and objects";
      a[1][1]="4";
      a[2][1]="Hierarchy";
      a[3][1]="Abstraction";
      a[4][1]="#include";
      a[5][1]="CLOS";
      a[6][1]="Class Structure";
      a[7][1]="Generalized abstractions";
      a[8][1]="Concurrency";
      a[9][1]="Constructor";
     


      start(0);
	}
	 
	 public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
	private void Game()
	{	
		setTitle("Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		op4=new JRadioButton();
		question=new JLabel();
		username=new JLabel();
		separator=new JSeparator();
		Next=new JButton();
		Back=new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        final JLabel timer = new JLabel("01:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 60;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=10) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up!!","bye..",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
        			new Results().setVisible(true);
        			dispose();
                	}
                }
            }
            }
            
        });
        t.start();
       
        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        opg.add(op4);
        op4.setText("option4");
        op4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op4selected(evt);
            }

			
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("question");
        username.setText("Playing as "+Login.usernameq);
        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextClicked(evt);
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
	
	//GUI
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op1)
                    .addComponent(op3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(op2)
                    .addComponent(op4))
                .addGap(60, 60, 60))
            .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                    		.addComponent(timer)
                        .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(642, 642, 642)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username)
                    .addComponent(Next))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                		.addComponent(timer)
                    .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op1)
                    .addComponent(op2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op3)
                    .addComponent(op4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addContainerGap())
        );

	pack();
	}    

	

	protected void BackClicked(ActionEvent evt) {
	
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) {
		
		
		if(getSelectedButtonText(opg)==a[c][1]) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=10)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
			new Results().setVisible(true);
			this.dispose();
		}
	}
	protected void op4selected(ActionEvent evt) {
	
		
	}
	protected void op3selected(ActionEvent evt) {
	
		
	}
	protected void op2selected(ActionEvent evt) {
		
		
	}
	protected void op1Selected(ActionEvent evt) {
	
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
		 question.setText(q[i][0]);
	        op1.setText(q[i][1]);
	        op2.setText(q[i][2]);
	        op3.setText(q[i][3]);
	        op4.setText(q[i][4]);
	        opg.clearSelection();


		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	

		 }
