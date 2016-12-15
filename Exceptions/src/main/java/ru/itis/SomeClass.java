package ru.itis;

import ru.itis.custom.MyCheckedException;
import ru.itis.custom.MyUncheckedException;

import java.io.FileNotFoundException;

public class SomeClass {
    public void throwCheckedException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public void throwUncheckedException() {
        throw new IllegalArgumentException();
    }

    public void throwMyCheckedException() throws MyCheckedException {
        throw new MyCheckedException();
    }

    public void throwMyUncheckedException() {
        throw new MyUncheckedException();
    }
}
