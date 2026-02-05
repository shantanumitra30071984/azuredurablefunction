package com.durable.activity;

import com.durable.util.DbUtil;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

import java.sql.Connection;

public class HelloWorldActivity {

    @FunctionName("HelloWorldActivity")
    public void run(
            @DurableActivityTrigger(name = "input")
            String input,
            ExecutionContext context
    ) throws Exception {

        context.getLogger().info("🔥 Hello World");
        try (Connection con = DbUtil.getConnection()) {
            var ps = con.prepareStatement(
                    "INSERT INTO student(name) VALUES (?)"
            );
            ps.setString(1, "John");
            ps.executeUpdate();
        }
        context.getLogger().info("Saved employee to DB");
    }
}
