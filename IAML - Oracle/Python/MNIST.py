import tensorflow as tf
from tensorflow.keras import layers, models
import matplotlib.pyplot as plt
import numpy as np


#TensorFlow e Keras: Utilizados para construir e treinar a rede neural.




# Carregar o conjunto de dados MNIST
(train_images, train_labels), (test_images, test_labels) = tf.keras.datasets.mnist.load_data()


# Normalizar as imagens para valores entre 0 e 1
train_images = train_images / 255.0
test_images = test_images / 255.0


#Flatten Layer: Converte cada imagem de 28x28 pixels em um array de 784 pixels.
#Dense Layer (128 neurônios): Camada totalmente conectada com função de ativação ReLU.
#Dense Layer (10 neurônios): Camada de saída com 10 neurônios (um para cada dígito) com função de ativação softmax para classificação.
model = models.Sequential([
    layers.Flatten(input_shape=(28, 28)),
    layers.Dense(128, activation='relu'),
    layers.Dense(10, activation='softmax')
])


#Otimizador Adam: Utilizado para minimizar a função de perda.
#Função de Perda Sparse Categorical Crossentropy: Adequada para classificação de múltiplas classes.
#Métrica de Acurácia: Para avaliar a performance do modelo.
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])


# Treinamento: O modelo é treinado por 5 épocas usando as imagens e rótulos de treinamento.
model.fit(train_images, train_labels, epochs=5)


# Avaliação: O modelo é avaliado usando as imagens e rótulos de teste, e a acurácia do teste é impressa.
test_loss, test_acc = model.evaluate(test_images, test_labels)
print(f'\nTest accuracy: {test_acc}')


# Previsões: O modelo faz previsões para as imagens de teste.
predictions = model.predict(test_images)


# Função plot_image: Plota a imagem junto com a previsão do modelo.
# Função plot_value_array: Plota o vetor de previsão mostrando a probabilidade de cada classe.
# Visualização: Exibe várias imagens de teste com suas previsões e vetores de previsão lado a lado.
def plot_image(i, predictions_array, true_label, img):
    predictions_array, true_label, img = predictions_array[i], true_label[i], img[i]
    plt.grid(False)
    plt.xticks([])
    plt.yticks([])


    plt.imshow(img, cmap=plt.cm.binary)


    predicted_label = np.argmax(predictions_array)
    if predicted_label == true_label:
        color = 'blue'
    else:
        color = 'red'


    plt.xlabel(f"{predicted_label} ({100*np.max(predictions_array):2.0f}%)", color=color)


def plot_value_array(i, predictions_array, true_label):
    predictions_array, true_label = predictions_array[i], true_label[i]
    plt.grid(False)
    plt.xticks(range(10))
    plt.yticks([])
    thisplot = plt.bar(range(10), predictions_array, color="#777777")
    plt.ylim([0, 1])
    predicted_label = np.argmax(predictions_array)


    thisplot[predicted_label].set_color('red')
    thisplot[true_label].set_color('blue')


# Plotando o primeiro X testes de imagens, suas previsões e o vetor de previsão
num_rows = 5
num_cols = 2
num_images = num_rows * num_cols
plt.figure(figsize=(2*2*num_cols, 2*num_rows))
for i in range(num_images):
    plt.subplot(num_rows, 2*num_cols, 2*i+1)
    plot_image(i, predictions, test_labels, test_images)
    plt.subplot(num_rows, 2*num_cols, 2*i+2)
    plot_value_array(i, predictions, test_labels)
plt.tight_layout()
plt.show()
