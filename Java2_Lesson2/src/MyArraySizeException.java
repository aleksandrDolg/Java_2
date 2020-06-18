public class MyArraySizeException extends Exception {
    private int arrHeight;
    private int arrLength;

    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message,int arrLength, int arrHeight) {
        super(message);
        this.arrHeight = arrHeight;
        this.arrLength = arrLength;
    }

    public String toString (){
        return getMessage()+String.format(". Заданный размер: %dx%d.", arrLength, arrHeight);
    }
}
