package org.example.interfaces;

import org.example.enums.TonoType;

public interface ICantante {
    TonoType getTono();
    void setTono(TonoType tono);
    void cantar();
}
