public class SequenceGenerator implements Runnable {

    private final NumberGenerator numberGenerator;
    private final int result;

    public SequenceGenerator(NumberGenerator numberGenerator, int result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numberGenerator.printNumbers(result);
    }
}
