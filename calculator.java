package calculator;

import java.awt.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class calculator extends JFrame {
//��������ʾ�ַ�ʽ
String Result=new String();

public calculator() {
	
	//����һ����壬���񲼾�
	JPanel panel = new JPanel();
	getContentPane().add(panel);
	//����Ϊ6�У�һ�з��ı���5�зŰ�ť
	panel.setLayout(new GridLayout(6,1,10,10));
	
	//�����ı����ı�������text�ַ�
	JTextField text = new JTextField(26);
	text.setText(Result);

	//�����������ϵİ�ť
		//��ռ����������
	  JButton clear_Button = new JButton("clear");
      clear_Button.addActionListener(clearButtonListener(text));
      	//ɾ�������������
      JButton back_Button = new JButton("��");
      back_Button.addActionListener(backButtonLIstener(text));
      JButton left_Button = new JButton("(");
      clear_Button.addActionListener(numbersAndOperatorsListener(text));
      	//ɾ�������������
      JButton right_Button = new JButton(")");
      back_Button.addActionListener(numbersAndOperatorsListener(text));
      //���ּ�0��9���������
      JButton button0 = new JButton("0");
      button0.addActionListener(numbersAndOperatorsListener(text));
      JButton button1 = new JButton("1");
      button1.addActionListener(numbersAndOperatorsListener(text));
      JButton button2 = new JButton("2");
      button2.addActionListener(numbersAndOperatorsListener(text));
      JButton button3 = new JButton("3");
      button3.addActionListener(numbersAndOperatorsListener(text));
      JButton button4 = new JButton("4");
      button4.addActionListener(numbersAndOperatorsListener(text));
      JButton button5 = new JButton("5");
      button5.addActionListener(numbersAndOperatorsListener(text));
      JButton button6 = new JButton("6");
      button6.addActionListener(numbersAndOperatorsListener(text));
      JButton button7 = new JButton("7");
      button7.addActionListener(numbersAndOperatorsListener(text));
      JButton button8 = new JButton("8");
      button8.addActionListener(numbersAndOperatorsListener(text));
      JButton button9 = new JButton("9");
      button9.addActionListener(numbersAndOperatorsListener(text));
      //�������ť �Ӽ��˳��Լ�С�����
      //С����
      JButton button_spot = new JButton(".");
      button_spot.addActionListener(numbersAndOperatorsListener(text));
      //��
      JButton button_add = new JButton("+");
      button_add.addActionListener(numbersAndOperatorsListener(text));
      //��
      JButton button_subtract = new JButton("-");
      button_subtract.addActionListener(numbersAndOperatorsListener(text));
      //��
      JButton button_multiply = new JButton("*");
      button_multiply.addActionListener(numbersAndOperatorsListener(text));
      //��
      JButton button_divide = new JButton("/");
      button_divide.addActionListener(numbersAndOperatorsListener(text));
      //����
      JButton button_equal = new JButton("=");
      button_equal.addActionListener(equalButtonListener(text));

	  //���ı���������
      panel.add(text);
      //����5���µ�С���
      JPanel paneo=new JPanel(new GridLayout(1,4,5,5));
      JPanel pane2=new JPanel(new GridLayout(1,4,5,5));
      JPanel pane3=new JPanel(new GridLayout(1,4,5,5));
      JPanel pane4=new JPanel(new GridLayout(1,4,5,5));
      JPanel pane5=new JPanel(new GridLayout(1,4,5,5));
      //
      paneo.add(left_Button);
      paneo.add(right_Button);
      paneo.add(back_Button);
      paneo.add(clear_Button);
      
      
      pane2.add(button7);
      pane2.add(button8);
      pane2.add(button9);
      pane2.add(button_divide);
      
      pane3.add(button4);
      pane3.add(button5);
      pane3.add(button6);
      pane3.add(button_multiply);
      
      pane4.add(button1);
      pane4.add(button2);
      pane4.add(button3);
      pane4.add(button_subtract);
      
      pane5.add(button0);
      pane5.add(button_spot);
      pane5.add(button_equal);
      pane5.add(button_add);
      
      panel.add(paneo);
      panel.add(pane2);
      panel.add(pane3);
      panel.add(pane4);
      panel.add(pane5);
      
      setTitle("Calculator");
      setSize(400,350);
      setLocationRelativeTo(null);
      setVisible(true);
      //���ô���Ĺرշ�ʽ
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

//�¼�������
public ActionListener numbersAndOperatorsListener(JTextField text ){
    return new ActionListener(){
         public void actionPerformed(ActionEvent e) {
             JButton jButton = (JButton) e.getSource();
             System.out.println("��ȡ�¼���������"+jButton.getText());
             Result += jButton.getText();
             text.setText(Result);
         }
     };
 }
//ʹ��JDK�Դ��������ʵ��ִ���ַ����е����㹫ʽ�Ĺ���
static ScriptEngine javaScriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
//��������
public ActionListener equalButtonListener(JTextField result_TextField){

    return  new ActionListener() {
        String str =null;
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("result_TextField -->"+ result_TextField.getText());
            str = result_TextField.getText();
            Result = equal(str);
            result_TextField.setText(Result);
        }
        public String equal(String str){
            String result ="";
            try {
                System.out.println(javaScriptEngine.eval(str));
                result = javaScriptEngine.eval(str).toString();
            } catch (Exception t) {
            }
            return result;
        }
    };
}
//����ı��������
public ActionListener clearButtonListener(JTextField text){
    return  new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Result = "";
            text.setText(Result);
        }
    };
}
//ɾ���ı��������
public ActionListener backButtonLIstener(JTextField text) {
	  return  new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Result=Result.substring(1,Result.length()-1);
			text.setText(Result);
		}
	  };
}
public static void main(String[] args) {
    new calculator();
}

}
