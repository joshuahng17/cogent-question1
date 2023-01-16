package com.cogent.task;

import java.util.*;

class TaskBean{
	private int taskId;
	private String taskName;
	
	public TaskBean(int taskId, String taskName){
		this.taskId = taskId;
		this.taskName = taskName;
	}
	
	public int getTaskId(){
		return taskId;
	}
	
	public String getTaskName(){
		return taskName;
	}
	
	public void setTaskId(int newId){
		taskId = newId;
	}
	
	public void setTaskName(String newName){
		taskName = newName;
	}
}

public class TaskApplication{
	
	public static void main(String[] args){
		TaskBean[] TaskArray = new TaskBean[100];
		int numberOfTasks = 0;
		System.out.println("*****Menu******");
		System.out.println("1. Add a new task");
		System.out.println("2. Update a task");
		System.out.println("3. Delete a Task");
		System.out.println("4. Search for a task");
		System.out.println("Please enter your choice!");
		System.out.println("Press 0 to exit");
		int choice;
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		while(choice !=0){
			switch(choice) {
				case 1:
					TaskArray[numberOfTasks] = new TaskBean(++numberOfTasks, "New Task");
					System.out.println("Added a new task");
					break;
				case 2:
					TaskArray[(numberOfTasks - 1)].setTaskName("New Name");
					System.out.println("Updated a task");
					break;
				case 3:
					TaskArray[numberOfTasks--] = null;
					System.out.println("Deleted a task");
					break;
				case 4:
					for(int i=0;i<numberOfTasks;i++){
						System.out.println(TaskArray[i].getTaskName());
					}
					break;
				default:
					System.out.println("Invalid Input");
					break;
			}
			choice = sc.nextInt();
		}
		sc.close();
		return;
	}
}