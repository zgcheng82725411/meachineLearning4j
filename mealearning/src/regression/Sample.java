package regression;

public class Sample {
	double [] features;
	int feaNum;
	double value;
	int lable;
	public Sample(int fefeaNum)
	{
		this.feaNum = fefeaNum;
		features = new double[this.feaNum];
	}
}
