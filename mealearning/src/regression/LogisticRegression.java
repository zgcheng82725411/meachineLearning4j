package regression;

public class LogisticRegression extends Regression {

	public double PreVal(Sample s) {
		double val = 0;
		for (int i = 0; i < theta.length; i++) {
			val += theta[i] * s.features[i];
		}
		return 1 / (1 + Math.pow(Math.E, -val));
	}

	public double errorFun() {
		double sum = 0;
		for (int i = 0; i < samNum; i++) {
			double p = PreVal(sam[i]);
			double d = Math.log(p) * sam[i].lable + (1 - sam[i].lable)
					* Math.log(1 - p);
			sum += d;
		}
		return -1 * (sum / samNum);
	}

	public void upDate() {
		double former = 0; // the cost before update
		double latter = errorFun(); // the cost after update
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