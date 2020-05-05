package regression;

public abstract class Regression {
	//ѧϰ��
	double rate = 0.001;
	
	//Ȩ��
	double[] theta; 
	
	//ƫ��
	double th;
	
	//����
	Sample[] sam; 
	
	//��������
    int samNum; 
    
    public void readData(Sample[] s, int num) {
        samNum = num;
        sam = new Sample[samNum];
        for(int i = 0; i < samNum; i++) {
            sam[i] = s[i];
        }
    } 
    
 
    public void Initialize(Sample[] s, int num) {
		samNum = num;
		sam = new Sample[samNum];
		for (int i = 0; i < samNum; i++) {
			sam[i] = s[i];
		}
	}

	public void setPara(double[] para, double learning_rate, double threshold) {		
		theta = para;
		rate = learning_rate;
		th = threshold;
	}

	public void OutputTheta() {
        System.out.println("The parameters are:");
        for(int i = 0; i < theta.length; i++) {
            System.out.print(theta[i] + " ");
        }
        System.out.println(errorFun());
    }
        
    public abstract double errorFun();
        
    public abstract void upDate();   
}
