package org.grobid.core.data;

import org.grobid.core.utilities.OffsetPosition;
import org.grobid.core.utilities.UnitUtilities;

/**
 * Class for managing a quantity representation. A quantity is a basically a value associated to a type
 * (type of the measurement) and a unit. Quantities are combined to form a measurement.
 *
 * @author Patrice Lopez
 */
public class Quantity {

    private String rawString = null;

    private UnitUtilities.Unit_Type type; // type of measurement
    private Unit rawUnit = null;
    private Unit normalizedUnit = null; // which gives also the system of the unit (SI, imperial, etc.)
    private String rawValue = null;
    private double normalizedValue = 0.0;

    // as a condition, when the normalized unit is instanciated, its type must be the same as the type
    // of the quantity

    // offset for the value only, the offsets for the unit expression are available in the raw Unit object
    // (given the fact that the same unit can be shared by several Quantity object)
    private OffsetPosition offsets = null;

    public Quantity() {
    }

    public Quantity(String rawString) {
        this.rawString = rawString;
    }

    public String getRawString() {
        return rawString;
    }

    public void setRawString(String raw) {
        this.rawString = raw;
    }

    public UnitUtilities.Unit_Type getType() {
        return type;
    }

    public void setType(UnitUtilities.Unit_Type type) {
        this.type = type;
    }

    public Unit getRawUnit() {
        return rawUnit;
    }

    public void setRawUnit(Unit raw) {
        this.rawUnit = raw;
    }

    public Unit getNormalizedUnit() {
        return normalizedUnit;
    }

    public void setNormalizedUnit(Unit normalized) {
        this.normalizedUnit = normalized;
    }

    public String getRawValue() {
        return rawValue;
    }

    public void setRawValue(String raw) {
        this.rawValue = raw;
    }

    public double getNormalizedValue() {
        return normalizedValue;
    }

    public void setNormalizedValue(double normalized) {
        this.normalizedValue = normalized;
    }

    public void setOffsetStart(int start) {
        if (offsets == null)
            offsets = new OffsetPosition();
        offsets.start = start;
    }

    public int getOffsetStart() {
        if (offsets != null)
            return offsets.start;
        else return -1;
    }

    public void setOffsetEnd(int end) {
        if (offsets == null)
            offsets = new OffsetPosition();
        offsets.end = end;
    }

    public int getOffsetEnd() {
        if (offsets != null)
            return offsets.end;
        else return -1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        if (type != null)
            builder.append(type.getName()).append("\t");
        if (rawValue != null)
            builder.append(rawValue).append("\t");
        if (rawUnit != null)
            builder.append(rawUnit.toString()).append("\t");
        if (offsets != null)
            builder.append(offsets.toString());
        builder.append(" ]");
        return builder.toString();
    }

}