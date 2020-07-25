package org.steam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import settings.Utilities;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main (String[] args){
        Utilities.printMessage("Hello World 2");
        logger.trace("Trace Test");
        logger.info("Info Test");
        logger.debug("Debug test");
        logger.warn("Warn test");
        logger.error("Error Test");
        logger.fatal("Fatal test");
    }
}
