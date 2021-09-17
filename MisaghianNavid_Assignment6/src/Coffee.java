public class Coffee extends Beverage{
    private boolean extraShot;
    private boolean extraSyrup;
    private final double SHOT_COST = .5;
    private final double SYRUP_COST = .5;

    /** Constructors */
    public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
        super(n, TYPE.COFFEE, s);
        extraShot = shot;
        extraSyrup = syrup;
    }

    /** Utility */
    public String toString() {
        String s = getBevName() +", " +getSize();

        if (extraShot) {
            s += " Extra shot";
        }
        if (extraSyrup) {
            s += " Extra syrup";
        }

        s += ", $" +calcPrice();

        return s;
    }
    public double calcPrice() {
        double price = super.getBasePrice();

        if (super.getSize() == SIZE.MEDIUM) {
            price += super.getSizePrice();
        }
        else if (super.getSize() == SIZE.LARGE) {
            price += 2 * super.getSizePrice();
        }

        if (extraShot) {
            price += SHOT_COST;
        }
        if (extraSyrup) {
            price += SYRUP_COST;
        }

        return price;
    }
    public boolean equals(Coffee c) {
        if (super.equals(c) && extraShot==c.getExtraShot() && extraSyrup==c.getExtraSyrup()) {
            return true;
        }
        else {
            return false;
        }
    }

    /** Accessors */
    public boolean getExtraShot() {
        return extraShot;
    }
    public boolean getExtraSyrup() {
        return extraSyrup;
    }
    public double getShotCost() {
        return SHOT_COST;
    }
    public double getSyrupCost() {
        return SYRUP_COST;
    }

    /** Mutators */
    public void setExtraShot(boolean shot) {
        extraShot = shot;
    }
    public void setExtraSyrup(boolean syrup) {
        extraSyrup = syrup;
    }
}