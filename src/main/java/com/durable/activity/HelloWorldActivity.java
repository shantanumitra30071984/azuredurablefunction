package com.durable.activity;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class HelloWorldActivity {

    @FunctionName("HelloWorldActivity")
    public void run(
            @DurableActivityTrigger(name = "input")
            String input,
            ExecutionContext context
    ) {
        context.getLogger().info("🔥 Hello World");
    }
}
