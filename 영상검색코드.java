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
    	  b=new JButton("검색");
    	  b.addActionListener(a);
    	  l1=new JLabel("공부하고 싶은 과목을 검색하시오.");
    	  label3=new JLabel("또는 ");
          l2=new JLabel("원하는 교수명을 검색하세요.") ; 
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
    		  if(e.getSource()==b) { //getSource다음에 무조건 ()하기.
    			  
    			//검색한 과목이름이나 교수명을 업로드된 영상명과 문자열 비교하기.
                  // 비교의 결과로 해당 문자열이 있는 영상 뜨게 하는 부분.
                  // 즉 원했던 과목이나 교수에 해당하는 강의가 나타나게 하는 부분

    		  }
    		  
    		  
    		  
    	  }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new ex3();
	}

}
