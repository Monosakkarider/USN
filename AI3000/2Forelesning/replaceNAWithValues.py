import pandas as pd

data = pd.read_csv("train.csv", nrows=10)
x=data.iloc[:, 0:20]
y = data.iloc[:, -1]

data_new= data.fillna(0)
data_new = data.fillna(data.median())
print(data)
print(data_new)
