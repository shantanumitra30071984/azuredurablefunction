package com.durable.orchestrator;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.durabletask.*;
import com.microsoft.durabletask.azurefunctions.DurableOrchestrationTrigger;

public class HelloWorldOrchestrator {

    @FunctionName("HelloWorldOrchestrator")
    public String orchestrator(
            @DurableOrchestrationTrigger(name = "context")
            TaskOrchestrationContext context
    ) {
        context.callActivity("HelloWorldActivity");
        return "DONE";
    }
}
