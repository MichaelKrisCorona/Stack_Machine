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
            case _ => throw new Exception(" AddI requires two elements on the stack")
        }

        case SubI => stack match {
            case x :: y :: tail => (y - x) :: tail
            case _ => throw new Exception("SubI requires two elements on the stack")
        }

        case MultI => stack match {
            case x :: y :: tail => (x * y) :: tail
            case _ => throw new Exception("MultI requires two elements on the stack")
        }

        case DivI => stack match {
            case x :: y :: tail =>
                if (y == 0)throw new Exception("Division by Zero")
                    else (x / y) :: tail
            case _ => throw new Exception("Division requires two elements on the stack")
        }

       case ExpI => stack match{
            case x :: tail => (math.exp(x) :: tail) 
            case _ => throw new Exception("ExpI requires two elements on the stack")
        }

        case LogI => stack match{
            case x :: tail =>
                if(x <= 0) throw new Exception("LogI requires a positive number")
                    else (math.log(x)) :: tail
            case _ => throw new Exception("LogI requires at least one element on the stack")
        }

        case SinI => stack match {
            case x :: tail => math.sin(x) :: tail
            case _ => throw new Exception("SinI requires at least one element on the stack")
        }

        case CosI => stack match{
            case x :: tail => math.cos(x) :: tail
            case _ => throw new Exception("CosI requires at least one element on the stack")
        }
    }

    /* Function emulateStackMachine
       Execute the list of instructions provided as inputs using the
       emulateSingleInstruction function.
       Use foldLeft over list of instruction rather than a for loop if you can.
       Return value must be a double that is the top of the stack after all instructions
       are executed.
     */
    def emulateStackMachine(instructionList: List[StackMachineInstruction]): Double = {
        val finalStack = instructionList.foldLeft(List[Double]()) { (stack, ins) =>
            emulateSingleInstruction(stack, ins)
    }
     finalStack.headOption.getOrElse(throw new Exception("Empty stack after execution"))
 }
}