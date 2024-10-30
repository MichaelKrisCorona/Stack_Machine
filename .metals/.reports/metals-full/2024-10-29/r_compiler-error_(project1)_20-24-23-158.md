file:///D:/Projects/project1/src/main/scala/edu/colorado/csci3155/project1/StackMachineEmulator.scala
### java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/19155/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.12.17/scala-library-2.12.17-sources.jar!/scala/collection/immutable/List.scala

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.12.17
Classpath:
<WORKSPACE>\.bloop\project1\bloop-bsp-clients-classes\classes-Metals-vUM4iuHvQl6cq5n6_h5_Ig== [exists ], <HOME>\AppData\Local\bloop\cache\semanticdb\com.sourcegraph.semanticdb-javac.0.10.3\semanticdb-javac-0.10.3.jar [exists ], <HOME>\.sbt\boot\scala-2.12.17\lib\scala-library.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scalactic\scalactic_2.12\3.0.5\scalactic_2.12-3.0.5.jar [exists ], <HOME>\.sbt\boot\scala-2.12.17\lib\scala-reflect.jar [exists ]
Options:
-Yrangepos -Xplugin-require:semanticdb


action parameters:
offset: 2769
uri: file:///D:/Projects/project1/src/main/scala/edu/colorado/csci3155/project1/StackMachineEmulator.scala
text:
```scala
package edu.colorado.csci3155.project1

import java.util.Stack


sealed trait StackMachineInstruction
case object AddI extends StackMachineInstruction
case object SubI extends StackMachineInstruction
case object MultI extends StackMachineInstruction
case object DivI extends StackMachineInstruction
case object ExpI extends StackMachineInstruction
case object LogI extends StackMachineInstruction
case object SinI extends StackMachineInstruction
case object CosI extends StackMachineInstruction
case class PushI(f: Double) extends StackMachineInstruction
case object PopI extends StackMachineInstruction


object StackMachineEmulator {

    /* Function emulateSingleInstruction
        Given a list of doubles to represent a stack and a single instruction of type StackMachineInstruction
        Return a stack that results when the instruction is executed from the stack.
        Make sure you handle the error cases: eg., stack size must be appropriate for the instruction
        being executed. Division by zero, log of a non negative number
        Throw an exception or assertion violation when error happens.

     */
    def emulateSingleInstruction(stack: List[Double], ins: StackMachineInstruction): List[Double] = ins match{
        case PushI(f) => f :: stack

        case PopI => stack match {
            case Nil => throw new Exception("Pop on empty stack")
            case _ :: tail => tail
        }  

        case AddI => stack match {
            case x :: y :: tail => (x + y) :: tail
            case _ => throw new Exception(" AddI requires two elements on the satck")
        }

        case SubI => stack match {
            case x :: y :: tail => (x - y) :: tail
            case _ => throw new Exception("SubI requires two elements on the satck")
        }

        case MultI => stack match {
            case x :: y :: tail => (x * y) :: tail
            case _ => throw new Exception("MultI requires two elements on the satck")
        }

        case DivI => stack match {
            case x :: y :: tail =>
                if (b == 0)throw new Exception("Division by Zero")
                    else (x / y) :: tail
            case _ => throw new Exception("Division requires two elements on the satck")
        }

        case ExpI => stack match{
            case x :: y :: tail => (math.pow(x,y)) :: tail
            case _ => throw new Exception("ExpI requires two elements on the satck")
        }

        case LogI => stack match{
            case x :: tail =>
                if(a <= 0) throw new Exception("LogI requires a positive number")
                    else math.log(a) :: tail
            case _ => throw new Exception("LogI requires at least one element on the stack")
        }
        
        case SinI => stack m@@
    }

    /* Function emulateStackMachine
       Execute the list of instructions provided as inputs using the
       emulateSingleInstruction function.
       Use foldLeft over list of instruction rather than a for loop if you can.
       Return value must be a double that is the top of the stack after all instructions
       are executed.
     */
    def emulateStackMachine(instructionList: List[StackMachineInstruction]): Double =
        ???

}
```



#### Error stacktrace:

```
java.base/sun.nio.fs.WindowsPathParser.normalize(WindowsPathParser.java:182)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:153)
	java.base/sun.nio.fs.WindowsPathParser.parse(WindowsPathParser.java:77)
	java.base/sun.nio.fs.WindowsPath.parse(WindowsPath.java:92)
	java.base/sun.nio.fs.WindowsFileSystem.getPath(WindowsFileSystem.java:232)
	java.base/java.nio.file.Path.of(Path.java:147)
	java.base/java.nio.file.Paths.get(Paths.java:69)
	scala.meta.io.AbsolutePath$.apply(AbsolutePath.scala:58)
	scala.meta.internal.metals.MetalsSymbolSearch.$anonfun$definitionSourceToplevels$2(MetalsSymbolSearch.scala:70)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.metals.MetalsSymbolSearch.definitionSourceToplevels(MetalsSymbolSearch.scala:69)
	scala.meta.internal.pc.completions.MatchCaseCompletions.scala$meta$internal$pc$completions$MatchCaseCompletions$$sortSubclasses(MatchCaseCompletions.scala:368)
	scala.meta.internal.pc.completions.MatchCaseCompletions$MatchKeywordCompletion.contribute(MatchCaseCompletions.scala:305)
	scala.meta.internal.pc.CompletionProvider.filterInteresting(CompletionProvider.scala:405)
	scala.meta.internal.pc.CompletionProvider.safeCompletionsAt(CompletionProvider.scala:569)
	scala.meta.internal.pc.CompletionProvider.completions(CompletionProvider.scala:59)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$complete$1(ScalaPresentationCompiler.scala:214)
```
#### Short summary: 

java.nio.file.InvalidPathException: Illegal char <:> at index 3: jar:file:///C:/Users/19155/AppData/Local/Coursier/cache/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.12.17/scala-library-2.12.17-sources.jar!/scala/collection/immutable/List.scala