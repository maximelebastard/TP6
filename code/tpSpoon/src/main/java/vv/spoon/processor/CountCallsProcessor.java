package vv.spoon.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtTargetedAccess;
import spoon.reflect.code.CtTargetedExpression;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.cu.SourceCodeFragment;
import spoon.reflect.cu.SourcePosition;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtExecutableReference;

import java.util.ArrayList;
import java.util.List;


public class CountCallsProcessor extends AbstractProcessor<CtInvocation>  {

    List<String> calls = new ArrayList<>();


    @Override
    public void process(CtInvocation element) {
        String methodCalled = "";

        //methodCalled = element.getSignature();
        //methodCalled = element.getLabel();
        //methodCalled = element.getGenericTypes().toString();
        //methodCalled = element.getArguments().toString();
        //methodCalled = element.getDocComment();
        //methodCalled = element.getType().toString();tpSpoon
        methodCalled = element.toString();

/*        SourcePosition sp = element.getPosition();
        CompilationUnit compileUnit = sp.getCompilationUnit();

        Object argument = element.getArguments().get(0);
        String snippet = "\n\t\tvv.spoon.callscounter.CallsCounter.registerCall(\"titi\");\n";

        SourceCodeFragment after = new SourceCodeFragment(compileUnit.nextLineIndex(sp.getSourceEnd()), snippet, 0);
        compileUnit.addSourceCodeFragment(after);

        String snippet = "\n tvv.spoon.callscounter.CallsCounter.registerCall(\""+methodCalled.toString()+"\"); \n";

        SourceCodeFragment after = new SourceCodeFragment(compileUnit.nextLineIndex(sp.getSourceEnd()), snippet, 0);
        compileUnit.addSourceCodeFragment(after);
        */
        calls.add(methodCalled);
    }

    @Override
    public void processingDone() {
        System.out.println("-------------------------------");
        System.out.println("   METHOD CALLS");
        System.out.println("-------------------------------");

        for(String call : calls) {
            System.out.println(call);
        }
    }
}
