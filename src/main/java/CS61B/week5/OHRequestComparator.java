package CS61B.week5;

import java.util.Comparator;

public class OHRequestComparator implements Comparator<OHRequest> {
    @Override
    public int compare(OHRequest o1, OHRequest o2) {
        boolean isO1DescSetup = o1.description.equals("setup");
        boolean isO2DescSetup = o2.description.equals("setup");
        if (o1.isSetup && !o2.isSetup) {
            return -1;
        } else if (!o1.isSetup && o2.isSetup) {
            return 1;
        } else if (isO1DescSetup && !isO2DescSetup) {
            return -1;
        } else if (!isO1DescSetup && isO2DescSetup) {
            return 1;
        }
        return 0;
    }
    /**
     @Override : 比较标准的优先级
     public int compare(OHRequest o1, OHRequest o2) {
     // 如果isSetup相同就比较description是否与“setup”相同
     if (o1.isSetup == o2.isSetup) {
     boolean isO1DescSetup = o1.description.equals("setup");
     boolean isO2DescSetup = o2.description.equals("setup");
     return Boolean.compare(isO1DescSetup, isO2DescSetup);
     }
     // 不同就优先不叫isSetup
     return Boolean.compare(o1.isSetup, o2.isSetup);
     }
     */
}

