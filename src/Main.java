/**
 * Created by dhtpr on 2017-10-20.
 */
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        int row_col = 3;
        int row_col = 15;
        ItemProfits.makeItemProfitTable("table"+row_col+"by"+row_col+".txt",row_col);
        ShelfFrame frame = new ShelfFrame(row_col,row_col);
        GreedyShelf greedyShelf = new GreedyShelf(frame);
        float maxProfit=-1;
        Shelf maxShelf = null;
        for(int item= 0;item<row_col*row_col;item++) {
            Shelf shelf = greedyShelf.GreedyFromPoint(row_col/2, row_col/2, item);
//            Shelf shelf = greedyShelf.GreedyFromPoint(0, 0, item);
            shelf = new TwoOptShelf(shelf).findTwoOptShelf();
//            System.out.println(shelf.toString() + " total profit is " + shelf.getTotalProfit());
            if (shelf.getTotalProfit() > maxProfit) {
                maxProfit = shelf.getTotalProfit();
                maxShelf = shelf;
            }
        }
        System.out.println(
                "Greedy final is \n"+maxShelf.toString() + " total profit is " + maxProfit);

        TwoOptShelf twoOptShelf = new TwoOptShelf(maxShelf);
        Shelf twoShelf =  twoOptShelf.findTwoOptShelf();

        System.out.println(
                "TwoOpt final is \n"+twoShelf.toString() + " total profit is " + twoShelf.getTotalProfit());
        System.out.println(
                "Time is "+(System.currentTimeMillis()-start));

    }
}
