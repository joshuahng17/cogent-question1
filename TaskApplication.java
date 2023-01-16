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

class TaskControls{
	public static void AddTask(TaskBean[] array, int size){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task: ");
		String name = sc.nextLine();
		TaskBean newTask = new TaskBean(size, name);
		for(int i=0;i<array.length;i++){
			if(array[i] == null) {
				array[i] = newTask;
				break;
			}
		}
		size++;
		return;
	}
	
	public static void UpdateTask(TaskBean[] array){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task to be updated: ");
		String oldName = sc.nextLine();
		System.out.println("New name of task: ");
		String newName = sc.nextLine();
		for(int i=0;i<array.length;i++){
			if(array[i] != null && array[i].getTaskName() == oldName) {
				array[i].setTaskName(newName);
				break;
			}
		}
		return;
	}
	
	public static void DeleteTask(TaskBean[] array, int size){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task to be deleted: ");
		String name = sc.nextLine();
		for(int i=0;i<array.length;i++){
			if(array[i] != null && array[i].getTaskName() == name) {
				array[i] = null;
				break;
			}
		}
		size--;
		return;
	}
	
	public static void SearchTask(TaskBean[] array){
		for(int i=0;i<array.length;i++){
			if(array[i] != null) {
				System.out.println("ID: " + array[i].getTaskId());
				System.out.println("Name: " + array[i].getTaskName() + "\n");
			}
		}
	}
}

public class TaskApplication{
	
	public static void main(String[] args){
		
		TaskBean[] TaskArray = new TaskBean[10];
		int TaskSize = 0;
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
					TaskControls.AddTask(TaskArray, TaskSize);
					System.out.println("Added a new task");
					break;
				case 2:
					TaskControls.UpdateTask(TaskArray);
					System.out.println("Updated a task");
					break;
				case 3:
					TaskControls.DeleteTask(TaskArray, TaskSize);
					System.out.println("Deleted a task");
					break;
				case 4:
					TaskControls.SearchTask(TaskArray);
					break;
				case 0:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Invalid Input");
					break;
			}
		} while(choice != 0);
		sc.close();
		return;
	}
	/*
	public static void AddTask(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task: ");
		String name = sc.nextLine();
		TaskBean newTask = new TaskBean(TaskSize, name);
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] == null)
				TaskArray[i] = newTask;
		}
		TaskSize++;
		sc.close();
		return;
	}
	
	public static void UpdateTask(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task to be updated: ");
		String oldName = sc.nextLine();
		System.out.println("New name of task: ");
		String newName = sc.nextLine();
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] != null && TaskArray[i].getTaskName() == oldName)
				TaskArray[i].setTaskName(newName);
		}
		sc.close();
		return;
	}
	
	public static void DeleteTask(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Name of task to be deleted: ");
		String name = sc.nextLine();
		for(int i=0;i<TaskArray.length;i++){
			if(TaskArray[i] != null && TaskArray[i].getTaskName() == name)
				TaskArray[i] = null;
		}
		TaskSize--;
		sc.close();
		return;
	}
	
	public static void SearchTask(){
		for(int i=0;i<TaskArray.length;i++){
			System.out.println("ID: " + TaskArray[i].getTaskId());
			System.out.println("Name: " + TaskArray[i].getTaskName() + "\n");
		}
	}
	*/
}