package com.shrikant.problems.stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//This question was asked in amazon interview where you have to process the function call stack and calculate total
//exclusive  time taken by a each function.
//exclusive time : is time taken only by that function. If function calls another function(s) their execution time will 
//substracted from the current function because when called functions are running parent function is waiting (assume all calls are synchronous)

/*input call stack file looks like this.
foo:start:0
bar:start:2
baz:start:4 
baz:end:5  
bar:end:6  
test:start:7
test:end:9   
baz:start:10 
baz:end:13 
foo:end:14 
*/

/*output should produce exclusive time for each function. If function is called more than once, its exclusive time
  should be summed. 

   baz, 4 (1 + 3)
   bar, 3 (4 - 1)
   test, 2  
   foo, 5 (14 - 4 -2 -3)  
*/

/*
  Note: 1. Consider all calls are synchronous
        2. No simultaneous calls (threaded)
        3. input is valid and sorted in that order.
        4. No recursive calls or inner function calling parent again.   
*/
public class CallStackProcessing {
    
    public HashMap<String, Integer> getExclusiveTime(List<Tuple> list) {

        HashMap<String, Integer> result = new HashMap<>();
        Stack<StackTuple> callStack = new Stack<>();
        for(Tuple tuple : list) 
        {
            if (callStack.empty() && tuple.tag.equals("start")) {
                callStack.push(new StackTuple(tuple));
            } 
            else
            {
                StackTuple peek = callStack.peek();
                if (peek.functionName.equals(tuple.functionName) && peek.tag.equals("start") && tuple.tag.equals("end"))
                {
                    StackTuple poped = callStack.pop();
                    Integer ex = tuple.time - poped.time - poped.totalChildTime;
                    result.put(tuple.functionName, result.getOrDefault(tuple.functionName, 0) + ex);
                    if (!callStack.empty())
                    {
                        StackTuple parent = callStack.peek();
                        parent.totalChildTime += tuple.time - poped.time;                    
                    }                    
                } else {
                    callStack.push(new StackTuple(tuple));
                }
            }
        }

        return result;
    }

    public List<Tuple> processLog(List<String> logFileContent) {
        List<Tuple> result = new ArrayList<>();
        for(String line : logFileContent) {
            String[] arr = line.split(":");
            Tuple newTuple = new Tuple(arr[0], arr[1], Integer.parseInt(arr[2]));
            result.add(newTuple);
        }
        return result;
    }
    
    class StackTuple extends Tuple {

        int totalChildTime = 0;
        public StackTuple(Tuple tuple) {
            super(tuple);
        }
    }

    class Tuple {
        String functionName;
        String tag; //can be "start" or "end"
        int time;

        Tuple(String functionName, String tag, int time) {
            this.functionName = functionName;
            this.tag = tag;
            this.time = time;
        }

        Tuple(Tuple tuple) {
            this.functionName = tuple.functionName;
            this.tag = tuple.tag;
            this.time = tuple.time;
        }
    }
}
