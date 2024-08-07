package mnist;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.evaluation.classification.Evaluation;


public class ModelEvaluator {


    private MultiLayerNetwork model;


    public ModelEvaluator(MultiLayerNetwork model) {
        this.model = model;
    }


    public void evaluate(DataSetIterator testData) {
        System.out.println("Avaliando o modelo...");
        Evaluation eval = model.evaluate(testData);
        System.out.println(eval.stats());
    }
}
