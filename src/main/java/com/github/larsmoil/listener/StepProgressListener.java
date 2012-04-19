package com.github.larsmoil.listener;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;

import java.util.List;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 8:49 PM
 */
public class StepProgressListener implements ItemReadListener, ItemWriteListener, StepExecutionListener {

    private DateTime started;
    private int read, written;

    private final Logger logger = LoggerFactory.getLogger(StepProgressListener.class);

    @Override
    public void beforeRead() {
        // Don't care
    }

    @Override
    public synchronized void afterRead(Object item) {
        if (item != null) {
            read++;
        }
    }

    @Override
    public void onReadError(Exception ex) {
        // Don't care
    }

    @Override
    public void beforeWrite(List items) {
        // Don't care
    }

    @Override
    public synchronized void afterWrite(List items) {
        written += items.size();
        logger.info(String.format("read/written/skipped : %5d / %5d / %5d", read, written, read - written));
    }

    @Override
    public void onWriteError(Exception exception, List items) {
        // Don't care
    }

    @Override
    public synchronized void beforeStep(StepExecution stepExecution) {
        started = new DateTime();
        read = 0;
        written = 0;
    }

    @Override
    public synchronized ExitStatus afterStep(StepExecution stepExecution) {
        logger.info(String.format("Step %s finished in %s.", stepExecution.getStepName(), new Duration(started, new DateTime())));

        return stepExecution.getExitStatus();
    }
}
