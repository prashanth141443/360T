package com.threesixty.assignment.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author prasanth.penumala This class is the initiator class to produce and
 *         consume messages.
 *
 */
public class BlockingQueueIntiator {

	public static void process(int counter) {
		BlockingQueue<String> producerQueue = new ArrayBlockingQueue<String>(counter);
		BlockingQueue<String> consumerQueue = new ArrayBlockingQueue<String>(counter);
		BlockingPlayer initiatorPlayer = new BlockingPlayer(producerQueue, consumerQueue, true, counter);
		BlockingPlayer receiverPlayer = new BlockingPlayer(producerQueue, consumerQueue, false, counter);
		new Thread(initiatorPlayer).start();
		new Thread(receiverPlayer).start();
	}
}
