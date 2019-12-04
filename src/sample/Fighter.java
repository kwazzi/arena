package sample;

public class Fighter {
    private int health;
    private int[] attackHeight = new int[5];
    private int[] blockHeight = new int[5];

    public Fighter(){
        setHealth(5);
    }

    public int[] getAttackHeight() {
        return attackHeight;
    }

    public int[] getBlockHeight() {
        return blockHeight;
    }

    public int getHealth() {
        return health;
    }

    public void setBlockHeight(int[] blockHeight) {
        this.blockHeight = blockHeight;
    }

    public void setAttackHeight(int[] attackHeight) {
        this.attackHeight = attackHeight;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
