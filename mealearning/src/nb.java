
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.util.ArrayList;  
  
public class nb {  
  
    /**data_length  
     * �㷨��˼��  
     */  
    public static  ArrayList<JavaBean> list = new ArrayList<JavaBean>();;  
    static int data_length=0;  
    public static void main(String[] args) {  
        // 1.��ȡ���ݣ�����list������  
        File file = new File("E://test.txt");  
        txt2String(file);  
        //���ݲ�������  
        testData(25,"Medium","Yes","Fair");  
    }  
    // ��ȡ��������  
    public static void txt2String(File file) {  
          
        try {  
            BufferedReader br = new BufferedReader(new FileReader(file));// ����һ��BufferedReader������ȡ�ļ�  
            String s = null;  
            while ((s = br.readLine()) != null) {// ʹ��readLine������һ�ζ�һ��  
                data_length++;   
                splitt(s);  
            }  
            br.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    }  
    // ����ArrayList��  
      public static void splitt(String str){  
             
            String strr = str.trim();  
            String[] abc = strr.split("[\\p{Space}]+");  
            int age=Integer.parseInt(abc[0]);  
            JavaBean bean=new JavaBean(age, abc[1], abc[2], abc[3], abc[4]);  
            list.add(bean);       
             
             
        }  
      // ѵ������������  
      public static void testData(int age,String a,String b,String c){  
          //ѵ������    
          int number_yes=0;  
          int bumber_no=0;  
            
         // age��� ����  
          int num_age_yes=0;  
          int num_age_no=0;  
          // income   
          int num_income_yes=0;  
          int num_income_no=0;  
          // student   
          int num_student_yes=0;  
          int num_stdent_no=0;  
          //credit  
          int num_credit_yes=0;  
          int num_credit_no=0;  
            
          //����List �������  
          for(int i=0;i<list.size();i++){  
            JavaBean bb=list.get(i);  
            if(bb.getBuys_computer().equals("Yes")){ //Yes  
                number_yes++;  
                if(bb.getIncome().equals(a)){//income  
                    num_income_yes++;  
                }  
                if(bb.getStudent().equals(b)){//student  
                    num_student_yes++;  
                }  
                if(bb.getCredit_rating().equals(c)){//credit  
                    num_credit_yes++;  
                }  
                if(bb.getAge()==age){//age  
                    num_age_yes++;  
                }  
                  
                  
            }else {//No  
                bumber_no++;  
                if(bb.getIncome().equals(a)){//income  
                    num_income_no++;  
                }  
                if(bb.getStudent().equals(b)){//student  
                    num_stdent_no++;  
                }  
                if(bb.getCredit_rating().equals(c)){//credit  
                    num_credit_no++;  
                }  
                if(bb.getAge()==age){//age  
                    num_age_no++;  
                }  
                  
            }    
          }  
            
            System.out.println("�������ʷ����:"+number_yes);  
            System.out.println("�������ʷ����:"+bumber_no);  
              
            System.out.println("����+age:"+num_age_yes);  
            System.out.println("����+age:"+num_age_no);  
              
            System.out.println("����+income:"+num_income_yes);  
            System.out.println("����+income:"+num_income_no);  
              
            System.out.println("����+stundent:"+num_student_yes);  
            System.out.println("����+student:"+num_stdent_no);  
              
            System.out.println("����+credit:"+num_credit_yes);  
            System.out.println("����+credit:"+num_credit_no);  
              
            //// �����ж�  
            double buy_yes=number_yes*1.0/data_length; // ��ĸ���  
            double buy_no=bumber_no*1.0/data_length; //  ����ĸ���  
            System.out.println("ѵ����������ĸ���:"+buy_yes);  
            System.out.println("ѵ�������в���ĸ���:"+buy_no);  
            /// δ֪�û����ж�  
            double nb_buy_yes=(1.0*num_age_yes/number_yes)*(1.0*num_income_yes/number_yes)*(1.0*num_student_yes/number_yes)*(1.0*num_credit_yes/number_yes)*buy_yes;         
            double nb_buy_no=(1.0*num_age_no/bumber_no)*(1.0*num_income_no/bumber_no)*(1.0*num_stdent_no/bumber_no)*(1.0*num_credit_no/bumber_no)*buy_no;         
            System.out.println("���û���ĸ���:"+nb_buy_yes);  
            System.out.println("���û�����ĸ���:"+nb_buy_no);  
            if(nb_buy_yes>nb_buy_no){  
                System.out.println("���û���ĸ��ʴ�");  
            }else {  
                System.out.println("���û�����ĸ��ʴ�");  
            }      
      }     
}  
