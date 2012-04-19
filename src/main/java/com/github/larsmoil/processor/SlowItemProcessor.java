package com.github.larsmoil.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/17/12
 *         Time: 8:23 PM
 */
public class SlowItemProcessor implements ItemProcessor<String, String> {

    private final Logger logger = LoggerFactory.getLogger(SlowItemProcessor.class);

    @Override
    public String process(String item) throws Exception {
        logger.debug("Slowly processing {}", item);
        Thread.sleep(1);
        logger.trace("Done processing   {}", item);
        return item;
    }
}
