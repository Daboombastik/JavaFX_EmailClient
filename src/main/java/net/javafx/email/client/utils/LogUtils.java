package net.javafx.email.client.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {

    public static void logException(Logger logger, Exception e, String userContext) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        StackTraceElement caller = stackTrace[2];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        logger.log(Level.SEVERE, String.format("""
                        [%s] Exception in %s.%s()
                        Context: %s
                        Exception: %s: %s
                        """,
                timestamp,
                className,
                methodName,
                userContext,
                e.getClass().getSimpleName(),
                e.getMessage()
        ), e);
    }
}