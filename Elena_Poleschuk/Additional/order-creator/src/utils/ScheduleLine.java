package utils;

import java.util.Date;

public class ScheduleLine {
	protected Date date;
	protected double qty;
	protected int schLineID;
	
	public ScheduleLine(Date date, Double qty){
		this.date =date;
		this.qty = qty;
	}
	
	public ScheduleLine(int schLineID, Date date, double qty){
		this.date =date;
		this.qty = qty;
		this.schLineID = schLineID;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public int getSchLineID(){
		return this.schLineID;
	}
	
	public double getQty(){
		return this.qty;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public void setSchLineID(int schLineID){
		this.schLineID = schLineID;
	}
	
	public void setQty(double qty){
		this.qty = qty;
	}
	
}
