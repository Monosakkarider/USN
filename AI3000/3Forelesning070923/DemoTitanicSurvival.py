
#Import libraries:
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt

#Upload data, Define "Sex" into numbers and fill N/A-values with mean-values:
data = pd.read_csv("Titanic.csv")
data["Sex"] = data["Sex"].map({"Female":0, "Male":1})
data["Age"].fillna(data["Age"].mean())

#Define what X and y are:
X = data[["Age","Pclass","Sex"]]
y = data["Survived"]

#Split the data into train and test data:
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.2, random_state = 22)


classifier = DecisionTreeClassifier()
classifier.fit(X_train, y_train)

y_pred = classifier.predict(X_test)

accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

plt.figure(figsize=(12,8))
plot_tree(classifier, feature_names=["Age","Pclass","Sex"], class_names=["Not Survived", "Survived"], filled = True)
plt.show()

new_data = pd.DataFrame([[22, 1, 0]], columns=["Age", "Pclass", "Sex"])
predictions = classifier.predict(new_data)
predictions_mapped = ["Survived" if pred == 1 else "Dead" for pred in predictions]

print("Predictions:", predictions_mapped)
