
public class GreedyShelfThread extends Thread {
    private ShelfFrame frame;
    private int startItem, endItem;
    private int row,col;
    private float maxProfit=-1;
    private Shelf maxShelf = null;
    public GreedyShelfThread(ShelfFrame frame, int startItem,int endItem,int row,int col){
        this.frame=frame;
        this.startItem = startItem;
        this.endItem = endItem;
        this.row = row;
        this.col =col;
    }

    @Override
    public void run() {
        for(int item= startItem;item<endItem;item++) {
            Shelf shelf = new GreedyShelf(frame).GreedyFromPoint(row, col, item);
            shelf = new TwoOptShelf(shelf).findTwoOptShelf();
            if (shelf.getTotalProfit() > maxProfit) {
                maxProfit = shelf.getTotalProfit();
                maxShelf = shelf;
            }
        }
    }

    public Shelf getMaxShelf() {
        return maxShelf;
    }
}
