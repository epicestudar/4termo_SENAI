package mnist;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;


public class NetworkConfiguration {


    private int rngSeed;
    private int numInputs;
    private int numOutputs;
    private int numHiddenNodes;


    public NetworkConfiguration(int rngSeed, int numInputs, int numOutputs, int numHiddenNodes) {
        this.rngSeed = rngSeed;
        this.numInputs = numInputs;
        this.numOutputs = numOutputs;
        this.numHiddenNodes = numHiddenNodes;
    }


    public MultiLayerConfiguration getConfiguration() {
        return new NeuralNetConfiguration.Builder()
            .seed(rngSeed)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .updater(new Adam(0.001))
            .list()
            .layer(0, new DenseLayer.Builder()
                .nIn(numInputs)
                .nOut(numHiddenNodes)
                .activation(org.nd4j.linalg.activations.Activation.RELU)
                .build())
            .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nIn(numHiddenNodes)
                .nOut(numOutputs)
                .activation(org.nd4j.linalg.activations.Activation.SOFTMAX)
                .build())
            .build();
    }
}
