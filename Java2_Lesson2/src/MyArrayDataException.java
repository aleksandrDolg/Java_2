public class MyArrayDataException extends NumberFormatException {
    private int row;
    private int column;

    public MyArrayDataException(String message, int row, int column) {
        super(message);
        this.row = row;
        this.column = column;
    }

    public String toString (){
        return getMessage() + " (строка: " + row + ", столбец: " + column + ")";
    }

}
