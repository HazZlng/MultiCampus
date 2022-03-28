package com.biz;

public class ScoreCalc {
	public int getTot(int k, int e, int m) {
		return k + e + m;
	}
	public double getAvg( int d) {
		return (double) d / 3;
	}
	public String getGrad(double avg) {
		String grad;
		switch ((int) avg / 10) {
		case 10:
		case 9:
			grad = "A";			break;
		case 8:
			grad = "B";
			break;
		case 7:
			grad = "C";
			break;
		case 6:
			grad = "D";
			break;
		default:
			grad = "F";
			break;
		}
		return grad;
	}
}
