package mnist;

import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public class MnistDataLoader {


    private int batchSize;
    private int rngSeed;


    public MnistDataLoader(int batchSize, int rngSeed) {
        this.batchSize = batchSize;
        this.rngSeed = rngSeed;
    }


    public DataSetIterator getTrainData() throws Exception {
        return new org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator(batchSize, true, rngSeed);
    }


    public DataSetIterator getTestData() throws Exception {
        return new org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator(batchSize, false, rngSeed);
    }
}
