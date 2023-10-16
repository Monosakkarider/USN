import pandas as pd
from sklearn.ensemble import ExtraTreesClassifier
import numpy as np
import matplotlib.pyplot as plt

#Leser data fra csv-fila
data = pd.read_csv("train.csv")

#erstatter N/A verdier med faktiske verdier (i dette tilfelle median)
data_new= data.fillna(0)
data_new = data.fillna(data.median())

#Leser x og y med rette values
x = data_new.iloc[:, 0:20]
y = data_new.iloc[:, -1]

model = ExtraTreesClassifier()
model.fit(x,y)
print(model.feature_importances_)

feat_importances = pd.Series(model.feature_importances_, index = x.columns)

feat_importances.nlargest(5).plot(kind='barh')
plt.show()
