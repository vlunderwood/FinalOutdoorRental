package OutdoorRental;

class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}