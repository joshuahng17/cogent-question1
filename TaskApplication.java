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
	
	static TaskBean[] TaskArray = new TaskBean[10];
	static int TaskSize = 0;
	
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("*****Menu******");
			System.out.println("1. Add a new task");
			System.out.println("2. Update a task");
			System.out.println("3. Delete a Task");
			System.out.println("4. Search for a task");
			System.out.println("Please enter your choice!");
			System.out.println("Press 0 to exit");
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Name of task: ");
					String name = sc.nextLine();
					AddTask(name);
					System.out.println("Added a new task");
					break;
				case 2:
					System.out.println("Name of task to be updated: ");
					String oldName = sc.nextLine();
					System.out.println("New name of task: ");
					String newName = sc.nextLine();
					UpdateTask(oldName, newName);
					System.out.println("Updated a task");
					break;
				case 3:
					System.out.println("Name of task to be deleted: ");
					String deleted = sc.nextLine();
					DeleteTask(deleted);
					System.out.println("Deleted a task");
					break;
				case 4:
					SearchTask();
					break;
				case 0:
					System.out.println("Goodbye");
				default:
					System.out.println("Invalid Input");
					break;
			}
		} while(choice != 0);
		sc.close();
		return;
	}
	
	public static void AddTask(String name){
		TaskBean newTask = new TaskBean(TaskSize, name);
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] == null)
				TaskArray[i] = newTask;
		}
		TaskSize++;
		return;
	}
	
	public static void UpdateTask(String oldName, String newName){
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] != null && TaskArray[i].getTaskName() == oldName)
				TaskArray[i].setTaskName(newName);
		}
		return;
	}
	
	public static void DeleteTask(String name){
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] != null && TaskArray[i].getTaskName() == name)
				TaskArray[i] = null;
		}
		TaskSize--;
		return;
	}
	
	public static void SearchTask(){
		for(int i=0;i<TaskArray.length;i++){
			System.out.println("ID: " + TaskArray[i].getTaskId());
			System.out.println("Name: " + TaskArray[i].getTaskName() + "\n");
		}
	}
}