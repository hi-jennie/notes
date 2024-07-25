package CS61B.week5;


public interface DisJointSets {

    void connect(int p, int q);

    boolean isConnected(int p, int q);

}