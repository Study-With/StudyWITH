package cha9;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ex3 extends JFrame {
      private JButton b;
      private JLabel l1,l2,label3;
      private JTextField t1,t2;
      
      public ex3() {
    	 ButtonListener a=new ButtonListener();
    	  setSize(600,500);
    	  JPanel p=new JPanel();
    	  b=new JButton("�˻�");
    	  b.addActionListener(a);
    	  l1=new JLabel("�����ϰ� ���� ������ �˻��Ͻÿ�.");
    	  label3=new JLabel("�Ǵ� ");
          l2=new JLabel("���ϴ� �������� �˻��ϼ���.") ; 
          t1=new JTextField(15);
         
          t2=new JTextField(10);
          p.setLayout(new FlowLayout());
          p.add(l1);
          p.add(t1);
          p.add(label3);
          p.add(l2);
          p.add(t2);
          p.add(b);
          add(p);
          setVisible(true);

      }
      class ButtonListener implements ActionListener { 
    	  public void actionPerformed(ActionEvent e) {
    		  if(e.getSource()==b) { //getSource������ ������ ()�ϱ�.
    			  
    			//�˻��� �����̸��̳� �������� ���ε�� ������ ���ڿ� ���ϱ�.
                  // ���� ����� �ش� ���ڿ��� �ִ� ���� �߰� �ϴ� �κ�.
                  // �� ���ߴ� �����̳� ������ �ش��ϴ� ���ǰ� ��Ÿ���� �ϴ� �κ�

    		  }
    		  
    		  
    		  
    	  }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ex3();
	}

}
