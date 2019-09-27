package com.aot.camunda;

public class BpmnBuilderPipeline {
	public static void main(String args[]) {
		FluentBuilderApi fba = new FluentBuilderApi();
		try {
			fba.buildProcess();
		}
		catch(Exception e) {
			System.out.println("Error building a processs using Fluent Builder");
			e.printStackTrace();
		}
	}
	
}
