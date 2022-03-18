package mc.ys.lesson7;

import java.util.Comparator;

public class MyComparator implements Comparator<GisaDataVO> {

	@Override
	public int compare(GisaDataVO o1, GisaDataVO o2) {
		// TODO Auto-generated method stub
		int result = 0;
		result = (o2.getKor()+o2.getEng()) - (o1.getKor()+o1.getEng());
		if(result==0) {
			result = o2.getStdNo() - o1.getStdNo();
		}
		return result;
	}

}
