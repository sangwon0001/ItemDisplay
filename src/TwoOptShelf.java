public class TwoOptShelf {
    private Shelf myShelf;
    public TwoOptShelf(Shelf shelf){
        myShelf = shelf;
    }
    public Shelf findTwoOptShelf(){
        //TODO 여기다가 만들어야됨
        int row = myShelf.getnRow(), col = myShelf.getnCol();
        for(int i = 0;i<row;i++){
            for( int j =0;j<col;j++) {
                for (int k = 0; k < row; k++) {
                    for (int l = 0; l < col; l++) {
                        if(isBetterToChange(new Position(i,j),new Position(k,l)))
                            myShelf.swap(new Position(i,j),new Position(k,l));
                    }
                }
            }
        }

        return  myShelf;
    }
    private  boolean isBetterToChange(Position positionA,Position positionB){
        float beforeProfit=0, afterProfit=0;
        beforeProfit = myShelf.getTotalProfit();
        myShelf.swap(positionA,positionB);
        afterProfit = myShelf.getTotalProfit();
//        if( beforeProfit<afterProfit){
//            System.out.println("find "+positionA+positionB);
//        }
        myShelf.swap(positionA,positionB);
        return (beforeProfit<afterProfit);
    }
}
