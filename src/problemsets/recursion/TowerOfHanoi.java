package problemsets.recursion;

public final class TowerOfHanoi {
    /**
     * @param src -> source stack;
     * @param dest -> destination stack;
     * @param aux -> auxilary stack to support
     * @param n -> the size of tower
     */
    public static void towerOfHanoi(char src, char dest, char aux, int n){
        if(n == 1){
            System.out.println(src + "->" + dest);
            return;
        }
        // move the n-1 wala stack to auxilary
        towerOfHanoi(src, aux, dest, n-1);
        // move the nth disc to dest
        System.out.println(src + "->" + dest);
        // move back the n-1 stack to dest
        towerOfHanoi(aux , dest, src, n-1);
    }
}
