package regression;

public class LinearRegression extends Regression {

	// 内积
	 	public double PreVal(Sample sample) {
	 		double val = 0;
	 		for (int i = 0; i < theta.length; i++) {
	 			val += theta[i] * sample.features[i];
	 		}
	 		return val;
	 	}

	// 误差
	public double errorFun() {
		double sum = 0;
		for (int i = 0; i < samNum; i++) {
			double d = PreVal(sam[i]) - sam[i].value;
			sum += Math.pow(d, 2);
		}
		return sum / (2 * samNum);
	}

	
	
	// 更新参数
	public void upDate() {
		double former = 0;
		double latter = errorFun();
		do {
			former = latter;
			for (int i = 0; i < theta.length; i++) {
				double d = 0;
				for (int j = 0; j < samNum; j++) {
					d += (PreVal(sam[j]) - sam[j].value) * sam[j].features[i];
				}
				theta[i] -= (rate * d) / samNum;
			}
			latter = errorFun();
			if (former - latter < 0) {
				break;
			}
		} while (former - latter > th);
	}

}
