package com.test.java.question.collection;

public class MySet {

	private String[] list;
	private int index;
	private int sindex;

	public MySet() {
		
		//그냥 생성과 동시에 배열 생성 해버렸음.
		this.list = new String[4];
		this.index = 0;
		this.sindex = 0;
	}

	public boolean add(String value) {

		try {
			
			if (isDuplicate(value)) {
				return false;
			}

			if (checkLength()) {
				doubleList();
			}

			this.list[this.index] = value;
			this.index++;

			return true;

		} catch (Exception e) {

			return false;
		}

	}

	private boolean isDuplicate(String value) {
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].equals(value)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean checkLength() {

		if (this.index == this.list.length) {
			return true;
		}

		return false;
	}

	private void doubleList() {

		String[] temp = new String[this.list.length * 2];

		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}

		this.list = temp;

	}
	
	public int size() {
		
		return this.index;
	}
	
	public String remove(String value) {
				
		int index = -1;
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].equals(value)) {
				index = i;
				break;
			}
		}
		
		for (int i=index; i<this.list.length-1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;
		
		return value;		
	}
	
	public void clear() {
		
		this.index = 0;
		
	}
	
	//현재 몇번째 방까지 읽었는지를 확인 > true / false 반환 역할
	public boolean hasNext() {
		
		if (this.sindex < this.index) {
			
			return true;
		}
		
		return false;
	}
	
	//무조건 첫번째 방~ 마지막 방까지 요소 읽기
	public String next() {

		String temp = this.list[this.sindex];
		
		this.sindex++;
		
		return temp;
	}
	

	@Override
	public String toString() {
		
		String temp = "";

		temp += "\n";
		temp += String.format("length: %d\n", this.list.length);
		temp += String.format("size: %d\n", this.index);
		temp += String.format("[\n");
		for (int i = 0; i < this.list.length; i++) {
			temp += String.format("   %d: %s\n", i, this.list[i]);
		}
		temp += String.format("]");
		temp += "\n";

		return temp;
	}

}

