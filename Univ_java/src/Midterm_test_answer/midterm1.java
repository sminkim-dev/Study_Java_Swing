package Midterm_test_answer;

import java.util.*;

public class midterm1 implements Comparable{

	private String name;
	private int id;
	private double score;
	
	public midterm1(String name, int id, double score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}
	public String toString() {
		return "name : " + name + "		id : " + id + "		score : " + score;
	}
	public static void main(String[] args) {
		String [] names = {"가나다 ", "라마바 ", "사마자 ", "차카", "파하 "};
		ArrayList<midterm1> std = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			int id = 20250000 + (int)(Math.random()*10000000.0);
			double score = Math.random()*100.0 + 1.0;
			
			std.add(new midterm1(names[i], id, score)); 
		}
		Collections.sort(std);
		for(int i = 0; i < std.size(); i++) {
			System.out.println(std.get(i));
		}
	}
	@Override
	public int compareTo(Object o) {
		return (int)(((midterm1) o).score - this.score);
	}
}
