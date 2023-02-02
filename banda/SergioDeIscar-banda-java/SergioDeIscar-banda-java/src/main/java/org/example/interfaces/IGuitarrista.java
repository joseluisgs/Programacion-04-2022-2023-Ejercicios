package org.example.interfaces;

import org.example.enums.GuitarraType;

public interface IGuitarrista {
    GuitarraType getGuitarra();
    void setGuitarra(GuitarraType guitarra);
    void guitarrear();
}
