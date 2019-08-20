package com.threesixty.assignment;

import static com.threesixty.assignment.cons.ProcessConstants.*;
import static com.threesixty.assignment.exception.AssignmentErrorCodes.*;

import com.threesixty.assignment.blockingqueue.BlockingQueueIntiator;
import com.threesixty.assignment.cons.Constants;
import com.threesixty.assignment.exception.AssignmentException;

public class App {

	public static void main(String[] args) throws AssignmentException {
		if(args.length == 0) {
			System.out.println(NO_PARAMETER_PASSED_DESC);
			throw new AssignmentException(NO_PARAMETER_PASSED, NO_PARAMETER_PASSED_DESC);
		}
		
		String processType = args[0];
		int counter = Constants.COUNTER;
		
		if(BLOCKING_QUEUE_PROCESS.equalsIgnoreCase(processType)) {
			BlockingQueueIntiator.process(counter);
		}else if(EXECUTOR_PROCESS.equalsIgnoreCase(processType)){
			
		}else {
			System.out.println(INVALID_INPUT_PARAMETER_DESC);
			throw new AssignmentException(INVALID_INPUT_PARAMETER, INVALID_INPUT_PARAMETER_DESC);
		}
	}
}
