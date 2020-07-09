package calculator;

import java.awt.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class calculator extends JFrame {
//计算器显示字符式
String Result=new String();

public calculator() {
	
	//创建一个面板，网格布局
	JPanel panel = new JPanel();
	getContentPane().add(panel);
	//面板分为6行，一行放文本框，5行放按钮
	panel.setLayout(new GridLayout(6,1,10,10));
	
	//创建文本框，文本框输入text字符
	JTextField text = new JTextField(26);
	text.setText(Result);

	//创建计算器上的按钮
		//清空键及其监听器
	  JButton clear_Button = new JButton("clear");
      clear_Button.addActionListener(clearButtonListener(text));
      	//删除键及其监听器
      JButton back_Button = new JButton("←");
      back_Button.addActionListener(backButtonLIstener(text));
      JButton left_Button = new JButton("(");
      clear_Button.addActionListener(numbersAndOperatorsListener(text));
      	//删除键及其监听器
      JButton right_Button = new JButton(")");
      back_Button.addActionListener(numbersAndOperatorsListener(text));
      //数字键0到9及其监听器
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
      //计算命令按钮 加减乘除以及小数点等
      //小数点
      JButton button_spot = new JButton(".");
      button_spot.addActionListener(numbersAndOperatorsListener(text));
      //加
      JButton button_add = new JButton("+");
      button_add.addActionListener(numbersAndOperatorsListener(text));
      //减
      JButton button_subtract = new JButton("-");
      button_subtract.addActionListener(numbersAndOperatorsListener(text));
      //乘
      JButton button_multiply = new JButton("*");
      button_multiply.addActionListener(numbersAndOperatorsListener(text));
      //除
      JButton button_divide = new JButton("/");
      button_divide.addActionListener(numbersAndOperatorsListener(text));
      //等于
      JButton button_equal = new JButton("=");
      button_equal.addActionListener(equalButtonListener(text));

	  //将文本框放入面板
      panel.add(text);
      //创建5个新的小面板
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
      //设置窗体的关闭方式
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

//事件监听器
public ActionListener numbersAndOperatorsListener(JTextField text ){
    return new ActionListener(){
         public void actionPerformed(ActionEvent e) {
             JButton jButton = (JButton) e.getSource();
             System.out.println("获取事件监听器："+jButton.getText());
             Result += jButton.getText();
             text.setText(Result);
         }
     };
 }
//使用JDK自带的类可以实现执行字符串中的运算公式的功能
static ScriptEngine javaScriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
//等于运算
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
//清除文本框的内容
public ActionListener clearButtonListener(JTextField text){
    return  new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Result = "";
            text.setText(Result);
        }
    };
}
//删除文本框的内容
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
