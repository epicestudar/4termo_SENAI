package mnist;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;


public class Main {


    public static void main(String[] args) throws Exception {
        // Parâmetros do modelo
        int batchSize = 64;
        int rngSeed = 123;
        int numEpochs = 5;
        int numInputs = 28 * 28;
        int numOutputs = 10;
        int numHiddenNodes = 128;


        // Carregar dados
        MnistDataLoader dataLoader = new MnistDataLoader(batchSize, rngSeed);
        DataSetIterator trainData = dataLoader.getTrainData();
        DataSetIterator testData = dataLoader.getTestData();


        // Configurar a rede neural
        NetworkConfiguration netConfig = new NetworkConfiguration(rngSeed, numInputs, numOutputs, numHiddenNodes);
        MultiLayerConfiguration config = netConfig.getConfiguration();


        // Criar o modelo
        MultiLayerNetwork model = new MultiLayerNetwork(config);


        // Treinar o modelo
        ModelTrainer trainer = new ModelTrainer(model, numEpochs);
        trainer.train(trainData);


        // Avaliar o modelo
        ModelEvaluator evaluator = new ModelEvaluator(model);
        evaluator.evaluate(testData);
    }
}


