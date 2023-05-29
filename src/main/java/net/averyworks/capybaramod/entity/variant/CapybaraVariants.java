package net.averyworks.capybaramod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CapybaraVariants {

    DEFAULT(0),
    DARKER(1),
    WHITE(2);

    private static final CapybaraVariants[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(CapybaraVariants::getID)).toArray(CapybaraVariants[]::new);
    private final int id;
    CapybaraVariants(int id){
        this.id =id;
    }
    public int getID(){return this.id;}

    public static CapybaraVariants byId(int id){
        return BY_ID[id % BY_ID.length];
    }

}
