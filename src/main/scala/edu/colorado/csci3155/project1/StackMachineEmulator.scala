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
            case Nil => throw new Exception("AddI on empty stack")
            case a :: b :: tail => (a + b) :: tail
        }

        case SubI => stack match {
            case a :: b :: tail => (a - b) :: tail
            case _ => throw new Exception("SubI requires two elements")
        }

        case MultI => stack match {
            case a :: b :: tail => (a * b) :: tail
            case _ => throw new Exception("MultI requires two elements")
        }

        case DivI => stack match {
            case a :: b :: tail =>
                if (b == 0)throw new Exception("Division by Zero")
                    else (a / b) :: tail
            case _ => throw new Exception("Division requires two elements")
        }
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