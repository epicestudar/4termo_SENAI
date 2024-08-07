

# Importar bibliotecas necessárias
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report, accuracy_score


dados = pd.read_csv('Python/src/fraud_data.csv')


# Selecionar características (features) e rótulos (labels)
X = dados.drop('is_fraud', axis=1)  # Características
y = dados['is_fraud']  # Rótulos


# Dividir dados em conjuntos de treinamento e teste
X_treino, X_teste, y_treino, y_teste = train_test_split(X, y, test_size=0.2, random_state=42)


# Treinar modelo de Floresta Aleatória
modelo = RandomForestClassifier(n_estimators=100, random_state=42)
modelo.fit(X_treino, y_treino)


# Fazer previsões no conjunto de teste
y_pred = modelo.predict(X_teste)


# Avaliar modelo
print('Acurácia:', accuracy_score(y_teste, y_pred))
print('Relatório de Classificação:')
print(classification_report(y_teste, y_pred))
