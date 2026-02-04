package com.durable.scheduler;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.durabletask.*;
import com.microsoft.durabletask.azurefunctions.DurableClientContext;
import com.microsoft.durabletask.azurefunctions.DurableClientInput;

public class SchedulerFunction {

    @FunctionName("HelloWorldScheduler")
    public void run(
            @TimerTrigger(
                    name = "timer",
                    schedule = "0 */1 * * * *"   // every 1 minute
            ) String timerInfo,

            @DurableClientInput(name = "durableClient")
            DurableClientContext clientContext,

            ExecutionContext context
    ) {
        DurableTaskClient client = clientContext.getClient();
        String instanceId =
                client.scheduleNewOrchestrationInstance("HelloWorldOrchestrator");

        context.getLogger()
                .info("Started orchestration with ID = " + instanceId);
    }
}
