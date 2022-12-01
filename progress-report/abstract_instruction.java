package uk.co.noahdhollowell.emulator.instructions;

import uk.co.noahdhollowell.emulator.exceptions.InvalidValueException;
import uk.co.noahdhollowell.emulator.memory.InvalidMemoryAddressException;
import uk.co.noahdhollowell.emulator.memory.Memory;
import uk.co.noahdhollowell.emulator.memory.UnalignedMemoryAccessException;
import uk.co.noahdhollowell.emulator.registers.ProgramCounter;
import uk.co.noahdhollowell.emulator.registers.RegisterNotFoundException;
import uk.co.noahdhollowell.emulator.registers.RegisterSet;

public abstract class Instruction {

    private final String identifier;
    public final RegisterSet registers;
    protected final Memory memory;
    protected final ProgramCounter programCounter;
    private final int expectedOps;

    public Instruction(String identifier, int expectedOps) {
        this.identifier = identifier;
        this.registers = RegisterSet.getRegisters();
        this.expectedOps = expectedOps;
        this.memory = Memory.getMemory();
        this.programCounter = ProgramCounter.getProgramCounter();
    }

    public Instruction(String identifier) {
        this.identifier = identifier;
        this.registers = RegisterSet.getRegisters();
        this.expectedOps = 3;
        this.memory = Memory.getMemory();
        this.programCounter = ProgramCounter.getProgramCounter();
    }

    public int getExpectedOps() {
        return expectedOps;
    }

    public String getIdentifier() {
        return identifier;
    }

    public abstract void execute(InstructionOperands operands) throws RegisterNotFoundException, InvalidValueException, InvalidMemoryAddressException, UnalignedMemoryAccessException;

    @Override
    public String toString() {
        return "Instruction{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
