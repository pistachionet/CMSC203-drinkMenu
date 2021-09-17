public class Smoothie extends Beverage{
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = .5;
    private final double PROTEIN_COST = 1.5;

    /** Constructors */
    public Smoothie(String n, SIZE s, int nof, boolean ap) {
        super(n, TYPE.SMOOTHIE, s);
        numOfFruits = nof;
        addProtein = ap;
    }

    /** Utility */
    public String toString() {
        String s = getBevName() +", " +getSize() +" " +numOfFruits +" Fruits";

        if (addProtein) {
            s += " Protein powder";
        }

        s += ", $" +calcPrice();

        return s;
    }
    public boolean equals(Smoothie s) {
        if (super.equals(s) && numOfFruits==s.getNumOfFruits() && addProtein==s.getAddProtien()) {
            return true;
        }
        else {
            return false;
        }
    }
    public double calcPrice() {
        double price = super.getBasePrice();

        if (super.getSize() == SIZE.MEDIUM) {
            price += super.getSizePrice();
        }
        else if (super.getSize() == SIZE.LARGE) {
            price += 2 * super.getSizePrice();
        }

        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }

        return price;
    }

    /** Accessors */
    public int getNumOfFruits() {
        return numOfFruits;
    }
    public boolean getAddProtien() {
        return addProtein;
    }
    public double getFruitCost() {
        return FRUIT_COST;
    }
    public double getProteinCost() {
        return PROTEIN_COST;
    }

    /** Mutators */
    public void setNumOfFruits(int nof) {
        numOfFruits = nof;
    }
    public void setProteinPowder(boolean ap) {
        addProtein = ap;
    }
}