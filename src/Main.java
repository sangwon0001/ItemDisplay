import java.util.ArrayList;

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

        /*여기부터
        int THREAD_NUM= 4;
        ArrayList<GreedyShelfThread> threads= new ArrayList<>();
        for (int i = 0;i<THREAD_NUM;i++){
            GreedyShelfThread thread = new GreedyShelfThread(frame,
                    (row_col*row_col/THREAD_NUM)*i,
                    (row_col*row_col/THREAD_NUM)*(i+1)-1,
                    row_col/2,row_col/2);
            thread.start();
            threads.add(thread);
        }
        for(GreedyShelfThread thread:threads) {
            try {
                thread.join();
                Shelf shelf = thread.getMaxShelf();
                if (shelf.getTotalProfit() > maxProfit) {
                    maxProfit = shelf.getTotalProfit();
                    maxShelf = shelf;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //여기까지가 쓰레드
        //*/
        //* 이부분이 일반
        for(int item= 0;item<row_col*row_col;item++) {
//            Shelf shelf = greedyShelf.GreedyFromPoint(row_col/2, row_col/2, item);
            Shelf shelf = greedyShelf.GreedyFromPoint(0, 0, item);
            shelf = new TwoOptShelf(shelf).findTwoOptShelf();
            shelf = new ThreeOptShelf(shelf).findThreeOptShelf();
//            System.out.println(shelf.toString() + " total profit is " + shelf.getTotalProfit());
            if (shelf.getTotalProfit() > maxProfit) {
                maxProfit = shelf.getTotalProfit();
                maxShelf = shelf;
            }
        }
        //*/
        System.out.println(
                "Greedy final is \n"+maxShelf.toString() + " total profit is " + maxProfit);

        TwoOptShelf twoOptShelf = new TwoOptShelf(maxShelf);
        Shelf twoShelf =  twoOptShelf.findTwoOptShelf();

        System.out.println(
                "TwoOpt final is \n"+twoShelf.toString() + " total profit is " + twoShelf.getTotalProfit());

        twoOptShelf = new TwoOptShelf(twoShelf);
        twoShelf =  twoOptShelf.findTwoOptShelf();

        System.out.println(
                "TwoOpt final is \n"+twoShelf.toString() + " total profit is " + twoShelf.getTotalProfit());

        ThreeOptShelf threeOptShelf = new ThreeOptShelf(twoShelf);
        Shelf threeShelf = threeOptShelf.findThreeOptShelf();
        System.out.println(
                "ThreeOpt final is \n"+threeShelf.toString() + " total profit is " + threeShelf.getTotalProfit());

        System.out.println(
                "Time is "+(float)(System.currentTimeMillis()-start)/1000 +"sec");

    }
}
