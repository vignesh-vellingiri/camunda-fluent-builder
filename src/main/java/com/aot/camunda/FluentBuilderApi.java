package com.aot.camunda;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.GatewayDirection;

import java.io.File;
import java.io.IOException;

public class FluentBuilderApi {

	public void buildProcess() throws IOException {
        BpmnModelInstance modelInstance =  Bpmn.createProcess()   
	        	.name("Example process")
	        	.executable()
            .startEvent()
            .userTask()
            .id("assignApprover")
            .name("Assign Approver")
            .camundaAssignee("demo")
            .endEvent()
            .id("endEvent")
            //.connectTo("endEvent")
            
            .done();
            
            

        // validate and write model to file
        Bpmn.validateModel(modelInstance);
        File file = new File("bpmn-model-1.bpmn");
        file.createNewFile();

        String bpmnString = Bpmn.convertToString(modelInstance);
        System.out.println("bpmnString");
        System.out.println(bpmnString);

        Bpmn.writeModelToFile(file, modelInstance);
    }
}