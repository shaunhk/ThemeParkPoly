package behaviours;

import people.Visitor;

public interface ISecurity {

    default boolean isAllowed(Visitor visitor){
        return true;
    }
}
