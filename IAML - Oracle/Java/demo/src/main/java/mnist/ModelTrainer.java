package mnist;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;


public class ModelTrainer {


    private MultiLayerNetwork model;
    private int numEpochs;


    public ModelTrainer(MultiLayerNetwork model, int numEpochs) {
        this.model = model;
        this.numEpochs = numEpochs;
    }


    public void train(DataSetIterator trainData) {
        model.init();
        model.setListeners(new ScoreIterationListener(100));
        System.out.println("Treinando o modelo...");
        for (int i = 0; i < numEpochs; i++) {
            model.fit(trainData);
        }
    }
}
