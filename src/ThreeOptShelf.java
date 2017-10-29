public class ThreeOptShelf {
    private Shelf myShelf;
    public ThreeOptShelf(Shelf shelf){
        myShelf = shelf;
    }
    public Shelf findThreeOptShelf(){
        int row = myShelf.getnRow(), col = myShelf.getnCol();
        for(int a_row = 0;a_row<row;a_row++){
            for( int a_col =0;a_col<col;a_col++) {
                for (int b_row = 0; b_row < row; b_row++) {
                    for (int b_col = 0; b_col < col; b_col++) {
                        for (int c_row = 0; c_row < row; c_row++) {
                            for (int c_col = 0; c_col < col; c_col++) {
                                if (isBetterToChange(new Position(a_row, a_col), new Position(b_row, b_col), new Position(c_row, c_col))) {
                                    myShelf.swap(new Position(a_row, a_col), new Position(b_row, b_col));
                                    myShelf.swap(new Position(b_row, b_col), new Position(c_row, c_col));
                                }
                            }
                        }
                    }
                }
            }
        }

        return  myShelf;
    }
    private  boolean isBetterToChange(Position positionA,Position positionB,Position positionC){
        float beforeProfit=0, afterProfit=0;
        beforeProfit = myShelf.getTotalProfit();
        myShelf.swap(positionA,positionB);
        myShelf.swap(positionB,positionC);
        afterProfit = myShelf.getTotalProfit();
        myShelf.swap(positionB,positionC);
        myShelf.swap(positionA,positionB);
        return (beforeProfit<afterProfit);
    }
}
