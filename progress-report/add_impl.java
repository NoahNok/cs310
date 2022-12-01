package uk.co.noahdhollowell.emulator.instructions.rv32i;

import uk.co.noahdhollowell.emulator.exceptions.InvalidValueException;
import uk.co.noahdhollowell.emulator.instructions.Instruction;
import uk.co.noahdhollowell.emulator.instructions.InstructionOperands;
import uk.co.noahdhollowell.emulator.registers.RegisterNotFoundException;

public class ADD extends Instruction {

    public ADD() {
        super("ADD");
    }

    @Override
    public void execute(InstructionOperands operands) throws RegisterNotFoundException, InvalidValueException {

        // Load rs1 and rs2
        int rs1 = this.registers.readInt(operands.getR1());
        int rs2 = this.registers.readInt(operands.getR2());


        // Write ADDED value back to destination (rd)
        this.registers.writeInt(operands.getDest(), rs1 + rs2);
        programCounter.increment();

    }
}
