public class TwoOptShelf {
    private Shelf myShelf;
    public TwoOptShelf(Shelf shelf){
        myShelf = shelf;
    }
    public Shelf findTwoOptShelf(){
        //TODO 여기다가 만들어야됨
        return  myShelf;
    }
    private  boolean isBetterToChange(Position positionA,Position positionB){
        float beforeProfit=0, afterProfit=0;
        beforeProfit = myShelf.getProfitFromPoint(positionA)+myShelf.getProfitFromPoint(positionB);
        afterProfit = myShelf.getProfitFromPoint(positionA,myShelf.getItem(positionB))
                + myShelf.getProfitFromPoint(positionB,myShelf.getItem(positionA));
        return beforeProfit<afterProfit;
    }
}
