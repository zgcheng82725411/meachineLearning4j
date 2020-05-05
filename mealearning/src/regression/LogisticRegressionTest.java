package regression;

import java.io.IOException;
import java.io.RandomAccessFile;

public class LogisticRegressionTest {

    public static void main(String[] args) throws IOException {
        //read Sample.txt
        Sample[] sam = new Sample[25];
        int w = 0;
                
        long filePoint = 0;
        String s;
        RandomAccessFile file = new RandomAccessFile("resource//LogisticSample.txt", "r");
        long fileLength = file.length();
                
        while(filePoint < fileLength) {
            s = file.readLine();
            //s --> sample
            String[] sub = s.split(" ");
            sam[w] = new Sample(sub.length - 1);
            for(int i = 0; i < sub.length; i++) {
                if(i == sub.length - 1) {
                    sam[w].lable = Integer.parseInt(sub[i]);
                }
                else {
                    sam[w].features[i] = Double.parseDouble(sub[i]);
                }
            }//for
            //sam[w].outSample();
            w++;
            filePoint = file.getFilePointer();
        }//while read file
        
        LogisticRegression lr = new LogisticRegression();
        double[] para = {0,0,0};
        double rate = 0.5;
        double th = 0.001;
        lr.readData(sam, w);
        lr.setPara(para, rate, th);
        lr.upDate();
        lr.OutputTheta();
    }
    
}
