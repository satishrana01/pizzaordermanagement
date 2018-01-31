package com.pizza.shop.model;

/***
 * Model class for pizza order
 * 
 * @author Satish
 *
 */
public class Order implements Comparable<Order> {

	private String name;
	private int time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(Order object) {

		return this.name.compareTo(object.name);
	}
	
	@Override
	public String toString() {
	    return "Correct order [name=" + this.name + ", time=" + this.time + "]";
	}

}
